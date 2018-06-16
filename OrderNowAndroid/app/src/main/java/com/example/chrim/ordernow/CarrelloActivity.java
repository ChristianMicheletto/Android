package com.example.chrim.ordernow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarrelloActivity extends AppCompatActivity implements EditCarrelloFrag.OnItemModified, AcquistaFrag.OnItemSent {

    private RecyclerView recyclerView;
    private AdapterCarrello adapterCarrello;
    Carrello carrello;
    TextView tvCarrello;
    Button compra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrello);
        recyclerView = findViewById(R.id.listaCarrello);
        carrello = getIntent().getParcelableExtra("CarrelloDaTipi");
        Context context = this;
        tvCarrello = findViewById(R.id.Carrello);
        tvCarrello.setText(String.format("%s", carrello.getPrezzoTotale()));
        adapterCarrello = new AdapterCarrello(context, carrello);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapterCarrello);
        compra = findViewById(R.id.Compra);
        compra.setOnClickListener(v -> {
            FragmentManager manager = ((CarrelloActivity) context).getSupportFragmentManager();
            AcquistaFrag dialogFragment = new AcquistaFrag();
            dialogFragment.carrello= carrello;
            dialogFragment.show(manager, "Aggiungi Piatto");
        });
    }

    @Override
    public void onItemModified(DatiCarrello datiCarrello) {
        Intent returnIntent = new Intent();
        if (datiCarrello.getQuantita() == 0) {
            carrello.DeleteDatiCarrelloByNome(datiCarrello.getNome());
        } else {
            carrello.DeleteDatiCarrelloByNome(datiCarrello.getNome());
            carrello.AddDatiCarrello(datiCarrello);
        }
        adapterCarrello.UpdateCarrello(carrello);
        adapterCarrello.notifyDataSetChanged();
        carrello.ricalcolaTot();
        tvCarrello.setText(String.format("%s", carrello.getPrezzoTotale()));
        returnIntent.putExtra("CarrelloDaEdit", carrello);
        setResult(Activity.RESULT_OK, returnIntent);

    }

    @Override
    public void onItemSent(Carrello carrelloSent) {
        final RetrofitService service = RetrofitClient.getClient().create(RetrofitService.class);
        Gson gson= new GsonBuilder().create();
        JsonObject carrelloJSON = gson.toJsonTree(carrelloSent).getAsJsonObject();
        System.out.println(carrelloJSON);
        Call<JsonObject> call = service.sendOrdine(carrelloJSON);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.isSuccessful()){
                    System.out.println("RISPOSTA SUSDHFGVISDFISD");
                }
                System.out.println(response.message());

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
