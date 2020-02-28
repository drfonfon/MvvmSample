package com.fonfon.mvvmsample.feature.main

import android.os.Bundle
import com.fonfon.mvvmsample.R
import com.fonfon.mvvmsample.feature.feed.FeedFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, FeedFragment())
            .commitAllowingStateLoss()

    }
}
