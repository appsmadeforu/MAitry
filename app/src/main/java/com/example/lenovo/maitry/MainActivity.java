package com.example.lenovo.maitry;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    LinearLayout container;
    AnimationDrawable anim;
    Button b1,b2;
    EditText uname,passwor;
    int flag=0;
    String abc;
    Intent i,i1;
    DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=(EditText)findViewById(R.id.Uname);
        container=(LinearLayout)findViewById(R.id.container);
        passwor=findViewById(R.id.passw);
        anim=(AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(6000);
        anim.setExitFadeDuration(2000);
        bindfunction();
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance().getReference("data");
                database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds:dataSnapshot.getChildren())
                        {
                            //for (DataSnapshot ds1 : ds.getChildren())
                            {
                              //  String bookskey = ds.getKey().toString();
                                //Art art= (Art) ds1.getValue();
                                Art art=ds.getValue(Art.class);
                                Log.i("Data",ds.toString());
                                if (art.getName().equals(uname.getText().toString()))
                                {
                                   if(art.getPass().equals(passwor.getText().toString()))
                                   {
                                        flag=1;
                                   }
                                }
                                /*String booksValue =   ds1.getValue().toString();

                                if(bookskey.equals("name"))
                                {
                                    if(booksValue.equals(uname.getText().toString().trim()))
                                    {
                                        flag=1;
                                         abc=ds.getKey();

                                    }
                                }*/
                              //  Toast.makeText(MainActivity.this, bookskey + " " + booksValue,
                                //        Toast.LENGTH_LONG).show();
                            }
                        }
                        if(flag == 1)
                        {
                            //database = FirebaseDatabase.getInstance().getReference().child(abc);
                        //    database.add

                            i = new Intent(MainActivity.this,trans.class);
                            i.putExtra("USER", uname.getText().toString());
                            startActivity(i);
                         //   String abc=database.getValue();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Inavlid Credentials!!",
                                    Toast.LENGTH_SHORT).show();
                            uname.setText("");
                            passwor.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            //    i = new Intent(view.getContext(),trans.class);
             //  i.putExtra("USER", uname.getText().toString());
            //    startActivity(i);
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i1 = new Intent(view.getContext(),regesteration.class);
            //    i.putExtra("USER", uname.getText().toString());
                startActivity(i1);
            }
        });
    }
    void bindfunction()
    {
        b1=(Button) findViewById(R.id.btn1);
        b2=(Button) findViewById(R.id.btn2);
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (anim != null && !anim.isRunning())
            anim.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (anim != null && anim.isRunning())
            anim.stop();
    }
}
