package com.example.chrim.ordernow;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Piatti {

    @SerializedName("Piatti")
    @Expose
    private List<Piatto> piatti = null;

    public List<Piatto> getPiatti() {
        return piatti;
    }

    public void setPiatti(List<Piatto> piatti) {
        this.piatti = piatti;
    }

    public int getSize(){
        return piatti.size();
    }

    @Override
    public String toString() {
        return "Piatti{" +
                "piatti=" + piatti +
                '}';
    }
}

class Piatto {
    @SerializedName("Nome")
    @Expose
    private String nome;
    @SerializedName("Costo")
    @Expose
    private Double costo;
    @SerializedName("Ingredienti")
    @Expose
    private String ingredienti;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }



    @Override
    public String toString() {
        return "Piatto{" +
                ", nome='" + nome + '\'' +
                ", costo=" + costo +
                ", ingredienti='" + ingredienti + '\'' +
                '}';
    }
}


