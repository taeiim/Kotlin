package com.example.parktaeim.beautifullogin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener{
            val intent = Intent(this,LoginActivity1::class.java)
            startActivity(intent)
        }

        btn2.setOnClickListener{
            val intent2 = Intent(this,LoginActivity2::class.java)
            startActivity(intent2)
        }
    }
}
