package com.example.segundaprova.reciclerView

import android.content.Context
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class NovoRecicleViewClickListener(val context: Context, val recyclerView: RecyclerView, listener: OnItemClickListener) :RecyclerView.OnItemTouchListener {

    var myGestureDetector:GestureDetector

    init {

        myGestureDetector= GestureDetector(context,object :
             GestureDetector.SimpleOnGestureListener(){


            override fun onSingleTapUp(e: MotionEvent): Boolean {
                super.onSingleTapUp(e)

                val childView = recyclerView.findChildViewUnder(e.x, e.y)
                if (childView != null) {
                    listener.onItemClick(childView, recyclerView.getChildAdapterPosition(childView))
                    Log.i("Teste", "onSingleTapUp ")
                }
                return true

            }

            override fun onLongPress(e: MotionEvent) {
                super.onLongPress(e)

                val childView = recyclerView.findChildViewUnder(e.x, e.y)
                if (childView != null) {
                    listener.onItemLongClick(
                        childView,
                        recyclerView.getChildAdapterPosition(childView)
                    )
                    Log.i("Teste", "onLongPress")
                }

            }
        })
    }
    lateinit var listener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }
    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
       //Toast.makeText(this.context,"dede",Toast.LENGTH_LONG).show()
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        //Toast.makeText(this.context,"dede",Toast.LENGTH_LONG).show()

        myGestureDetector.onTouchEvent(e)
        return false


    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        TODO("Not yet implemented")
    }

    object a:NovoRecicleViewClickListener.OnItemClickListener{
        override fun onItemClick(view: View, position: Int) {

    }

        override fun onItemLongClick(view: View, position: Int) {

        }

    }

}