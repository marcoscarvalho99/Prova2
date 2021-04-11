package com.example.segundaprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.segundaprova.R
import com.example.segundaprova.databinding.FragmentSobreBinding



class SobreFragment : Fragment() {

lateinit var binding: FragmentSobreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sobre,container,false )
        var texto = R.string.desenvolvedor

        binding.textViewDesenvolvedor.text= getString(texto)
       
        return binding.root
    }


}