package com.voador.guardeiro.flightclub.retrofit.services;

import com.voador.guardeiro.flightclub.models.Matricula;
import com.voador.guardeiro.flightclub.retrofit.models.AlunoRetrofit;
import com.voador.guardeiro.flightclub.retrofit.models.MatriculModalidadeRetrofit;
import com.voador.guardeiro.flightclub.retrofit.models.MatriculaRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MatriculaService {

    @POST("matricula/incluir")
    Call<Long> incluirMatricula(@Body final MatriculaRetrofit matricula);

    @POST("matriculas/modalidade/incluir")
    Call<Long> incluirMatriculaModalidade(@Body final MatriculModalidadeRetrofit matriculaModalidade);

    @POST("matriculas/modalidade/encerrar")
    Call<Boolean> excluirAluno(@Query("id_aluno") long idAluno);



}
