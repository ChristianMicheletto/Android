package com.example.studente.micheletto170523;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Arrays;

public class game extends AppCompatActivity {

    EditText edit;
    TextView ins;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    char input;
    char[] parola;
    int tentativi;
    char[] out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tentativi = 10;
        parola = new char[]{'c', 'a', 'n', 'e'};
        out = new char[4];
        edit = (EditText) findViewById(R.id.eT);
        ins = (TextView) findViewById(R.id.inserisci);
        b1 = (Button) findViewById(R.id.Bottone1);
        b2 = (Button) findViewById(R.id.Bottone2);
        b3 = (Button) findViewById(R.id.Bottone3);
        b4 = (Button) findViewById(R.id.Bottone4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit.length() == 0) {
                    ins.setText("Inserisci una lettera");
                } else {
                    ins.setText(" ");
                    input = edit.getText().toString().charAt(0);
                    if (input == parola[0]) {

                        b1.setText(String.valueOf(input));
                        out[0] = input;
                        edit.setText("");
                        if (Arrays.equals(out, parola)) {
                            Intent i = new Intent(game.this, MainActivity.class);
                            game.this.setResult(15, i);
                            game.this.finish();
                        }
                    } else {
                        tentativi--;
                        if (tentativi == 0) {
                            Intent i = new Intent(game.this, MainActivity.class);
                            game.this.setResult(5, i);
                            game.this.finish();


                        }
                    }
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit.length() == 0) {
                    ins.setText("Inserisci una lettera");
                } else {
                    ins.setText(" ");
                    input = edit.getText().toString().charAt(0);
                    if (input == parola[1]) {
                        b2.setText(String.valueOf(input));
                        out[1] = input;
                        edit.setText("");
                        if (Arrays.equals(out, parola)) {
                            Intent i = new Intent(game.this, MainActivity.class);
                            game.this.setResult(15, i);
                            game.this.finish();
                        }
                    } else {
                        tentativi--;

                        if (tentativi == 0) {
                            Intent i = new Intent(game.this, MainActivity.class);
                            game.this.setResult(5, i);
                            game.this.finish();


                        }
                    }
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit.length() == 0) {
                    ins.setText("Inserisci una lettera");
                } else {
                    ins.setText(" ");
                    input = edit.getText().toString().charAt(0);
                    if (input == parola[2]) {
                        b3.setText(String.valueOf(input));
                        out[2] = input;
                        edit.setText("");
                        if (Arrays.equals(out, parola)) {
                            Intent i = new Intent(game.this, MainActivity.class);
                            game.this.setResult(15, i);
                            game.this.finish();
                        }
                    } else {
                        tentativi--;
                        if (tentativi == 0) {
                            Intent i = new Intent(game.this, MainActivity.class);
                            game.this.setResult(5, i);
                            game.this.finish();
                        }
                    }
                }
            }

        });
        b4.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (edit.length() == 0) {
                    ins.setText("Inserisci una lettera");
                } else {
                    ins.setText(" ");
                    input = edit.getText().toString().charAt(0);
                    if (input == parola[3]) {
                        b4.setText(String.valueOf(input));
                        out[3] = input;
                        edit.setText("");
                        if (Arrays.equals(out, parola)) {
                            Intent i = new Intent(game.this, MainActivity.class);
                            game.this.setResult(15, i);
                            game.this.finish();
                        }
                    } else {
                        tentativi--;
                        if (tentativi == 0) {
                            Intent i = new Intent(game.this, MainActivity.class);
                            game.this.setResult(5, i);
                            game.this.finish();
                        }
                    }
                }
            }
        });


    }


}




