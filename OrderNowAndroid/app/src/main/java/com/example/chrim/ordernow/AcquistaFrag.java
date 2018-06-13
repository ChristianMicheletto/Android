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

public class AcquistaFrag extends DialogFragment {

    protected OnItemSent listener;
    View view;
    protected Carrello carrello;


    public interface OnItemSent {
        void onItemSent(Carrello carrello);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        CarrelloActivity activity = context instanceof CarrelloActivity ? (CarrelloActivity) context : null;
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
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_aggiungi_dialog, null);
        String titleText = "Inserisci il numero del tavolo";
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getContext().getResources().getColor(R.color.rosso));
        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(titleText);
        ssBuilder.setSpan(
                foregroundColorSpan,
                0,
                titleText.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        alertDialog.setTitle(ssBuilder);
        alertDialog.setView(view);
        alertDialog.setPositiveButton("Ok",
                (dialog, whichButton) -> {
                    if (listener != null) {
                        listener.onItemSent(carrello);
                    }
                }
        );
        alertDialog.setNegativeButton("Cancel",
                (dialog, whichButton) -> dialog.dismiss()
        );
        return alertDialog.create();
    }

}


