package com.example.segundaprova.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity
    data class Aluno (

        @PrimaryKey(autoGenerate = true)  val id:Long,
        @ColumnInfo(name="nome") val nome:String?,
        @ColumnInfo(name="sobrenome") val sobrenome:String?,
        @ColumnInfo(name="nota1") val nota1:Int?,
        @ColumnInfo(name="nota2") val nota2:Int?,
        @ColumnInfo(name="nota3") val nota3:Int?,
        @ColumnInfo(name="matricula") val matricula:Int?


    )
