package com.example.xxxan.myapplication;

import android.content.Context;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

class Page6 extends AppCompatActivity {
    ArrayList<Device> ald;
    ArrayList<Device> copy;
    Switch simpleSwitch;
    MyAdapter ma;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_page6);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Connected devices");
        lv = findViewById(R.id.listView);
        copy = new ArrayList<Device>();
        ald = new ArrayList<>();
        ald.add(new Device("XIAOMI", "DATE1", R.drawable.android));
        ald.add(new Device("iphone", "DATE2", R.drawable.android));
        ald.add(new Device("SAMSUNG", "DATE3", R.drawable.android));
        ald.add(new Device("XIAOMI", "DATE1", R.drawable.android));
        ald.add(new Device("iphone", "DATE2", R.drawable.android));
        ald.add(new Device("SAMSUNG", "DATE3", R.drawable.android));
        ald.add(new Device("XIAOMI", "DATE1", R.drawable.android));
        ald.add(new Device("iphone", "DATE2", R.drawable.android));
        ald.add(new Device("SAMSUNG", "DATE3", R.drawable.android));
        ald.add(new Device("XIAOMI", "DATE1", R.drawable.android));
        ald.add(new Device("iphone", "DATE2", R.drawable.android));
        ald.add(new Device("SAMSUNG", "DATE3", R.drawable.android));
        copy.add(ald.get(0));
        ma = new MyAdapter(this, copy);
        lv.setAdapter(ma);
        simpleSwitch = findViewById(R.id.switch1);
        simpleSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String statusSwitch1, statusSwitch2;
                if (simpleSwitch.isChecked()) {
                    ma = new MyAdapter(Page6.this, ald);
                    lv.setAdapter(ma);
                } else
                {
                    copy = new ArrayList<Device>();
                    copy.add(ald.get(0));
                    ma = new MyAdapter(Page6.this, copy);
                    lv.setAdapter(ma);
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    class MyAdapter extends BaseAdapter {
        Context ctx;
        LayoutInflater lInflater;
        ArrayList<Device> objects;

        MyAdapter(Context context, ArrayList<Device> contacts) {
            ctx = context;
            objects = contacts;
            lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return objects.size();
        }

        @Override
        public Object getItem(int position) {
            return objects.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = lInflater.inflate(R.layout.item_list, parent, false);
            }
            Device p = (Device) getItem(position);
            ((TextView) view.findViewById(R.id.name)).setText(p.name);
            ((TextView) view.findViewById(R.id.date)).setText(p.date);
            ((ImageView) view.findViewById(R.id.imageView)).setImageResource(p.image);
            ((Button) view.findViewById(R.id.button)).setText("Delete" + position);
            return view;
        }
    }
}
class Device{
    String name, date;
    int image;
    public Device(String name, String date, int image){
        this.date = date; this.name = name; this.image = image;
    }
}