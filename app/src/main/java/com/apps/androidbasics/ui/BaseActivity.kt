package com.apps.androidbasics.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.apps.androidbasics.*
import com.apps.androidbasics.fragments.FragmentHome
import com.apps.androidbasics.fragments.FragmentProfile
import com.apps.androidbasics.fragments.FragmentSettings
import com.apps.androidbasics.fragments.FragmentTodo
import kotlinx.android.synthetic.main.activity_base.*

@Suppress("DEPRECATION")
class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setCurrentFragment(FragmentHome()) // base fragment will be run as first fragment
        val fragmentHome = FragmentHome()
        val fragmentTodo = FragmentTodo()
        val fragmentProfile = FragmentProfile()
        val fragmentSettings = FragmentSettings()

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miHome -> setCurrentFragment(fragmentHome)
                R.id.miTodo -> setCurrentFragment(fragmentTodo)
                R.id.miProfile -> setCurrentFragment(fragmentProfile)
                R.id.miSettings -> setCurrentFragment(fragmentSettings)

            }
            true

        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
                .commit()
        }
    }
}