package com.example.parktaeim.todolist

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_add_todo.*
import kotlinx.android.synthetic.main.dialog_add_todo.view.*
import kotlinx.android.synthetic.main.item_todo_recyclerview.*
import kotlinx.android.synthetic.main.item_todo_recyclerview.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView = findViewById(R.id.todoRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        val items = ArrayList<TodoItem>()

        val adapter = TodoRecyclerAdapter(items)

        recyclerView.adapter = adapter
        items.add(TodoItem("내일은 정말 열심히하기","ㅋㅋㅋㅋㅋㅋㅋㅋㅋ뭐래"))


        icon_addTodo.setOnClickListener {
            // 다이얼로그 layout inflate
            var inflater:LayoutInflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val layout:View = inflater.inflate(R.layout.dialog_add_todo, null)

            var dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setView(layout)

            var dialog :AlertDialog = dialogBuilder.create()
            dialog.show()

            //취소 버튼
            layout.cancelBtn_todoDialog.setOnClickListener { dialog.cancel() }

            //확인 버튼
            layout.okBtn_todoDialog.setOnClickListener {
                // editText 입력값 가져오기
                var todoTitle:String = layout.todoTitleEditText.text.toString()
                var todoDesc:String = layout.todoDescEditText.text.toString()

                //EditText 입력안했나 체크
//                if(todoTitle.isNullOrBlank() || todoDesc.isNullOrEmpty()){
//                    Toast.makeText(this,"모두 입력해주세요!", Toast.LENGTH_SHORT)
//                    return@setOnClickListener
//                }

                // arrayList에 추가
                items.add(TodoItem(todoTitle,todoDesc))
                adapter.notifyDataSetChanged()

                dialog.cancel()
            }

        }


    }


}
