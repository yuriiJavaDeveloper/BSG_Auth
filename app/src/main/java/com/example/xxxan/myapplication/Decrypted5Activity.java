package com.example.xxxan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Decrypted5Activity extends AppCompatActivity {
    public TextView text;
    Button buttonScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypted5);

        text = findViewById(R.id.textDesc);
        buttonScan = findViewById(R.id.buttonQRcode);

        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Decrypted5Activity.this, Decrypted10Activity.class);
                startActivity(intent);
                Bundle bundle = getIntent().getExtras();
                String res = bundle.getString("RESULT");
                text.setText(res);
            }
        });
        Button code = findViewById(R.id.buttonCode);
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Decrypted5Activity.this, Decrypted6Activity.class);
                startActivity(i);
            }
        });
    }
}

