package com.example.chrim.ordernow;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Carrello implements Parcelable {

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

    public Carrello() {
        this.carrello= null;
    }

    protected Carrello(Parcel in) {
        if (in.readByte() == 0) {
            prezzoTotale = null;
        } else {
            prezzoTotale = in.readDouble();
        }
        carrello = in.createTypedArrayList(DatiCarrello.CREATOR);
        tavolo = in.readString();
        codiceRistorante = in.readString();
    }

    public static final Creator<Carrello> CREATOR = new Creator<Carrello>() {
        @Override
        public Carrello createFromParcel(Parcel in) {
            return new Carrello(in);
        }

        @Override
        public Carrello[] newArray(int size) {
            return new Carrello[size];
        }
    };

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

    public void DeleteDatiCarrelloByNome(String nome){
        for (int i =0; i<carrello.size(); i++){
            if(carrello.get(i).getNome().equals(nome)){
                carrello.remove(i);
                break;
            }
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (prezzoTotale == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(prezzoTotale);
        }
        parcel.writeTypedList(carrello);
        parcel.writeString(tavolo);
        parcel.writeString(codiceRistorante);
    }

    public int getSize(){
        return carrello.size();
    }

    public Double ricalcolaTot(){
        for (int i= 0; i<carrello.size(); i++){
            prezzoTotale+=getCarrello().get(i).getPrezzo();
        }
    }
}
class DatiCarrello implements Parcelable {

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

    protected DatiCarrello(Parcel in) {
        tipo = in.readString();
        nome = in.readString();
        if (in.readByte() == 0) {
            costo = null;
        } else {
            costo = in.readDouble();
        }
        ingredienti = in.readString();
        if (in.readByte() == 0) {
            quantita = null;
        } else {
            quantita = in.readInt();
        }
        if (in.readByte() == 0) {
            prezzo = null;
        } else {
            prezzo = in.readDouble();
        }
    }

    public static final Creator<DatiCarrello> CREATOR = new Creator<DatiCarrello>() {
        @Override
        public DatiCarrello createFromParcel(Parcel in) {
            return new DatiCarrello(in);
        }

        @Override
        public DatiCarrello[] newArray(int size) {
            return new DatiCarrello[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tipo);
        parcel.writeString(nome);
        if (costo == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(costo);
        }
        parcel.writeString(ingredienti);
        if (quantita == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(quantita);
        }
        if (prezzo == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(prezzo);
        }
    }
}

