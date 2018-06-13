package com.example.chrim.ordernow;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class AggiungiPiattoFrag extends DialogFragment {

    String tipo;
    protected OnItemInserted listener;
    protected double prezzo;
    protected Piatto piatto;
    protected int quantita;
    View view;
    protected Carrello carrello;
    protected double costo;


    public interface OnItemInserted {
        void onItemInserted(DatiCarrello datiCarrello);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        PiattoActivity activity = context instanceof PiattoActivity ? (PiattoActivity) context : null;
        try {
            listener = activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        String titleText = "Aggiungi "+ piatto.getNome();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getContext().getResources().getColor(R.color.rosso));
        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(titleText);
        ssBuilder.setSpan(
                foregroundColorSpan,
                0,
                titleText.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        alertDialog.setTitle(ssBuilder);
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_aggiungi_dialog, null);
        alertDialog.setView(view);
        final NumberPicker numberPicker = view.findViewById(R.id.nPiatti);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(10);
        numberPicker.setOnValueChangedListener((numberPicker1, oldVal, newVal) -> {
            quantita = newVal;
            costo = piatto.getCosto();
            prezzo = quantita * costo;
            ((TextView) getDialog().findViewById(R.id.prezzo)).setText(String.format("%s", prezzo));
        });
        alertDialog.setPositiveButton("Ok",
                (dialog, whichButton) -> {
                    if (quantita > 0) {
                        if (listener != null){
                          listener.onItemInserted(new DatiCarrello(tipo,piatto.getNome(),costo,piatto.getIngredienti(),quantita,prezzo));
                        }
                    }
                }
        );
        alertDialog.setNegativeButton("Cancel",
                (dialog, whichButton) -> dialog.dismiss()
        );
        return alertDialog.create();
    }

}
