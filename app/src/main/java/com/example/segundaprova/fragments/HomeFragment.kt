package com.example.segundaprova.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.segundaprova.MainActivity
import com.example.segundaprova.R
import com.example.segundaprova.databinding.FragmentHomeBinding
import com.example.segundaprova.reciclerView.AlunoAdapter
import com.example.segundaprova.reciclerView.NovoRecicleViewClickListener


class HomeFragment : Fragment() {




    lateinit var binding: FragmentHomeBinding


    lateinit var viewmodel:HomeFragmentViewModel
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
            ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false )

        viewmodel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)




        var adapter= AlunoAdapter()
        binding.reciclerView.adapter = adapter

        viewmodel._alunos.observe(viewLifecycleOwner, Observer {

            adapter.alunos = it
            adapter.notifyDataSetChanged()
        })

        val layout = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.reciclerView.layoutManager = layout



        binding.reciclerView.addOnItemTouchListener(NovoRecicleViewClickListener( this.requireActivity(),binding.reciclerView,
            object :NovoRecicleViewClickListener.OnItemClickListener {

                override fun onItemClick(view: View, position: Int) {
                    Log.i("Teste", "onSingleTapUp ")
                    Navigation.findNavController(requireView()).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(position+1))


                }

                override fun onItemLongClick(view: View, position: Int) {

                    Navigation.findNavController(requireView()).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(position+1))

                }


            }
        )
        )



        return binding.root
    }

}
