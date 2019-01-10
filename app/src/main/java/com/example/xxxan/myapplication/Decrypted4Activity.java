package com.example.xxxan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Decrypted4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypted4);
        ArrayList<Contact> ala = new ArrayList<>();
        ala.add(new Contact("name", "TOTP"));
        ala.add(new Contact("name2", "TOTP2"));
        ala.add(new Contact("name3", "TOTP3"));

        RecyclerView rvContacts = findViewById(R.id.recyclerView);
        // Create adapter passing in the sample user data
        ContactsAdapter adapter = new ContactsAdapter(ala);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        Button add = findViewById(R.id.buttonAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Decrypted4Activity.this, Decrypted5Activity.class);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.popupmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        TextView infoTextView = (TextView) findViewById(R.id.textView);
        switch(id){
            case R.id.menu1 :
                Intent i = new Intent(Decrypted4Activity.this , Decrypted11Activity.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

