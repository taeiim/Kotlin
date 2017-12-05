package com.example.parktaeim.todolist

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_finishtodo.*

/**
 * Created by parktaeim on 2017. 12. 1..
 */

class FinishTodoActivity : AppCompatActivity() {
    var finishTodo:ArrayList<TodoItem> = ArrayList()
    var num : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finishtodo)

        //뒤로가기
        icon_back.setOnClickListener { finish() }


        val todoRecyclerAdapter = TodoRecyclerAdapter()
        finishTodo = todoRecyclerAdapter.getFinishList()


        Log.d("finishtood Activity==",finishTodo.toString())
        Log.d("finishtood num==",num.toString())

        val finishRecyclerView:RecyclerView? = findViewById(R.id.finishTodoRecyclerView)
        finishRecyclerView!!.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)

        val adapter = FinishTodoRecyclerAdapter(finishTodo)
        finishRecyclerView.adapter = adapter


    }

//    fun setData(finishTodo:ArrayList<TodoItem>,num:Int){
//        this.finishTodo= finishTodo
//        this.num = num
//        Log.d("inner setData==",finishTodo.toString())
//        Log.d("inner setData num==",num.toString())
//
//    }
}
