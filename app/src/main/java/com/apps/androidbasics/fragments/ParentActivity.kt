package com.apps.androidbasics.fragments

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.apps.androidbasics.R
import kotlinx.android.synthetic.main.activity_parent.*

@Suppress("DEPRECATION")
class ParentActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)
        setCurrentFragment(FragmentInbox())
        var toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        parentNavigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miInbox -> {
                    val inboxFragment = FragmentInbox()
                    setCurrentFragment(inboxFragment)
                    drawerLayout.close()
                }
                R.id.miStarred -> {
                    val starredFragment = FragmentStarred()
                    setCurrentFragment(starredFragment)
                    drawerLayout.close()

                }
                R.id.miSent -> {
                    val sendFragment = FragmentSent()
                    setCurrentFragment(sendFragment)
                    drawerLayout.close()

                }
                R.id.miArchive -> {
                    val archiveFragment = FragmentArchive()
                    setCurrentFragment(archiveFragment)
                    drawerLayout.close()

                }

            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.clContainer, fragment)
                .commit()
        }
    }
}