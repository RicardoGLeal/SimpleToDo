package com.example.simpletodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    List<String> items;

    public ItemsAdapter(List<String> _items) {
        this.items = _items;
    }

    @NonNull
    //@org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(todoView);
    }


    //responsible for binding data to a particular view holder
    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ViewHolder holder, int position) {
        //Grab the item at the position
        String item = items.get(position);
        //Bind the item into the specified view holder
        holder.bind(item);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //Container to provide easy access to views that represent each row of the list
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_tv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_tv = itemView.findViewById(android.R.id.text1);
        }

        //Update the view inside of the view holder with this data
        public void bind(String item) {
            item_tv.setText(item);
            item_tv.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //Remove the item for the recycler view

                    return false;
                }
            });
        }
    }
}
