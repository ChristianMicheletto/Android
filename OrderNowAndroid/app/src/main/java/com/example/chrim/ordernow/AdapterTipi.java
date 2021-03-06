package com.example.chrim.ordernow;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AdapterTipi extends RecyclerView.Adapter<AdapterTipi.ViewHolder> {

    private static Tipi tipi;
    private Context context;
    private Carrello carrello;

    public AdapterTipi(Context context, Tipi tipi, Carrello carrello) {
        this.context = context;
        this.tipi = tipi;
        this.carrello= carrello;
    }

    public void UpdateCarrello (Carrello carrello){
        this.carrello=carrello;
    }


    @Override
    public AdapterTipi.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout_tipi, parent, false);
        return new AdapterTipi.ViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(AdapterTipi.ViewHolder holder, int position) {
        Tipo v = tipi.getTipi().get(position);
        holder.setItem(v);
    }

    @Override
    public int getItemCount() {
        return tipi.getSize();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView nome;
        private Tipo tipo;

        public ViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nomeTipo);
            itemView.setOnClickListener(this);

        }

        public void setItem(Tipo tipo) {
            this.nome.setText(tipo.getTipo());
            this.tipo = tipo;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, PiattoActivity.class);
            intent.putExtra("tipo", tipo.getTipo());
            intent.putExtra("codRistorante", carrello.getCodiceRistorante());
            intent.putExtra("CarrelloDaTipi", carrello);
            ((TipiActivity) context).startActivityForResult(intent,1);
        }
    }
}