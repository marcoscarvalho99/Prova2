package com.example.segundaprova.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import androidx.room.Room.databaseBuilder
import com.example.segundaprova.R
import com.example.segundaprova.databinding.FragmentAlteraBinding
import com.example.segundaprova.dialogFragment.DialogTeste
import com.example.segundaprova.modelo.Aluno
import com.example.segundaprova.modelo.AppDatabase

class AlteraFragment : Fragment() {

    val db: AppDatabase by lazy {
        databaseBuilder(
            this.requireContext(),
            AppDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

    }

    lateinit var binding: FragmentAlteraBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)

        val args: AlteraFragmentArgs by navArgs()
        var aluno = db.alunoDao().findById(args.idAluno.toLong())
        binding.editTextNome.setText(aluno.nome.toString())
        binding.editTextSobrenome.setText(aluno.sobrenome.toString())
        binding.editTextNota1.setText(aluno.nota1.toString())
        binding.editTextNota2.setText(aluno.nota2.toString())
        binding.editTextTextNota3.setText(aluno.nota3.toString())
        binding.editTextTextMatrcula.setText(aluno.matricula.toString())

        binding.buttonEditar.setOnClickListener {
            val nome = binding.editTextNome.text.toString()
            val sobre = binding.editTextSobrenome.text.toString()
            val nota1 = binding.editTextNota1.text.toString().toInt()
            val nota2 = binding.editTextNota2.text.toString().toInt()
            val nota3 = binding.editTextTextNota3.text.toString().toInt()
            val mat = binding.editTextTextMatrcula.text.toString().toInt()

            var aluno = Aluno(args.idAluno.toLong(), nome, sobre, nota1, nota2, nota3, mat)


            db.alunoDao().atualizar(aluno)

            Toast.makeText(this.requireContext(), "Atualizado com sucesso", Toast.LENGTH_LONG)
                .show()
            Navigation.findNavController(requireView())
                .navigate(AlteraFragmentDirections.actionAlteraFragmentToHomeFragment2())

        }

        Log.i("Teste", args.idAluno.toString())
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        if (item.itemId == R.id.ajuda) {
            if (item.itemId == R.id.ajuda) {

                var dialog =
                    DialogTeste(R.layout.altera_dialog)
                dialog.show(requireActivity().supportFragmentManager, "home ajuda")

            }
        }
        return NavigationUI.onNavDestinationSelected(
            item,
            this.findNavController()
        ) || super.onOptionsItemSelected(item)


    }

}