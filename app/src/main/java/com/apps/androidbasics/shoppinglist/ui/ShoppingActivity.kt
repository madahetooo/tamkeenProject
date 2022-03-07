package com.apps.androidbasics.shoppinglist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.androidbasics.R
import com.apps.androidbasics.adapters.ShoppingItemAdapter
import com.apps.androidbasics.shoppinglist.data.local.db.ShoppingDatabase
import com.apps.androidbasics.shoppinglist.data.local.db.entities.ShoppingItem
import com.apps.androidbasics.shoppinglist.data.local.db.repository.ShoppingRepository
import kotlinx.android.synthetic.main.activity_shopping.*
import java.security.acl.Owner

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingItemViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(ShoppingItemViewModel::class.java)

        val ShoppingItemAdapter = ShoppingItemAdapter(listOf(),viewModel)
        rvShoppingItem.layoutManager = LinearLayoutManager(this)
        rvShoppingItem.adapter = ShoppingItemAdapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            ShoppingItemAdapter.items = it
            ShoppingItemAdapter.notifyDataSetChanged()

        })

        fabAddShoppingItem.setOnClickListener {
            ShoppingItemDialog(this,object :AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
        
    }
}