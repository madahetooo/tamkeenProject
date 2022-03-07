package com.apps.androidbasics.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apps.androidbasics.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnUploadData.setOnClickListener {
            val username = etUserName.text.toString()
            val birthDate = etBirthDate.text.toString()
            val country = etCountry.text.toString()
            val password = etPassword.text.toString()
            Toast.makeText(
                this,
                "Your name is $username " +
                        "and you born at $birthDate " +
                        "in $country " +
                        "and your password is $password",Toast.LENGTH_LONG).show()

        }
    }
}