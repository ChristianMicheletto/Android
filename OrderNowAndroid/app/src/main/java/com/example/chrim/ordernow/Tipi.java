package com.example.chrim.ordernow;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tipi {

    @SerializedName("Tipi")
    @Expose
    private List<Tipo> tipi = null;

    public List<Tipo> getTipi() {
        return tipi;
    }

    public void setTipi(List<Tipo> tipi) {
        this.tipi = tipi;
    }

    public int getSize(){
        return tipi.size();
    }

}

class Tipo {

    @SerializedName("Tipo")
    @Expose
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}