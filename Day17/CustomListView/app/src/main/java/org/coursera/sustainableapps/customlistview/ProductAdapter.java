package org.coursera.sustainableapps.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    private final Context context;
    private final ArrayList<Product> values;

    public ProductAdapter(@NonNull Context context, ArrayList<Product> values) {
        super(context, R.layout.row_layout,values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView  = inflater.inflate(R.layout.row_layout,parent,false);

        TextView tvProduct = (TextView) rowView.findViewById(R.id.tvProduct);
        TextView tvPrice = (TextView) rowView.findViewById(R.id.tvPrice);
        TextView tvDescription = (TextView) rowView.findViewById(R.id.tvDescription);

        ImageView ivProduct = (ImageView) rowView.findViewById(R.id.ivProduct);
        ImageView ivSale = (ImageView) rowView.findViewById(R.id.ivSale);

        tvProduct.setText(values.get(position).getTitle());
        tvPrice.setText(String.valueOf(values.get(position).getPrice()));
        tvDescription.setText(values.get(position).getDescription());

        if(values.get(position).isOnSale()) ivSale.setImageResource(R.mipmap.onsale_foreground);
        else ivSale.setImageResource(R.mipmap.bestprice_foreground);

        if ("Laptop".equals(values.get(position).getType())) {
            ivProduct.setImageResource(R.mipmap.laptop_foreground);
        } else if ("HDD".equals(values.get(position).getType())) {
            ivProduct.setImageResource(R.mipmap.hdd_foreground);
        } else if ("USB Drive".equals(values.get(position).getType())) {
            ivProduct.setImageResource(R.mipmap.memory_foreground);
        } else if("Screen".equals(values.get(position).getType())){
            ivProduct.setImageResource(R.mipmap.screen_foreground);
        }

        return rowView;
    }
}
