package com.example.chrim.ordernow;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;


public class AggiungiPiattoFrag extends DialogFragment implements NumberPicker.OnValueChangeListener {

    String tipo;
    private OnItemInserted listener;
    Double totale;
    Piatto piatto;
    Integer quantita;

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        quantita = newVal;
        Double costo = piatto.getCosto();
        totale = quantita * costo;
        ((TextView) getDialog().findViewById(R.id.totale)).setText(totale.toString());

    }

    public interface OnItemInserted {
        void onItemInserted(DatiCarrello datiCarrello);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_aggiungi_dialog, container);
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
        alertDialog.setView(R.layout.fragment_aggiungi_dialog);
        alertDialog.setPositiveButton("Ok",
                (dialog, whichButton) -> {
                    if (quantita > 0) {
                        if (listener != null)
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
