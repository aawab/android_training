package org.coursera.sustainableapps.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Register extends AppCompatActivity {

    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;

    private EditText etName, etMail, etPass, etConfirmPass;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);

        etName=findViewById(R.id.etRegName);
        etMail=findViewById(R.id.etRegMail);
        etPass=findViewById(R.id.etRegPass);
        etConfirmPass=findViewById(R.id.etRegConfirm);

        btnRegister=findViewById(R.id.button);

        btnRegister.setOnClickListener(v -> {
            if(etName.getText().toString().isEmpty()|| etMail.getText().toString().isEmpty()||
                    etPass.getText().toString().isEmpty()||etConfirmPass.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Please enter all details!",
                        Toast.LENGTH_SHORT).show();
            }
            else{
                if(etPass.getText().toString().equals(etConfirmPass.getText().toString())){
                    String name = etName.getText().toString().trim();
                    String email = etMail.getText().toString().trim();
                    String pass = etPass.getText().toString().trim();

                    BackendlessUser user = new BackendlessUser();
                    user.setEmail(email);
                    user.setPassword(pass);
                    user.setProperty("name",name);

                    showProgress(true);
                    tvLoad.setText("Busy registering user...please wait");
                    Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                        @Override
                        public void handleResponse(BackendlessUser response) {
                            Toast.makeText(getApplicationContext(),"User successfully" +
                                    " registered!",Toast.LENGTH_SHORT).show();
                            Register.this.finish();
                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {
                            Toast.makeText(getApplicationContext(),"Fault!" + fault.
                                    getMessage(),Toast.LENGTH_SHORT).show();
                            showProgress(false);
                        }
                    });

                }
                else Toast.makeText(getApplicationContext(),"Please make sure the passwords " +
                        "are the same!", Toast.LENGTH_SHORT).show();
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