package com.example.chrim.ordernow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TipiActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterTipi adapterTipi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final RetrofitService service = RetrofitClient.getClient().create(RetrofitService.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipi);
        String cod = getIntent().getStringExtra("codRistorante");
        TextView textView = findViewById(R.id.benvenuto);
        textView.append(" " + getIntent().getStringExtra("nomeRistorante"));
        Call<Tipi> call = service.getTipiByCod(cod);
        call.enqueue(new Callback<Tipi>() {
            @Override
            public void onResponse(Call<Tipi> call, Response<Tipi> response) {
                Tipi tipi = response.body();

                System.out.println(tipi.getTipi().get(0).getTipo());
                if (tipi.getSize() != 0) {
                    recyclerView = findViewById(R.id.listaTipi);
                    adapterTipi = new AdapterTipi(getApplicationContext(), tipi, cod);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setAdapter(adapterTipi);


                }
            }

            @Override
            public void onFailure(Call<Tipi> call, Throwable t) {
                System.out.println("FUGBDIUYGVBKUDHBVKDYHVBDLIGBHDLIUHBGLDFIVLDIFBDLFIBDFLIB");
                System.out.println(t.getMessage());

            }
        });
    }
}
