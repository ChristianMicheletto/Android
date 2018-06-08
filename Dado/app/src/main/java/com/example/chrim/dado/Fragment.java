package com.example.chrim.dado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;


public class Fragment extends android.app.Fragment {

    Random gen = new Random();
    int facciaUscita;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        imageView = view.findViewById(R.id.faccia);
        facciaUscita = gen.nextInt(6)+1;
        switch (facciaUscita) {
            case 1:
                imageView.setImageResource(R.drawable.faccia1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.faccia2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.faccia3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.faccia4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.faccia5);
                break;
            case 6:
                imageView.setImageResource(R.drawable.faccia6);
                break;
        }

        return view;
    }


}
