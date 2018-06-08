package com.example.chrim.ordernow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class CarrelloActivity extends AppCompatActivity implements EditCarrelloFrag.OnItemInserted {

    private RecyclerView recyclerView;
    private AdapterTipi adapterTipi;
    Carrello carrello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrello);
    }

    @Override
    public void onItemInserted(DatiCarrello datiCarrello) {

    }
}
