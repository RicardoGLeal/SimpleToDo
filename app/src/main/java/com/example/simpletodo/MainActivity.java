package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> items;
    Button add_btn;
    EditText item_et;
    RecyclerView items_rv;
    ItemsAdapter itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_btn = findViewById(R.id.btnAdd);
        item_et = findViewById(R.id.etItem);
        items_rv = findViewById(R.id.items_rv);

        item_et.setText("Hello World!");

        items = new ArrayList<>();
        items.add("Play with my friends");
        items.add("Take the Android Course");

        ItemsAdapter.OnLongClickListener onLongClickListener = new ItemsAdapter.OnLongClickListener() {

            @Override
            public void onItemLongClicked(int position) {
                //Delete the item from the model
                items.remove(position);
                //Notify the adapter
                itemsAdapter.notifyItemRemoved(position);
                Toast.makeText(getApplicationContext(), "Item was removed", Toast.LENGTH_SHORT).show();
            }
        };
        itemsAdapter = new ItemsAdapter(items, onLongClickListener);
        items_rv.setAdapter(itemsAdapter);
        items_rv.setLayoutManager(new LinearLayoutManager(this));

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todoItem = item_et.getText().toString();
                //Add item to the model
                items.add(todoItem);
                //Notify adaptar that an item is inserted.
                itemsAdapter.notifyItemInserted(items.size()-1);
                item_et.setText("");
                Toast.makeText(getApplicationContext(), "Item was added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}