package com.example.visitorsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddVisitor extends AppCompatActivity {


    Button b1,b2;
    EditText e1,e2,e3,e4;
    String s1,s2,s3,s4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_visitor);

        b1=(Button) findViewById(R.id.gt);
        b2=(Button) findViewById(R.id.hy);

        e1=(EditText) findViewById(R.id.aq);
        e2=(EditText) findViewById(R.id.sw);
        e3=(EditText) findViewById(R.id.de);
        e4=(EditText) findViewById(R.id.fr);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                Toast.makeText(getApplicationContext(),s1+" "+s2+" "+s3+" "+s4,Toast.LENGTH_LONG).show();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ob);
            }
        });




    }
}