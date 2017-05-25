package com.example.studente.micheletto170523;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView vt;

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vt= (TextView) findViewById(R.id.vittoria);
        start= (Button) findViewById(R.id.startGame);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(MainActivity.this,game.class);
                startActivity(i);

            }
        });



    }

    public void onActivityResult(int requestCode, int resultCode, Intent i){
        if(requestCode==10){
            if(resultCode>10){
                vt.setText("Vittoria");
               vt.setBackgroundColor(getResources().getColor(R.color.GREEN));
            }
            if(resultCode<10) {
                vt.setText("Hai perso");
                vt.setBackgroundColor(getResources().getColor(R.color.RED));

            }
        }
    }
}
