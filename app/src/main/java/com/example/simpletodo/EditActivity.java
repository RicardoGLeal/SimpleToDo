package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText item_edit_txt;
    Button save_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        item_edit_txt = findViewById(R.id.item_edit_txt);
        save_btn = findViewById(R.id.save_btn);

        getSupportActionBar().setTitle("Edit Item");

        item_edit_txt.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));


        //When the user is done editing, they click the save button
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an Intent which will contain the results
                Intent intent = new Intent();
                //pass the data (results)
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, item_edit_txt.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                //set the results of the intent
                setResult(RESULT_OK, intent);
                //finish activity, close the screen an go back
                finish();
            }
        });
    }
}