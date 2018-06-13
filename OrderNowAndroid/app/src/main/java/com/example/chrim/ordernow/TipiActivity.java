package com.example.chrim.ordernow;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TipiActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterTipi adapterTipi;
    private Carrello carrello;
    Button bottoneBuy;
    TextView tvCarrello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final RetrofitService service = RetrofitClient.getClient().create(RetrofitService.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipi);
        Context context = this;
        String cod = getIntent().getStringExtra("codRistorante");
        TextView textView = findViewById(R.id.benvenuto);
        textView.append(" " + getIntent().getStringExtra("nomeRistorante"));
        carrello = getIntent().getParcelableExtra("CarrelloDaMain");
        carrello.setCodiceRistorante(cod);
        tvCarrello = findViewById(R.id.Carrello);
        tvCarrello.setText(String.format("%s", carrello.getPrezzoTotale()));
        Call<Tipi> call = service.getTipiByCod(cod);
        call.enqueue(new Callback<Tipi>() {
            @Override
            public void onResponse(Call<Tipi> call, Response<Tipi> response) {
                Tipi tipi = response.body();
                if (tipi.getSize() != 0) {
                    recyclerView = findViewById(R.id.listaTipi);
                    adapterTipi = new AdapterTipi(context, tipi, carrello);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setAdapter(adapterTipi);
                    bottoneBuy = findViewById(R.id.Compra);
                    bottoneBuy.setOnClickListener((View view) -> {
                        Intent intent = new Intent(context, CarrelloActivity.class);
                        intent.putExtra("CarrelloDaTipi", carrello);
                        startActivityForResult(intent, 2);
                    });

                }
            }

            @Override
            public void onFailure(Call<Tipi> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == -1) {
                carrello = data.getParcelableExtra("CarrelloDaResult");
                adapterTipi.UpdateCarrello(carrello);
                tvCarrello = findViewById(R.id.Carrello);
                tvCarrello.setText(String.format("%s", carrello.getPrezzoTotale()));
            }
        } else if (requestCode == 2) {
            if (resultCode == -1) {
                carrello = data.getParcelableExtra("CarrelloDaEdit");
                adapterTipi.UpdateCarrello(carrello);
                tvCarrello = findViewById(R.id.Carrello);
                tvCarrello.setText(String.format("%s", carrello.getPrezzoTotale()));
            }
        }

    }
}
