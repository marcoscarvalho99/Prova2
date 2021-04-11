package com.example.segundaprova.dialogFragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogTeste(frag:Int): DialogFragment() {
    var frag = frag
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       
        return activity?.let {
            var builder=AlertDialog.Builder(it)
                .setView(it.layoutInflater.inflate(frag,null))
                .setPositiveButton("Ok"){dialogInterface, i ->

                }
            builder.create()

        }   ?: throw IllegalStateException("Activity not found")



    }


}