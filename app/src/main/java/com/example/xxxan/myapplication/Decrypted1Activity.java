package com.example.xxxan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class Decrypted1Activity extends AppCompatActivity {
    Button buttonNext;
    CountryCodePicker ccp;
    EditText editTextCarrierNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypted1);
        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        editTextCarrierNumber = (EditText) findViewById(R.id.editText_carrierNumber);
        ccp.registerCarrierNumberEditText(editTextCarrierNumber);
        buttonNext = findViewById(R.id.button);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Decrypted1Activity.this, Decrypted2Activity.class);
                i.putExtra("RESULT", ccp.getFullNumberWithPlus());
                startActivity(i);
            }
        });
    }
}
