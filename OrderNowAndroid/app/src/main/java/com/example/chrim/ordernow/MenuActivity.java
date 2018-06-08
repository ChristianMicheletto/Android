package com.example.chrim.ordernow;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity implements AggiungiPiattoFrag.OnItemInserted {

    private RecyclerView recyclerView;
    private AdapterPiatti adapterPiatti;
    private Carrello carrello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final RetrofitService service = RetrofitClient.getClient().create(RetrofitService.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piatti);
        String cod = getIntent().getStringExtra("codRistorante");
        System.out.println(cod);
        String tipo = getIntent().getStringExtra("tipo");
        TextView textView = findViewById(R.id.tipo);
        textView.setText(tipo);
        Context context= this;
        carrello= (Carrello) getIntent().getSerializableExtra("Carrello");
        TextView tvCarrello= findViewById(R.id.Carrello);
        tvCarrello.setText(""+carrello.getPrezzoTotale());
        recyclerView = findViewById(R.id.listaPiatti);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        Call<Piatti> call = service.getMenuByTipo(cod, tipo);
        call.enqueue(new Callback<Piatti>() {
            @Override
            public void onResponse(Call<Piatti> call, Response<Piatti> response) {
                Piatti piatti = response.body();
                if (piatti.getSize()!=0) {
                    adapterPiatti = new AdapterPiatti(context, piatti, tipo, carrello);
                    recyclerView.setAdapter(adapterPiatti);
                }else{
                    Toast.makeText(getApplicationContext(), "Non risulta nessun piatto di questo tipo, chiama un cameriere per ricevere assistenza", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Piatti> call, Throwable t) {
                System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
                System.out.println(t.getMessage());

            }
        });
    }



    @Override
    public void onItemInserted(DatiCarrello datiCarrello) {

    }
}
