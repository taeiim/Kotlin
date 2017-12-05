package com.example.parktaeim.todolist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by parktaeim on 2017. 12. 4..
 */

class FinishTodoRecyclerAdapter(val items:ArrayList<TodoItem>) : RecyclerView.Adapter<FinishTodoRecyclerAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent!!.context).inflate(R.layout.item_finish_todo_recyclerview,parent,false)
        return ViewHolder(v)
    }

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){

        fun bindView(finishTodoData:TodoItem){
            val finish_todoTitleTextView: TextView = itemView.findViewById(R.id.finish_todoTitleTextView)
            val finish_todoDescTextView: TextView = itemView.findViewById(R.id.finish_todoDescTextView)

            finish_todoTitleTextView.text = finishTodoData.title
            finish_todoDescTextView.text = finishTodoData.desc

        }
    }
}