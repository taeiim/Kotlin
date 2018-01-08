package com.example.parktaeim.beautifullogin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_login2.*

/**
 * Created by parktaeim on 2018. 1. 8..
 */
class LoginActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        val uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown)
        val downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup)
        val rotate = AnimationUtils.loadAnimation(this,R.anim.rotate)

        layout1.animation = uptodown
        layout2.animation = downtoup
        astroImg.animation = rotate
    }
}

