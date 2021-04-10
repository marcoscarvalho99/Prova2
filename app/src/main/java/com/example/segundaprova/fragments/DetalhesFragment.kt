package com.example.segundaprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.example.segundaprova.R
import com.example.segundaprova.databinding.FragmentAlteraBinding
import com.example.segundaprova.databinding.FragmentDetalhesBinding
import com.example.segundaprova.modelo.AppDatabase


class DetalhesFragment : Fragment() {

    val db: AppDatabase by lazy {
        Room.databaseBuilder(
            this.requireContext(),
            AppDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

    }


lateinit var binding: FragmentDetalhesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
        val args: DetalhesFragmentArgs by navArgs()
        val aluno = db.alunoDao().findById(args.idAluno.toLong())

        binding.textViewNome.text= aluno.nome.toString()
        binding.textViewSobrenome.text= aluno.sobrenome.toString()
        binding.textViewNota1.text=aluno.nota1.toString()
        binding.textViewNota2.text=aluno.nota2.toString()
        binding.textViewNota3.text=aluno.nota3.toString()
        binding.textViewMatricula.text=aluno.matricula.toString()

        return binding.root
    }

}