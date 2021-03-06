package com.example.chrim.ordernow;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    EditText et;
    Button bt;
    String nomeRistorante;
    String tipoRistorante;
    private Carrello carrello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.codiceRistorante);
        carrello = new Carrello();
        Context context= this;
        bt = findViewById(R.id.bottone);
        bt.setOnClickListener((View v) -> {
            final String cod = et.getText().toString();
            RetrofitService service = RetrofitClient.getClient().create(RetrofitService.class);
            Call<Ristoranti> call = service.getRistoranti(cod);
            call.enqueue(new Callback<Ristoranti>() {
                @Override
                public void onResponse(Call<Ristoranti> call, Response<Ristoranti> response) {
                    Ristoranti ristoranti = response.body();
                    if (ristoranti != null && ristoranti.getRistoranti().size() != 0) {
                        nomeRistorante = ristoranti.getRistoranti().get(0).getNomeRistorante();
                        tipoRistorante = ristoranti.getRistoranti().get(0).getTipoRistorante();
                        Intent intent = new Intent(context , TipiActivity.class);
                        intent.putExtra("codRistorante", cod);
                        intent.putExtra("nomeRistorante", nomeRistorante);
                        intent.putExtra("tipoRistorante", tipoRistorante);
                        intent.putExtra("CarrelloDaMain", carrello);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Ristorante non trovato", Toast.LENGTH_LONG).show();
                    }


                }

                @Override
                public void onFailure(Call<Ristoranti> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        });



    }

}
