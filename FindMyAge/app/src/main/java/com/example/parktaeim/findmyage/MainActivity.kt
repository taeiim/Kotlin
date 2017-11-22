package com.example.parktaeim.findmyage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findAgeBtn.setOnClickListener {
            val yearOfBirth : Int = birthEditText.text.toString().toInt()
            val currentYear = Calendar.getInstance().get((Calendar.YEAR))
            val age : Int = (currentYear+1) - yearOfBirth;
            ageTextView.text = "당신의 나이는 $age 살 입니다. "
        }
    }
}6
