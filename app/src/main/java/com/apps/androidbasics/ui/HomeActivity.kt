package com.apps.androidbasics.ui

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.apps.androidbasics.fragments.ParentActivity
import com.apps.androidbasics.R
import com.apps.androidbasics.utils.BroadcastRecevierExample
import com.apps.androidbasics.utils.NotificationExampleApp
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btnProfile.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnImageViewExample.setOnClickListener {
            val intent = Intent(this, ImageViewExample::class.java)
            startActivity(intent)
        }
        btnCounter.setOnClickListener {
            val intent = Intent(this, Counter::class.java)
            startActivity(intent)
        }
        btnCalculator.setOnClickListener {
            val intent = Intent(this, Calculator::class.java)
            startActivity(intent)
        }
        btnRestaurantApp.setOnClickListener {
            val intent = Intent(this, ResturantActivity::class.java)
            startActivity(intent)
        }
        btnBaseActivity.setOnClickListener {
            val intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
        }
        btnNavigationDrawer.setOnClickListener {
            val intent = Intent(this, ParentActivity::class.java)
            startActivity(intent)
        }
        btnTodoListApplication.setOnClickListener {
            val intent = Intent(this, TodoListApplication::class.java)
            startActivity(intent)
        }
        btnBroadCastReceiver.setOnClickListener {
            val intent = Intent(this, BroadcastRecevierExample::class.java)
            startActivity(intent)
        }
        btnShowNotificationApp.setOnClickListener {
            val intent = Intent(this, NotificationExampleApp::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_items,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miProfile -> Toast.makeText(this,"This is my profile tab",Toast.LENGTH_SHORT).show()
            R.id.miSettings -> Toast.makeText(this,"This is my settings tab",Toast.LENGTH_SHORT).show()
            R.id.miLogOut ->{
                val exitAlertDialog = AlertDialog.Builder(this)
                    .setTitle("Exit")
                    .setMessage("Do You want to exit ?!")
                    .setIcon(R.drawable.ic_exit_foreground)
                    .setCancelable(false)
                    .setPositiveButton("Yes"){ dialogInterface: DialogInterface, i:Int->
                        finish()
                    }
                    .setNegativeButton("No"){ dialogInterface: DialogInterface, i:Int->
                        dialogInterface.cancel()
                    }.create()
                exitAlertDialog.show()
            }
        }
        return true
    }
}