package com.example.segundaprova

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.segundaprova.modelo.Aluno
import com.example.segundaprova.modelo.AppDatabase

class MainActivity : AppCompatActivity() {

    val db: AppDatabase by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java, "database-name")
            .allowMainThreadQueries()
            .build()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var aluno = Aluno(0,"marcos","sergio",1,2,3,234)
        db.alunoDao().inserir(aluno)
        //var user = db.usuarioDao().findById(1)

        var user = listarAlunos()
        user.execute(1);
    }
    private inner class listarAlunos : AsyncTask<Int, Int, Void>() {

        override fun doInBackground(vararg p: Int?): Void? {
            if (p[0] != null) {
                var id = p[0]
                val aluno = db.alunoDao().findById(id.toString().toLong())
                Log.i("TESTANDO", aluno.toString())
            } else {

                var alunos = db.alunoDao().listAll()
                Log.i("TESTANDO", alunos.toString())
            }
            return null
        }
    }

}