package com.example.segundaprova.fragments

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.segundaprova.databinding.FragmentCadastraBinding
import com.example.segundaprova.modelo.Aluno
import com.example.segundaprova.modelo.AppDatabase

class CadastraFragmentViewModel(application: Application) : AndroidViewModel(application){

    var nome :String= ""
    var _sobrenome :String=""
    var _nota1 :String=""
    var _nota2 :String=""
    var _nota3 :String=""
    var _matricula :String=""


        val db: AppDatabase by lazy {
            Room.databaseBuilder(
                application.applicationContext,
                AppDatabase::class.java, "database-name")
                .allowMainThreadQueries()
                .build()

        }




    fun cadastrar(){

        var aluno = Aluno(0,nome.toString(),_sobrenome.toString(),_nota1.toInt(),_nota2.toInt(),_nota3.toInt(),_matricula.toInt())

        try {
            db.alunoDao().inserir(aluno)
        }catch (e:Exception){

        }


    }

    }