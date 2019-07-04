package com.voador.guardeiro.flightclub.retrofit.services;

import com.voador.guardeiro.flightclub.retrofit.models.GraduacaoRetrofit;
import com.voador.guardeiro.flightclub.retrofit.models.PlanoRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GraduacaoService {

    @GET("graduacao/buscar")
    Call<List<GraduacaoRetrofit>> buscarTodos(@Query("id_conta") long contaId, @Query("id_modalidade") long planoId);

    @POST("graduacao/incluir")
    Call<Long> inserirGraduacao(@Body final GraduacaoRetrofit graduacao);

    @POST("graduacao/excluir")
    Call<Boolean> excluirPlano(@Query("id_graduacao") long graduacaoID);

}
