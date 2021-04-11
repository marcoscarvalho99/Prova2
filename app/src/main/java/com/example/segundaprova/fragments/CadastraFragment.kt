package com.example.segundaprova.fragments

import android.app.Application
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.room.Room
import com.example.segundaprova.R
import com.example.segundaprova.databinding.FragmentCadastraBinding
import com.example.segundaprova.dialogFragment.DialogTeste
import com.example.segundaprova.modelo.AppDatabase


class CadastraFragment : Fragment() {




lateinit var binding: FragmentCadastraBinding
lateinit var viewModel: CadastraFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra,container,false )
        viewModel = ViewModelProvider(this).get(CadastraFragmentViewModel::class.java)
        binding.lifecycleOwner
        binding.viewModelCadastrar = viewModel

        binding.buttonEditar.setOnClickListener {

            if(binding.editTextNome.text.toString() == "" || binding.editTextSobrenome.text.toString() == ""
                || binding.editTextNota1.text.toString() == "" || binding.editTextNota2.text.toString() == ""
                || binding.editTextTextNota3.toString() == "" || binding.editTextTextMatrcula.toString()== ""
            ){
                Toast.makeText(this.context,"adicione em todos os campos", Toast.LENGTH_LONG).show()
                }
            else{

               viewModel.cadastrar()
                Navigation.findNavController(requireView())
                    .navigate(CadastraFragmentDirections.actionCadastraFragmentToHomeFragment())

            }
        }

        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        if(item.itemId == R.id.ajuda){
            var dialog =
                DialogTeste(R.layout.cadastra_dialog)
            dialog.show(requireActivity().supportFragmentManager, "cadastra ajuda")
        }
        return NavigationUI.onNavDestinationSelected(item,this.findNavController()) || super.onOptionsItemSelected(item)


    }
}