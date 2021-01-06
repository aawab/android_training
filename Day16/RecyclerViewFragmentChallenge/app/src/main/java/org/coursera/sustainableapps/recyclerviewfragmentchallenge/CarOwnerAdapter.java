package org.coursera.sustainableapps.recyclerviewfragmentchallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarOwnerAdapter extends RecyclerView.Adapter<CarOwnerAdapter.ViewHolder> {

    public ArrayList<CarOwner> list;

    itemClicked activity;

    public interface itemClicked{
        void onItemClicked(int index);
    }

    public CarOwnerAdapter(Context context, ArrayList<CarOwner> list){
        this.list=list;
        activity=(itemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivModel;
        TextView tvModel,tvOwner;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivModel=itemView.findViewById(R.id.ivItemModel);

            tvModel=itemView.findViewById(R.id.tvItemModel);
            tvOwner=itemView.findViewById(R.id.tvItemOwner);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(list.indexOf((CarOwner) itemView.getTag()));
                }
            });

        }
    }

    @NonNull
    @Override

    //creates the view
    public CarOwnerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);

        return new ViewHolder(view);
    }
    @Override
    //sets the items in the view
    public void onBindViewHolder(@NonNull CarOwnerAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(list.get(position));

        holder.tvModel.setText(list.get(position).getModel());
        holder.tvOwner.setText(list.get(position).getOwner());

        switch (list.get(position).getCar()) {
            case "Volkswagen":
                holder.ivModel.setImageResource(R.drawable.volkswagen);
                break;
            case "Mercedes":
                holder.ivModel.setImageResource(R.drawable.mercedes);
                break;
            case "Nissan":
                holder.ivModel.setImageResource(R.drawable.nissan);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
