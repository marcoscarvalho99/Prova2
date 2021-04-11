package com.example.segundaprova

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.room.Room
import com.example.segundaprova.databinding.ActivityMainBinding
import com.example.segundaprova.modelo.AppDatabase

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val db: AppDatabase by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.myNavHostFragment)
      //  NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
        NavigationUI.setupActionBarWithNavController(this, navController,binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)


    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, binding.drawerLayout)


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