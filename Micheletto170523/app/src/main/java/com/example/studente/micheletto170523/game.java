package com.example.studente.micheletto170523;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class game extends AppCompatActivity {

    EditText edit;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    char input;
    String parola;
    int tentativi;
    boolean vittoria;
    char [] out;
    LinearLayout lL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tentativi=10;
        vittoria=false;
        parola="cane";
        out= new char[4];
        edit= (EditText) findViewById(R.id.eT);
        b1= (Button) findViewById(R.id.Bottone1);
        b2= (Button) findViewById(R.id.Bottone2);
        b3= (Button) findViewById(R.id.Bottone3);
        b4= (Button) findViewById(R.id.Bottone4);

        while(tentativi>=0){
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    input=edit.getText().charAt(0);
                    if(input==parola.charAt(0)){
                        b1.setText(input);
                        out[0]=input;
                    }
                    else{
                        tentativi--;
                    }

                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    input=edit.getText().charAt(0);
                    if(input==parola.charAt(1)){
                        b1.setText(input);
                        out[1]=input;
                    }
                    else{
                        tentativi--;
                    }
                }
            });
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    input=edit.getText().charAt(0);
                    if(input==parola.charAt(2)){
                        b1.setText(input);
                        out[2]=input;
                    }
                    else{
                        tentativi--;
                    }
                }
            });
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    input=edit.getText().charAt(0);
                    if(input==parola.charAt(3)){
                        b1.setText(input);
                        out[3]=input;
                    }
                    else{
                        tentativi--;
                    }
                }
            });
            if(out.toString().equals(parola)){
                Intent i= new Intent(game.this,MainActivity.class);
                startActivityForResult(i,10);
                game.this.setResult(15,i);
            }


        }Intent i= new Intent(game.this,MainActivity.class);
        startActivityForResult(i,10);
        game.this.setResult(5,i);
    }
    }
