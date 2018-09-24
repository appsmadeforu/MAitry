package com.example.lenovo.maitry;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.lenovo.maitry.R.menu.menu_search;

public class purchaseItem extends AppCompatActivity {
    String User,phno;
    ListView listviewbooks;
   // SearchView searchView;
   // MenuItem searchMenuItem;
    DatabaseReference db;
    BooksLists bk;
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
                bk=new BooksLists(purchaseItem.this,ls);
               listviewbooks.setAdapter(bk);
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         MenuInflater inflater= getMenuInflater();
         inflater.inflate(R.menu.menu_search,menu);
         MenuItem item=menu.findItem(R.id.menuSearch);
         SearchView searchView =(SearchView) item.getActionView();
         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
             @Override
             public boolean onQueryTextSubmit(String s) {
                 return false;
             }

             @Override
             public boolean onQueryTextChange(String s) {
                 Book bk1;
                 bk.getFilter().filter(s);
                 return false;
             }
         });
      return  super.onCreateOptionsMenu(menu);
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
