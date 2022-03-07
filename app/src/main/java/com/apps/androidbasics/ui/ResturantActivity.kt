package com.apps.androidbasics.ui

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.apps.androidbasics.R
import kotlinx.android.synthetic.main.activity_resturant.*

class ResturantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resturant)


        btnOrder.setOnClickListener {
            val checkedRadioButton = rgKindsOfBurgers.checkedRadioButtonId
            val kindOfBurger = findViewById<RadioButton>(checkedRadioButton)
            val salad = cbSalad.isChecked
            val onion = cbOnions.isChecked
            val mionez = cbMionez.isChecked
            if(kindOfBurger !=null){
                val totalOrder = "You ordered a ${kindOfBurger.text} with " +
                        (if (salad) "\nSalad" else "")+
                        (if (onion) "\nOnions" else "")+
                        (if (mionez) "\nMioneez" else "")

                tvOrder.text = totalOrder
            }

        }



    }
}