package com.example.chrim.ordernow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PiattoActivity extends AppCompatActivity implements AggiungiPiattoFrag.OnItemInserted {

    private RecyclerView recyclerView;
    private AdapterPiatti adapterPiatti;
    private Carrello carrello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final RetrofitService service = RetrofitClient.getClient().create(RetrofitService.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piatti);
        String cod = getIntent().getStringExtra("codRistorante");
        String tipo = getIntent().getStringExtra("tipo");
        TextView textView = findViewById(R.id.tipo);
        textView.setText(tipo);
        Context context = this;
        carrello = getIntent().getParcelableExtra("CarrelloDaTipi");
        recyclerView = findViewById(R.id.listaPiatti);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        Call<Piatti> call = service.getMenuByTipo(cod, tipo);
        call.enqueue(new Callback<Piatti>() {
            @Override
            public void onResponse(Call<Piatti> call, Response<Piatti> response) {
                Piatti piatti = response.body();
                if (piatti.getSize() != 0) {
                    adapterPiatti = new AdapterPiatti(piatti, tipo, carrello);
                    recyclerView.setAdapter(adapterPiatti);

                } else {
                    Toast.makeText(getApplicationContext(), "Non risulta nessun piatto di questo tipo, chiama un cameriere per ricevere assistenza", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Piatti> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }


    @Override
    public void onItemInserted(DatiCarrello datiCarrello) {
        this.carrello.AddDatiCarrello(datiCarrello);
        this.carrello.ricalcolaTot();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("CarrelloDaResult", this.carrello);
        setResult(Activity.RESULT_OK, returnIntent);

    }


}
