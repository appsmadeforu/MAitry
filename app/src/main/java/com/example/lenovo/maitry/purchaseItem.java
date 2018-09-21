package com.example.lenovo.maitry;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class purchaseItem extends AppCompatActivity {
    String User,phno;
    ListView listviewbooks;
    DatabaseReference db;
    List<Book> ls;
    @Override
    protected void onStart() {
        super.onStart();
       db.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               ls.clear();
               for(DataSnapshot dataSnaps: dataSnapshot.getChildren())
               {
                 Book book=dataSnaps.getValue(Book.class);
                 ls.add(book);
               }
               BooksLists bk=new BooksLists(purchaseItem.this,ls);
               listviewbooks.setAdapter(bk);
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_item);
        Intent intent=getIntent();
        User=intent.getStringExtra("fname");
        phno=intent.getStringExtra("phoneno");
        db= FirebaseDatabase.getInstance().getReference("BookDetails");
        ls=new ArrayList<>();
        listviewbooks=findViewById(R.id.listvi);

    }
}
