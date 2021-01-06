package org.coursera.sustainableapps.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvProducts;
    ProductAdapter adapter;
    ArrayList<Product> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add(new Product("Dell Inspiron","Best Dell laptop no cap","Laptop",1350.99,true));
        list.add(new Product("1440p Ultrawide Dell Monitor","Best monitor wowie","Screen",660.99,false));
        list.add(new Product("Sandisk CruzerBlade 16gb","Best 16gb flash drive omg","USB Drive",50.99,true));
        list.add(new Product("WD_Black 1TB Portable HDD","Best portable HDD fr","HDD",100.99,false));

        lvProducts=(ListView) findViewById(R.id.lvProducts);
        adapter = new ProductAdapter(this,list);
        lvProducts.setAdapter(adapter);
    }
}