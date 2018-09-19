package com.example.lenovo.maitry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class trans extends AppCompatActivity {
    Button buy,sell;
    Intent i;
    String fname1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        Intent intent=getIntent();
         fname1=intent.getStringExtra("USER");
       buy=(Button) findViewById(R.id.buybook);
       sell=(Button) findViewById(R.id.sellbook);
       buy.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               i = new Intent(view.getContext(),sellingbook.class);
               i.putExtra("fname",fname1 );
               startActivity(i);
           }
       });
    }
}
