package com.aradwan054.fcis_activites;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class favorites extends AppCompatActivity {
    ListView lst;
    Context context;
    EditText edtID;
    Button delete;
    final DB_SQL db = new DB_SQL(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        context = favorites.this;
        final DB_SQL db = new DB_SQL(context);
        ArrayList<String> listData = db.getAllRecords();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listData);
        lst = findViewById(R.id.listView);
        lst.setAdapter(arrayAdapter);
        edtID = findViewById(R.id.id);
        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtID.getText().toString();
                Integer res = db.delete(id);
                if (res > 0) {
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                    showData();
                    edtID.setText("");

                } else Toast.makeText(context, "this id isn't exist", Toast.LENGTH_SHORT).show();


            }
        });
    }

    public void showData() {

        ArrayList<String> listData = db.getAllRecords();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listData);
        lst.setAdapter(arrayAdapter);
    }
}

