package com.example.lenovo.maitry;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout container;
    AnimationDrawable anim;
    Button b1;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container=(LinearLayout)findViewById(R.id.container);
        anim=(AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(6000);
        anim.setExitFadeDuration(2000);
        bindfunction();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(view.getContext(),trans.class);
                startActivity(i);
            }
        });
    }
    void bindfunction()
    {
        b1=(Button) findViewById(R.id.btn1);
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
