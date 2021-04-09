package com.example.segundaprova.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.segundaprova.R
import com.example.segundaprova.databinding.FragmentAlteraBinding
import com.example.segundaprova.databinding.FragmentAlteraBindingImpl

class AlteraFragment : Fragment() {
lateinit var binding: FragmentAlteraBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera,container,false )


        val  args:AlteraFragmentArgs by navArgs ()
        Log.i("Teste", args.idAluno.toString())

//val args= AlteraFragmentArgs.fromBundle(requireArguments())
  //      Toast.makeText(this.requireContext(),args.idAluno,Toast.LENGTH_LONG).show()




        return binding.root
    }

}