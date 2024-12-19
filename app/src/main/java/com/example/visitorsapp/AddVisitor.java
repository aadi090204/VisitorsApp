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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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


                if (s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"All the fields are mandatory",Toast.LENGTH_LONG).show();
                }
                else
                {
                    CallApi();
                }
            }

            private void CallApi() {

                String apiUrl="https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data=new JSONObject();
                try {
                    data.put("firstname",s1);
                    data.put("lastname",s2);
                    data.put("purpose",s3);
                    data.put("whomToMeet",s4);
                }

                catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                JsonObjectRequest request=new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,
                        data,
                        response -> Toast.makeText(getApplicationContext(),"succesfully added",Toast.LENGTH_LONG).show(),
                        error -> Toast.makeText(getApplicationContext(),"Error occured",Toast.LENGTH_LONG).show()

                );

                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                queue.add(request);
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