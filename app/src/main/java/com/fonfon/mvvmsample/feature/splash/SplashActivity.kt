package com.fonfon.mvvmsample.feature.splash

import android.content.Intent
import android.os.Bundle
import com.fonfon.mvvmsample.feature.main.MainActivity
import dagger.android.support.DaggerAppCompatActivity

class SplashActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
    }

}