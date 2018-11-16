package com.example.mrrexz.mytaxiandroid.ui.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mrrexz.mytaxiandroid.R
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}