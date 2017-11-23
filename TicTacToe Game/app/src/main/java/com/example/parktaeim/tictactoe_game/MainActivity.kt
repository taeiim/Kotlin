package com.example.parktaeim.tictactoe_game

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun btnClick(view: View){
        val btnSelected = view as Button
        var cellID = 0
        when(btnSelected.id){
            R.id.btn1 -> cellID=1
            R.id.btn2 -> cellID=2
            R.id.btn3 -> cellID=3
            R.id.btn4 -> cellID=4
            R.id.btn5 -> cellID=5
            R.id.btn6 -> cellID=6
            R.id.btn7 -> cellID=7
            R.id.btn8 -> cellID=8
            R.id.btn9 -> cellID=9

        }

        Toast.makeText(this,"ID: "+cellID, Toast.LENGTH_SHORT).show();
    }
}
