package com.example.segundaprova.modelo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Aluno::class], version = 1)

abstract class AppDatabase : RoomDatabase() {
    abstract fun alunoDao(): AlunoDAO


}