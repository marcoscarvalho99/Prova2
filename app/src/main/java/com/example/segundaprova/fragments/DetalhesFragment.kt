package com.example.segundaprova.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import androidx.room.Room
import com.example.segundaprova.R
import com.example.segundaprova.databinding.FragmentDetalhesBinding
import com.example.segundaprova.dialogFragment.DialogTeste
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

        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        if(item.itemId == R.id.ajuda){
            if(item.itemId == R.id.ajuda){

                var dialog =
                    DialogTeste(R.layout.detalhes_dialog)
                dialog.show(requireActivity().supportFragmentManager, "home ajuda")

            }
        }
        return NavigationUI.onNavDestinationSelected(item,this.findNavController()) || super.onOptionsItemSelected(item)


    }
}