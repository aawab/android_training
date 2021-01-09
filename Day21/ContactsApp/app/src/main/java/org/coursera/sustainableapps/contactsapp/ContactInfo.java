package org.coursera.sustainableapps.contactsapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.VisualVoicemailSmsFilterSettings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class ContactInfo extends AppCompatActivity {

    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;

    TextView tvContChar, tvContName;
    ImageView ivCall, ivMail, ivEdit, ivDelete;
    EditText etContName, etContMail, etContTel;
    Button btnSubmit;

    boolean edit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);

        tvContChar=findViewById(R.id.tvContChar);
        tvContName=findViewById(R.id.tvContName);

        ivCall=findViewById(R.id.ivCall);
        ivMail=findViewById(R.id.ivMail);
        ivEdit=findViewById(R.id.ivEdit);
        ivDelete=findViewById(R.id.ivDelete);

        etContName=findViewById(R.id.etContName);
        etContMail=findViewById(R.id.etContMail);
        etContTel=findViewById(R.id.etContTel);

        btnSubmit=findViewById(R.id.btnSubmit);

        etContName.setVisibility(View.GONE);
        etContMail.setVisibility(View.GONE);
        etContTel.setVisibility(View.GONE);
        btnSubmit.setVisibility(View.GONE);

        final int index = getIntent().getIntExtra("index",0);

        etContName.setText(ApplicationClass.contacts.get(index).getName());
        etContMail.setText(ApplicationClass.contacts.get(index).getEmail());
        etContTel.setText(ApplicationClass.contacts.get(index).getNumber());

        tvContChar.setText(ApplicationClass.contacts.get(index).getName().toUpperCase().charAt(0)+"");
        tvContName.setText(ApplicationClass.contacts.get(index).getName());


        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri  = "tel:" + ApplicationClass.contacts.get(index).getNumber();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });

        ivMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL,ApplicationClass.contacts.get(index).getEmail());
                startActivity(intent);
            }
        });

        ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit=!edit;
                if(edit){
                    etContMail.setVisibility(View.VISIBLE);
                    etContName.setVisibility(View.VISIBLE);
                    etContTel.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.VISIBLE);
                }
                else{
                    etContName.setVisibility(View.GONE);
                    etContMail.setVisibility(View.GONE);
                    etContTel.setVisibility(View.GONE);
                    btnSubmit.setVisibility(View.GONE);
                }
            }
        });

        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder dialog = new AlertDialog.Builder(ContactInfo.this);
                dialog.setMessage("Are you sure you want to delete this contact?");
                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showProgress(true);
                        tvLoad.setText("Deleting contact..please wait");
                        Backendless.Persistence.of(Contact.class).remove(ApplicationClass.contacts.
                                get(index), new AsyncCallback<Long>() {
                            @Override
                            public void handleResponse(Long response) {
                                ApplicationClass.contacts.remove(index);
                                Toast.makeText(getApplicationContext(),"Deleted successfully",
                                        Toast.LENGTH_SHORT).show();
                                setResult(RESULT_OK);
                                ContactInfo.this.finish();
                            }

                            @Override
                            public void handleFault(BackendlessFault fault) {
                                Toast.makeText(getApplicationContext(),"Error: " + fault.
                                        getMessage(),Toast.LENGTH_SHORT).show();
                                showProgress(false);
                            }
                        });
                    }
                });
                dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etContName.getText().toString().isEmpty()||etContMail.getText().toString().isEmpty()||
                        etContTel.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter all fields!",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    ApplicationClass.contacts.get(index).setName(etContName.getText().toString().trim());
                    ApplicationClass.contacts.get(index).setNumber(etContTel.getText().toString().trim());
                    ApplicationClass.contacts.get(index).setEmail(etContMail.getText().toString().trim());
                    showProgress(true);
                    Backendless.Persistence.save(ApplicationClass.contacts.get(index), new AsyncCallback<Contact>() {
                        @Override
                        public void handleResponse(Contact response) {
                            tvContChar.setText(ApplicationClass.contacts.get(index).getName().toUpperCase().charAt(0)+"");
                            tvContName.setText(ApplicationClass.contacts.get(index).getName());
                            Toast.makeText(getApplicationContext(),"Contact successfully updated!",
                                    Toast.LENGTH_SHORT).show();
                            showProgress(false);
                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {
                            Toast.makeText(getApplicationContext(),"Error: " + fault.getMessage(),
                                    Toast.LENGTH_SHORT).show();
                            showProgress(false);
                        }
                    });

                }
            }
        });
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
// for very easy animations. If available, use these APIs to fade-in
// the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
            tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
            tvLoad.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
// The ViewPropertyAnimator APIs are not available, so simply show
// and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

}