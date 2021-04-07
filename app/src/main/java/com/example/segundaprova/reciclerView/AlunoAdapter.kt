package com.example.segundaprova.reciclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.segundaprova.R
import com.example.segundaprova.modelo.Aluno
import java.util.ArrayList

class AlunoAdapter : RecyclerView.Adapter<AlunoViewHolde>() {

    var alunos: List<Aluno> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolde {

        var v = LayoutInflater.from(parent.context).inflate(R.layout.aluno_inflater,parent,false);
//        var alunos:List<Aluno> = ArrayList()
//        val holder =AlunoViewHolde(v)
        return  AlunoViewHolde(v)
    }

    override fun onBindViewHolder(holder: AlunoViewHolde, position: Int) {

        val alunoescolhido = alunos.get(position)
        holder.nomeAluno.text = alunoescolhido.nome
        holder.matricula.text = alunoescolhido.matricula.toString()
        holder.sobreNome.text=alunoescolhido.sobrenome
        holder.nota1.text = alunoescolhido.nota1.toString()
        holder.nota2.text = alunoescolhido.nota2.toString()
        holder.nota3.text = alunoescolhido.nota3.toString()

    }
    override fun getItemCount(): Int {
        return alunos.size
    }
}

class AlunoViewHolde(v: View) : RecyclerView.ViewHolder(v ) {

    val nomeAluno : TextView
    val sobreNome : TextView
    val nota1 : TextView
    val nota2 : TextView
    val nota3 : TextView
    val matricula : TextView

    init {

        nomeAluno = v.findViewById<TextView>(R.id.nomeAluno)
        sobreNome = v.findViewById<TextView>(R.id.sobreNome)
        nota1 = v.findViewById<TextView>(R.id.nota1)
        nota2 = v.findViewById<TextView>(R.id.nota2)
        nota3 = v.findViewById<TextView>(R.id.nota3)
        matricula = v.findViewById<TextView>(R.id.matricula)
    }

}