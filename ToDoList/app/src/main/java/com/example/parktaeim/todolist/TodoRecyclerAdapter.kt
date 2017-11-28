package com.example.parktaeim.todolist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by parktaeim on 2017. 11. 29..
 */

class TodoRecyclerAdapter(val list:ArrayList<TodoItem>) : RecyclerView.Adapter<TodoRecyclerAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_todo_recyclerview,parent,false)
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(todoData:TodoItem) {
            val todoTitleTextView: TextView = itemView.findViewById(R.id.todoTitleTextView)
            val todoDescTextView: TextView = itemView.findViewById(R.id.todoDescTextView)

            todoTitleTextView.text = todoData.title
            todoDescTextView.text = todoData.desc
//
//            itemView.setOnLongClickListener {
//                //delete
//            }
        }

    }
}