package com.example.segundaprova.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.segundaprova.modelo.Aluno
import com.example.segundaprova.modelo.AppDatabase

class HomeFragmentViewModel(application: Application): AndroidViewModel(application){

     var _alunos :LiveData <List<Aluno>>

    init {
        val db: AppDatabase by lazy {
            Room.databaseBuilder(
                    application.applicationContext,
                    AppDatabase::class.java, "database-name")
                    .allowMainThreadQueries()
                    .build()

        }

        _alunos = db.alunoDao().listAll()


    }


}