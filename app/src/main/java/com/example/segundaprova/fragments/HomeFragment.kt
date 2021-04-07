package com.example.segundaprova.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.segundaprova.R
import com.example.segundaprova.databinding.FragmentHomeBinding
import com.example.segundaprova.reciclerView.AlunoAdapter


class HomeFragment : Fragment() {

//    val db: AppDatabase by lazy {
//        Room.databaseBuilder(
//            activity!!.applicationContext,
//            AppDatabase::class.java, "database-name")
//            .allowMainThreadQueries()
//            .build()
//
//    }


    lateinit var binding: FragmentHomeBinding

    lateinit var viewmodel:HomeFragmentViewModel
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
            ): View? {

       // var aluno = Aluno(0,"marcos","sergio",1,2,3,234)
        //db.alunoDao().inserir(aluno)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false )

        viewmodel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        //fragment = HomeFragmentViewModel(activity!!.application)
       // var listaAlunos:List<Aluno> = fragment.list

        //var listaAlunos:List<Aluno> = viewmodel.alunos as List<Aluno>

       // var listaAlunos:LiveData<List<Aluno>> = db.alunoDao().listAll()


        var adapter= AlunoAdapter()

        binding.reciclerView.adapter = adapter

        viewmodel._alunos.observe(viewLifecycleOwner, Observer {

            adapter.alunos = it
            adapter.notifyDataSetChanged()
        })

        val layout = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.reciclerView.layoutManager = layout

        return binding.root
    }

}