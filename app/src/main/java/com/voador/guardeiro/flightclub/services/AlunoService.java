package com.voador.guardeiro.flightclub.services;

import com.voador.guardeiro.flightclub.models.Aluno;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AlunoService {

    @GET("aluno/buscar")
    Call<List<Aluno>> buscarAlunos(@Query("id_conta") long contaId);

}
