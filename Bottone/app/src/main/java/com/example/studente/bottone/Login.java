package com.example.studente.bottone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class Login extends AppCompatActivity {

    TextView tv;
    Button b;
    EditText pass;
    String pw;
    EditText username;
    String un;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.textView);
        b= (Button) findViewById(R.id.button);
        pass= (EditText) findViewById(R.id.password);
        username= (EditText) findViewById(R.id.user);
        pw=Register.pw;
        un=Register.un;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(pass.getText().toString().equals(pw)&&username.getText().toString().equals(un)){
                Toast.makeText(Login.this, "Username e password corretti", Toast.LENGTH_LONG).show();
                tv.setText("Benvenuto "+ un);

            }else{Toast.makeText(Login.this, "Username o password errati", Toast.LENGTH_LONG).show();
                     tv.setText("Login fallito");
            }}
            });

    }
}





