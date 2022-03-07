package com.apps.androidbasics.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apps.androidbasics.R
import kotlinx.android.synthetic.main.activity_login.*

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {
    var pressTwiceToExit: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        //CREATE SHARED PREFRENCES FILE
        val sharedPreferencesFile = getSharedPreferences("LoginDataFile", MODE_PRIVATE)
        val editor = sharedPreferencesFile.edit()

        //GET DATA FROM THE FILE
        val myUserName = sharedPreferencesFile.getString("userName", null)
        val myPassword = sharedPreferencesFile.getString("password", null)
        val myCbRememberMeState = sharedPreferencesFile.getBoolean("rememberMe", false)

        //SET DATA TO THE VIEW
        etUserName.setText(myUserName)
        etPassword.setText(myPassword)
        cbRememberMe.isChecked = myCbRememberMeState
        cbRememberMe.setOnClickListener {
            //GET DATA FROM THE VIEW
            val userName = etUserName.text.toString()
            val password = etPassword.text.toString()
            val cbRememberMeState = cbRememberMe.isChecked

            //SAVE THE DATA TO THE FILE
            editor.putString("userName", userName)
            editor.putString("password", password)
            editor.putBoolean("rememberMe", cbRememberMeState)
                .apply()

        }

        btnLogin.setOnClickListener {
            val userName = etUserName.text.toString()
            val password = etPassword.text.toString()

            if(userName.isEmpty() && password.isNotEmpty()){
                etUserName.setError("Please enter username")
            }
            else if (userName.isNotEmpty() && password.isEmpty()){
                etPassword.setError("Please enter password")
            }
            else if (userName.isEmpty()&& password.isEmpty()){
                etUserName.setError("Please enter username")
                etPassword.setError("Please enter password")
                Toast.makeText(this,"Please enter the required data",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,"Welcome back",Toast.LENGTH_SHORT).show()
            }


        }
        tvRegister.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

    }


    override fun onBackPressed() {
        if (pressTwiceToExit) { // if value is  = true
            finish()
            super.onBackPressed()
        }
        //current value = false
        pressTwiceToExit = true // current value = true
        Toast.makeText(this, "Press again quickly to exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({
            pressTwiceToExit = false
        }, 3000L)


    }
}
