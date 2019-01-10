package com.example.xxxan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

public class Decrypted9Activity extends AppCompatActivity {
    Pinview pin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypted9);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Enter pin code");
        pin = new Pinview(this);
        pin = (Pinview) findViewById(R.id.pinview);
        pin.setPinBackgroundRes(R.drawable.sample_background);
        pin.setInputType(Pinview.InputType.NUMBER);
        //pin.setValue("1234");
        pin.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                //Make api calls here or what not
                Intent  i = new Intent(Decrypted9Activity.this, Decrypted4Activity.class);
                startActivity(i);
                Toast.makeText(Decrypted9Activity.this, pinview.getValue(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
