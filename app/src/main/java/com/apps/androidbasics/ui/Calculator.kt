package com.apps.androidbasics.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apps.androidbasics.R
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        btnPlus.setOnClickListener {
            var firstNumber:Int = etFirstNumber.text.toString().toInt()
            var secondNumber:Int = etSecondNumber.text.toString().toInt()
            var result = addition(firstNumber , secondNumber)
            tvResult.text = "Result is : $result"
        }

        btnSubtract.setOnClickListener {
            var firstNumber:Int = etFirstNumber.text.toString().toInt()
            var secondNumber:Int = etSecondNumber.text.toString().toInt()
            var result = subtract(firstNumber , secondNumber)
            tvResult.text = "Result is : $result"
        }

        btnMultiply.setOnClickListener {
            var firstNumber:Int = etFirstNumber.text.toString().toInt()
            var secondNumber:Int = etSecondNumber.text.toString().toInt()
            var result = multiply(firstNumber , secondNumber)
            tvResult.text = "Result is : $result"
        }

        btnDivision.setOnClickListener {
            var firstNumber:Int = etFirstNumber.text.toString().toInt()
            var secondNumber:Int = etSecondNumber.text.toString().toInt()
            var result = division(firstNumber , secondNumber)
            tvResult.text = "Result is : $result"
        }
    }

    fun addition ( num1:Int,  num2:Int):Int{
        return  num1 + num2
    }
    fun subtract( num1:Int,  num2:Int):Int{
        return  num1 - num2
    }
    fun multiply ( num1:Int,  num2:Int):Int{
        return  num1 * num2
    }
    fun division ( num1:Int,  num2:Int):Int{
        return  num1 / num2
    }
}