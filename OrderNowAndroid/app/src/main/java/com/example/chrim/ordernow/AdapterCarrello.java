package com.example.chrim.ordernow;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class AdapterCarrello extends RecyclerView.Adapter<AdapterCarrello.ViewHolder> {
    private static Piatti piatti;
    private Context context;
    private String tipo;
    private Carrello carrello;

    public AdapterCarrello(Context context, Carrello carrello) {
        this.context = context;
        this.carrello= carrello;
    }


    @Override
    public AdapterCarrello.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewHolder= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout_carrello, parent, false);
        return new AdapterCarrello.ViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(AdapterCarrello.ViewHolder holder, int position) {
        DatiCarrello c = carrello.getCarrello().get(position);
        holder.setItem(c);
    }

    @Override
    public int getItemCount() {
        return carrello.getSize();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nome;
        private TextView ingredienti;
        private TextView quantita;
        private TextView costoTot;
        private DatiCarrello datiCarrello;


        public ViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nomePiatto);
            ingredienti = itemView.findViewById(R.id.ingredienti);
            costoTot = itemView.findViewById(R.id.costoTot);
            quantita = itemView.findViewById(R.id.quantita);
            itemView.setOnClickListener(this);

        }

        public void setItem(DatiCarrello datiCarrello) {
            this.nome.setText(datiCarrello.getNome());
            this.ingredienti.setText(datiCarrello.getIngredienti());
            this.costoTot.setText(""+datiCarrello.getPrezzo());
            this.quantita.setText(""+datiCarrello.getQuantita());
            this.datiCarrello = datiCarrello;
        }

        @Override
        public void onClick(View view) {
            FragmentManager manager = ((CarrelloActivity) context).getSupportFragmentManager();
            EditCarrelloFrag dialogFragment = new EditCarrelloFrag();
            dialogFragment.piatto=piatto;
            dialogFragment.tipo= tipo;
            dialogFragment.carrello= carrello;
            dialogFragment.show(manager, "Aggiungi Piatto");

        }
    }
}
