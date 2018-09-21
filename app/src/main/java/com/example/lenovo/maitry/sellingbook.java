package com.example.lenovo.maitry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Year;

public class sellingbook extends AppCompatActivity {
    String User,phno;
    Button b1;
    EditText bookname,sub,price,year,des;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellingbook);
        Intent intent=getIntent();
        User=intent.getStringExtra("fname");
        phno=intent.getStringExtra("phoneno");
        bookname=findViewById(R.id.bkname);
        sub=findViewById(R.id.sub);
        price=findViewById(R.id.sale);
        year=findViewById(R.id.yer);
        des=findViewById(R.id.des);
        b1=findViewById(R.id.buttons);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db= FirebaseDatabase.getInstance().getReference("BookDetails");
                String id=db.push().getKey();
               Book bb=new Book(id,User,phno,bookname.getText().toString(),sub.getText().toString(), year.getText().toString(),price.getText().toString(),des.getText().toString());
                db.child(id).setValue(bb);
                bookname.setText("");
                sub.setText("");
                price.setText("");
                year.setText("");
                des.setText("");
            }
        });
    }
}
