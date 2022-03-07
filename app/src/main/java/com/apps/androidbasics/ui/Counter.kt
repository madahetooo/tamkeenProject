package com.apps.androidbasics.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.androidbasics.R
import kotlinx.android.synthetic.main.activity_counter.*

class Counter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        var count =0
        btnCounter.setOnClickListener {
            count++
            tvCounter.text = "Lets Count together $count"
        }
    }
}