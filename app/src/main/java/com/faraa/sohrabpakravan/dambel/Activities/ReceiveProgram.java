package com.faraa.sohrabpakravan.dambel.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.faraa.sohrabpakravan.dambel.R;

public class ReceiveProgram extends AppCompatActivity {

    Button viewProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_program);

        viewProgram = findViewById(R.id.btn_view_program);
        viewProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReviewProgram.class);
                startActivity(intent);
            }
        });

    }
}
