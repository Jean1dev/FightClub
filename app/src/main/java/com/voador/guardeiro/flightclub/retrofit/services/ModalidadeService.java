package com.voador.guardeiro.flightclub.retrofit.services;

import com.voador.guardeiro.flightclub.retrofit.models.AlunoRetrofit;
import com.voador.guardeiro.flightclub.retrofit.models.ModalidadeRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ModalidadeService {

    @GET("modalidade/buscar")
    Call<List<ModalidadeRetrofit>> buscarModalidade(@Query("id_conta") long contaId);

    @POST("modalidade/incluir")
    Call<Long> inserirModalidade(@Body final ModalidadeRetrofit modalidade);

    @POST("modalidade/excluir")
    Call<Boolean> excluirModalidade(@Query("id_modalidade") long id_modalidade);

}
