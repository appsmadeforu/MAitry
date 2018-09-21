package com.example.lenovo.maitry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class trans extends AppCompatActivity {
    Button buy,sell;
    Intent i;
    String fname1,pn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        Intent intent=getIntent();
         fname1=intent.getStringExtra("USER");
         pn=intent.getStringExtra("phoneno");
       buy=(Button) findViewById(R.id.pubook);
       sell=(Button) findViewById(R.id.sellbook);
       sell.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               i = new Intent(view.getContext(),sellingbook.class);
               i.putExtra("fname",fname1 );
               i.putExtra("phoneno",pn);
               startActivity(i);
           }
       });
       buy.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               i = new Intent(view.getContext(),purchaseItem.class);
               i.putExtra("fname",fname1 );
               i.putExtra("phoneno",pn);
               startActivity(i);
           }
       });
    }
}
