package com.apps.androidbasics.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.apps.androidbasics.R
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class CoroutinesExamples : AppCompatActivity() {
    val TAG = "CoroutinesExamples"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_examples)

        GlobalScope.launch(Dispatchers.IO) {

            val time = measureTimeMillis {
                var answer1 = async { doNetworkCall1() }
                var answer2 = async { doNetworkCall2() }
                Log.d(TAG,"Answer1 is : ${answer1.await()}")
                Log.d(TAG,"Answer2 is : ${answer2.await()}")
            }
            Log.d(TAG,"Request takes : $time .ms")

        }
    }

    suspend fun doNetworkCall1(): String {
        delay(4000L)
        return "Answer 1"
    }

    suspend fun doNetworkCall2(): String {
        delay(4000L)
        return "Answer 2"
    }
}