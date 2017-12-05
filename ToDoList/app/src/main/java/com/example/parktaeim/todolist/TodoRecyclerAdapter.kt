package com.example.parktaeim.todolist

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.item_todo_recyclerview.view.*

/**
 * Created by parktaeim on 2017. 11. 29..
 */

class TodoRecyclerAdapter() : RecyclerView.Adapter<TodoRecyclerAdapter.ViewHolder>(){
    var finishtodo: ArrayList<TodoItem> = ArrayList<TodoItem>()
    var items = ArrayList<TodoItem>()

    constructor(items:ArrayList<TodoItem>):this(){
        this.items = items
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(items[position])

        // longClick하면 삭제
        holder.itemView.setOnClickListener {
            items.removeAt(position)
            notifyDataSetChanged()
        }

        holder.itemView.finishBtn.setOnClickListener {
            finishtodo.add(TodoItem(items[position].title,items[position].desc))
            items.removeAt(position)
            notifyDataSetChanged()

            Log.d("adap finishtodo[0]===",finishtodo[0].title)

        }
    }

    fun getFinishList(): ArrayList<TodoItem> {
        Log.d("get finishtodo[0]===",finishtodo[0].title)
        return finishtodo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_todo_recyclerview,parent,false)
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(todoData: TodoItem) {
            val todoTitleTextView: TextView = itemView.findViewById(R.id.todoTitleTextView)
            val todoDescTextView: TextView = itemView.findViewById(R.id.todoDescTextView)
            val finishBtn: Button = itemView.findViewById(R.id.finishBtn)

            todoTitleTextView.text = todoData.title
            todoDescTextView.text = todoData.desc

        }
    }

}