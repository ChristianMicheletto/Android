package com.example.chrim.ordernow;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Ristoranti {

    @SerializedName("Dati")
    @Expose
    private List<Ristorante> ristoranti = null;

    public List<Ristorante> getRistoranti() {
        return ristoranti;
    }

    public void setRistoranti(List<Ristorante> dati) {
        this.ristoranti = ristoranti;
    }

}

class Ristorante {

    @SerializedName("TipoRistorante")
    @Expose
    private String tipoRistorante;
    @SerializedName("NomeRistorante")
    @Expose
    private String nomeRistorante;

    public String getTipoRistorante() {
        return tipoRistorante;
    }

    public void setTipoRistorante(String tipoRistorante) {
        this.tipoRistorante = tipoRistorante;
    }

    public String getNomeRistorante() {
        return nomeRistorante;
    }

    public void setNomeRistorante(String nomeRistorante) {
        this.nomeRistorante = nomeRistorante;
    }

}