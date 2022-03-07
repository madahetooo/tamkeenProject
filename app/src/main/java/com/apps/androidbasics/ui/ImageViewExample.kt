package com.apps.androidbasics.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.androidbasics.R
import kotlinx.android.synthetic.main.activity_image_view_example.*

class ImageViewExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view_example)
        btnSetImage.setOnClickListener {
            ivImageExample.setImageResource(R.drawable.image_example)
        }
    }
}