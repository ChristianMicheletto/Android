package com.example.chrim.ordernow;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class AdapterPiatti extends RecyclerView.Adapter<AdapterPiatti.ViewHolder> {
    private static Piatti piatti;
    private Context context;
    private String tipo;
    protected Carrello carrello;

    public AdapterPiatti(Piatti piatti, String tipo, Carrello carrello) {
        this.piatti = piatti;
        this.tipo= tipo;
        this.carrello= carrello;
    }


    @Override
    public AdapterPiatti.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context= parent.getContext();
        View viewHolder = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout_piatti, parent, false);
        return new AdapterPiatti.ViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(AdapterPiatti.ViewHolder holder, int position) {
        Piatto p = piatti.getPiatti().get(position);
        holder.setItem(p);
    }

    public void UpdateCarrello (Carrello carrello){
        this.carrello=carrello;
    }

    @Override
    public int getItemCount() {
        return piatti.getSize();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nome;
        private TextView ingredienti;
        private TextView costo;
        private Piatto piatto;


        public ViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nomePiatto);
            ingredienti = itemView.findViewById(R.id.ingredienti);
            costo = itemView.findViewById(R.id.costo);
            itemView.setOnClickListener(this);

        }

        public void setItem(Piatto piatto) {
            this.nome.setText(piatto.getNome());
            this.ingredienti.setText(piatto.getIngredienti());
            this.costo.setText(String.format("%s", piatto.getCosto()));
            this.piatto = piatto;
        }

        @Override
        public void onClick(View view) {
            FragmentManager manager = ((PiattoActivity) context).getSupportFragmentManager();
            AggiungiPiattoFrag dialogFragment = new AggiungiPiattoFrag();
            dialogFragment.piatto=piatto;
            dialogFragment.tipo= tipo;
            dialogFragment.carrello= carrello;
            dialogFragment.show(manager, "Aggiungi Piatto");

        }
    }
}

