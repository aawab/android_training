package org.coursera.sustainableapps.recyclerviewfragmentchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CarOwnerAdapter.itemClicked{

    Button btnCar, btnOwner;
    TextView tvModel, tvTitle, tvOwner, tvTel;
    ImageView ivCar;
    ArrayList<CarOwner> list;

    CarOwnerAdapter adapter;
    FragmentManager manager = getSupportFragmentManager();

    Fragment listFrag,btnFrag,carFrag,ownerFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCar = findViewById(R.id.btnCar);
        btnOwner = findViewById(R.id.btnOwner);

        tvModel = findViewById(R.id.tvModel);
        tvTitle = findViewById(R.id.tvOwnerTitle);
        tvOwner = findViewById(R.id.tvOwnerName);
        tvTel = findViewById(R.id.tvOwnerTel);

        ivCar = findViewById(R.id.ivCar);

        listFrag =  manager.findFragmentById(R.id.listFrag);
        btnFrag = manager.findFragmentById(R.id.buttonFrag);
        carFrag = manager.findFragmentById(R.id.carFrag);
        ownerFrag = manager.findFragmentById(R.id.ownerFrag);

        manager.beginTransaction().show(listFrag).show(btnFrag).show(ownerFrag).hide(carFrag).
                commit();

        adapter = new CarOwnerAdapter(getApplicationContext(),list);

        btnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.beginTransaction().hide(ownerFrag).show(carFrag).commit();
            }
        });

        btnOwner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                manager.beginTransaction().hide(carFrag).show(ownerFrag).commit();
            }
        });
        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {
        tvOwner.setText(ApplicationClass.list.get(index).getOwner());
        tvTel.setText(ApplicationClass.list.get(index).getTel());
        tvModel.setText(ApplicationClass.list.get(index).getModel());

        switch (list.get(index).getCar()) {
            case "Volkswagen":
                ivCar.setImageResource(R.drawable.volkswagen);
                break;
            case "Mercedes":
                ivCar.setImageResource(R.drawable.mercedes);
                break;
            case "Nissan":
                ivCar.setImageResource(R.drawable.nissan);
                break;
        }
    }
}