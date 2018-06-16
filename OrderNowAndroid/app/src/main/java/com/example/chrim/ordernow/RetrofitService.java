package com.example.chrim.ordernow;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("client/{codiceRistorante}")
    Call<Ristoranti> getRistoranti(@Path("codiceRistorante") String codiceRistorante
    );

    @GET("client/getTipi/{codiceRistorante}")
    Call<Tipi> getTipiByCod(@Path("codiceRistorante") String codiceRistorante
    );

    @GET("client/getPiatti/{codiceRistorante}/{tipo}")
    Call<Piatti> getMenuByTipo(@Path("codiceRistorante") String codiceRistorante, @Path("tipo") String tipo
    );

    @POST("ordina")
    Call<JsonObject> sendOrdine (@Body JsonObject carrello);
}
