package com.example.parktaeim.tictactoe_game

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.timerTask

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

//        Toast.makeText(this,"ID: "+cellID, Toast.LENGTH_SHORT).show();

        playGame(cellID, btnSelected);
    }

    var player1 = ArrayList<Int>();
    var player2 = ArrayList<Int>();
    var activePlayer = 1
    var num :Int = 0

    fun playGame(cellID:Int,btnSelected:Button){
        if (activePlayer == 1){
            btnSelected.text = "O"
            btnSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            activePlayer = 2
            num++

            val timer = Timer()
            timer.schedule(timerTask { println("timer 1000") }, 1000)
            autoPlay()
        } else if (activePlayer ==2){
            btnSelected.text = "X"
            btnSelected.setBackgroundColor(Color.BLUE)
            player2.add(cellID)
            activePlayer = 1
            num++
        }

        btnSelected.isEnabled = false
        checkWinner(num)
    }

    fun checkWinner(num:Int){
        var winner=-1

        // row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }


        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
        }




        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
        }



        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
        }



        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }


        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }

        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
        }

        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
        }

        var res = 0

        if( winner != -1){
            if (winner==1){
                res = 1
                setDialog(res)
                Toast.makeText(this," Player 1  win the game", Toast.LENGTH_LONG).show()
            }else{
                res = 2
                setDialog(res)
                Toast.makeText(this," Player 2  win the game", Toast.LENGTH_LONG).show()

            }
        } else if(num==9 && winner==-1){
            res = 3
            setDialog(res)
            Toast.makeText(this,"무승부!!", Toast.LENGTH_LONG).show()
        }
    }

    fun setDialog(res:Int){
        var dialogBuilder = AlertDialog.Builder(this@MainActivity)
        dialogBuilder.setTitle("게임 종료")

        if(res == 1){
            dialogBuilder.setMessage("플레이어 1 게임 승리!")
        } else if(res == 2){
            dialogBuilder.setMessage("플레이어 2 게임 승리!")
        } else if(res == 3){
            dialogBuilder.setMessage("무승부!")
        }

        dialogBuilder.setPositiveButton("확인"){
            dialogInterface, i -> Log.d("onclick","oh!!")
        }
        dialogBuilder.create().show()

    }


    fun autoPlay(){

//        Thread.sleep(1000)

        var emptyCells=ArrayList<Int>()
        for ( cellID in 1..9){

            if(!( player1.contains(cellID) || player2.contains(cellID))) {
                emptyCells.add(cellID)
            }
        }


        val r= Random()
        val randIndex=r.nextInt(emptyCells.size-0)+0
        val cellID= emptyCells[randIndex]


        var btnSelected:Button?
        when(cellID){
            1-> btnSelected=btn1
            2-> btnSelected=btn2
            3-> btnSelected=btn3
            4-> btnSelected=btn4
            5-> btnSelected=btn5
            6-> btnSelected=btn6
            7-> btnSelected=btn7
            8-> btnSelected=btn8
            9-> btnSelected=btn9   
            else->{
                btnSelected=btn1
            }
        }

        playGame(cellID,btnSelected)

    }
}
