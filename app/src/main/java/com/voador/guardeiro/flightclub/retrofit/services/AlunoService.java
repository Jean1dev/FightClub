package com.voador.guardeiro.flightclub.retrofit.services;

import com.voador.guardeiro.flightclub.retrofit.models.AlunoRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AlunoService {

    @GET("aluno/buscar")
    Call<List<AlunoRetrofit>> buscarAlunos(@Query("id_conta") long contaId);

    @POST("aluno/incluir")
    Call<Boolean> inserirAluno(@Body final AlunoRetrofit aluno);

}
