package com.example.studente.bottone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button b;
    EditText et;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.textView);
        b= (Button) findViewById(R.id.button);
        et= (EditText) findViewById(R.id.eT);
        password="password";
            b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(et.getText().toString().equals(password)){
                Toast.makeText(MainActivity.this, "Password corretta", Toast.LENGTH_LONG).show();
                tv.setText("Hai fatto il login");

            }else{Toast.makeText(MainActivity.this, "Password errata", Toast.LENGTH_LONG).show();
                     tv.setText("Login fallito");
            }}
            });

    }
}





