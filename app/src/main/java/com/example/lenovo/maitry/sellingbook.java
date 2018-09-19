package com.example.lenovo.maitry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class sellingbook extends AppCompatActivity {
    String User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellingbook);
        Intent intent=getIntent();
        User=intent.getStringExtra("fname");

    }
}
