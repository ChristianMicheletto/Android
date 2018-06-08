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
    protected double totale;
    protected Piatto piatto;
    protected int quantita;
    View view;
    protected Carrello carrello;


    public interface OnItemInserted {
        void onItemInserted(DatiCarrello datiCarrello);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MenuActivity activity = context instanceof MenuActivity ? (MenuActivity) context : null;
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
        String titleText = "Aggiungi piatti";
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
            double costo = piatto.getCosto();
            totale = quantita * costo;
            System.out.println("Costo "+costo);
            System.out.println("Totale "+totale);
            System.out.println("Quantita "+quantita);
            ((TextView) getDialog().findViewById(R.id.totale)).setText("" + totale);
        });
        alertDialog.setPositiveButton("Ok",
                (dialog, whichButton) -> {
                    if (quantita > 0) {
                        if (listener != null)
                            carrello.setPrezzoTotale(totale);
                            carrello.AddDatiCarrello(tipo, piatto.getNome(), piatto.getCosto(),
                                    piatto.getIngredienti(), quantita, totale);
                            listener.onItemInserted(new DatiCarrello(tipo, piatto.getNome(), piatto.getCosto(),
                                    piatto.getIngredienti(), quantita, totale));
                    } else {
                        Toast.makeText(getContext(), "La quantità non può essere 0", Toast.LENGTH_SHORT).show();
                        dismiss();
                    }


                }
        );
        alertDialog.setNegativeButton("Cancel",
                (dialog, whichButton) -> dialog.dismiss()
        );
        return alertDialog.create();
    }

}
