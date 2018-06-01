package com.example.chrim.ordernow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    EditText et;
    Button bt;
    String nomeRistorante;
    String tipoRistorante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.codiceRistorante);
        bt = findViewById(R.id.bottone);

        bt.setOnClickListener((View v) -> {
            final String cod = et.getText().toString();
            RetrofitService service = RetrofitClient.getClient().create(RetrofitService.class);
            Call<Ristoranti> call = service.getRistoranti(cod);
            call.enqueue(new Callback<Ristoranti>() {
                @Override
                public void onResponse(Call<Ristoranti> call, Response<Ristoranti> response) {
                    Ristoranti ristoranti = response.body();

                    if (ristoranti.getRistoranti() != null) {
                        nomeRistorante = ristoranti.getRistoranti().get(0).getNomeRistorante();
                        tipoRistorante = ristoranti.getRistoranti().get(0).getTipoRistorante();
                        Toast.makeText(getApplicationContext(), nomeRistorante + tipoRistorante, Toast.LENGTH_LONG).show();
                        System.out.println(nomeRistorante + tipoRistorante);
                        Intent intent = new Intent(getApplicationContext(), TipiActivity.class);
                        intent.putExtra("codRistorante", cod);
                        intent.putExtra("nomeRistorante", nomeRistorante);
                        intent.putExtra("tipoRistorante", tipoRistorante);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Ristorante non trovato", Toast.LENGTH_LONG).show();
                    }


                }

                @Override
                public void onFailure(Call<Ristoranti> call, Throwable t) {
                    System.out.println("SDLUFLYGBSKUVKUDCVGKSUDCVGBDSUYBVCDUFCBVLDJFHVBDJFHBL");
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        });

    }
}
