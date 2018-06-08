package com.example.chrim.ordernow;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Carrello {

    @SerializedName("prezzoTotale")
    @Expose
    private Double prezzoTotale;
    @SerializedName("Carrello")
    @Expose
    private List<DatiCarrello> carrello = null;
    @SerializedName("Tavolo")
    @Expose
    private String tavolo;
    @SerializedName("CodiceRistorante")
    @Expose
    private String codiceRistorante;

    public Double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(Double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public List<DatiCarrello> getCarrello() {
        return carrello;
    }

    public void setCarrello(List<DatiCarrello> carrello) {
        this.carrello = carrello;
    }

    public String getTavolo() {
        return tavolo;
    }

    public void setTavolo(String tavolo) {
        this.tavolo = tavolo;
    }

    public String getCodiceRistorante() {
        return codiceRistorante;
    }

    public void setCodiceRistorante(String codiceRistorante) {
        this.codiceRistorante = codiceRistorante;
    }

    public void AddDatiCarrello(String tipo, String nome, Double costo, String ingredienti, Integer quantita, Double prezzo){
        new DatiCarrello(tipo,nome,costo,ingredienti,quantita,prezzo);
    }



}
class DatiCarrello {

    @SerializedName("Tipo")
    @Expose
    private String tipo;
    @SerializedName("Nome")
    @Expose
    private String nome;
    @SerializedName("Costo")
    @Expose
    private Double costo;
    @SerializedName("Ingredienti")
    @Expose
    private String ingredienti;
    @SerializedName("Quantita")
    @Expose
    private Integer quantita;
    @SerializedName("Prezzo")
    @Expose
    private Double prezzo;

    public DatiCarrello() {
    }

    public DatiCarrello(String tipo, String nome, Double costo, String ingredienti, Integer quantita, Double prezzo) {
        super();
        this.tipo = tipo;
        this.nome = nome;
        this.costo = costo;
        this.ingredienti = ingredienti;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

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

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

}

