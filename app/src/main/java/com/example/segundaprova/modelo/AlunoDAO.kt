package com.example.segundaprova.modelo

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AlunoDAO {

    @Insert
    fun inserir(aluno: Aluno): Long
    @Delete
    fun deletar(aluno: Aluno): Int
    @Update
    fun atualizar(aluno: Aluno): Int
    @Query("SELECT * FROM Aluno")
    fun listAll(): LiveData<List<Aluno>>
    @Query("SELECT * FROM Aluno WHERE id = :id")
    fun findById(id: Long): Aluno
    @Query("SELECT * FROM Aluno WHERE nome = :nome")
    fun findByName (nome: String) : Aluno

}