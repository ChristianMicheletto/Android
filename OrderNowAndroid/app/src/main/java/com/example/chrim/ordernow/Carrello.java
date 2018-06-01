package com.example.chrim.ordernow;

import android.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Carrello {

    Double totale;
    Map<Double, Pair<Piatto, Integer>> carrello;
    Piatto piatto;

    public Carrello() {
        carrello = new HashMap<>();
    }

    public Double getTotale() {
        return totale;
    }

    public void setTotale(Double totale) {
        this.totale = totale;
    }

    public Map<Double, Pair<Piatto, Integer>> getCarrello() {
        return carrello;
    }

    public void setCarrello(Map<Double, Pair<Piatto, Integer>> carrello) {
        this.carrello = carrello;
    }

    public void addPiatto(Piatto p, int quantita, Double costo) {
        carrello.put(costo, new Pair<>(p, quantita));
        totale += costo;

    }

    public void ricalcolaTotale() {
        totale = 0d;
        Double[] app = (Double[]) carrello.keySet().toArray();
        for (int k = 0; k < app.length; k++) {
            totale += app[k];
        }
    }

    @Override
    public String toString() {
        return "Carrello{" +
                "carrello=" + carrello +
                '}';
    }
}


