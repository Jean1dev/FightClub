package com.voador.guardeiro.flightclub.retrofit.services;

import com.voador.guardeiro.flightclub.retrofit.models.PlanoRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PlanoService {

    @GET("planos/buscar")
    Call<List<PlanoRetrofit>> buscarTodos(@Query("id_conta") long contaId, @Query("id_modalidade") long modalidadeId);

    @POST("planos/incluir")
    Call<Boolean> inserir(@Body final PlanoRetrofit plano);

}
