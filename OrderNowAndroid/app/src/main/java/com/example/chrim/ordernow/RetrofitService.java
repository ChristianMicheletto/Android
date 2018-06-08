package com.example.chrim.ordernow;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("{codiceRistorante}")
    Call<Ristoranti> getRistoranti(@Path("codiceRistorante") String codiceRistorante
    );

    @GET("getTipi/{codiceRistorante}")
    Call<Tipi> getTipiByCod(@Path("codiceRistorante") String codiceRistorante
    );

    @GET("getPiatti/{codiceRistorante}/{tipo}")
    Call<Piatti> getMenuByTipo(@Path("codiceRistorante") String codiceRistorante, @Path("tipo") String tipo
    );

}
