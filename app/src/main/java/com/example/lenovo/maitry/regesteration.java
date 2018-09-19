package com.example.lenovo.maitry;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class regesteration extends AppCompatActivity {
  //  private static final String TAG = "regesteration";

    Button b1;
    EditText e1,e2,e3;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regesteration);
        b1=(Button)findViewById(R.id.bb);
        e1=(EditText)findViewById(R.id.name) ;

        e2=(EditText)findViewById(R.id.pno) ;
        e3=(EditText)findViewById(R.id.pass) ;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db= FirebaseDatabase.getInstance().getReference("data");
             String id=db.push().getKey();
           Art aa=new Art(id,e1.getText().toString().trim(),e2.getText().toString().trim(),e3.getText().toString().trim());
            db.child(id).setValue(aa);
            }
        });
    }

}
