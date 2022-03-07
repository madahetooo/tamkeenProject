package com.apps.androidbasics.shoppinglist.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.apps.androidbasics.R
import com.apps.androidbasics.shoppinglist.data.local.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class ShoppingItemDialog(context:Context, var addDialogListener: AddDialogListener) :AppCompatDialog(context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAddShoppingItemAdd.setOnClickListener {
          val itemName =  etAddShoppingItemName.text.toString()
          val itemAmount =  etAddShoppingItemAmount.text.toString()

            if(itemName.isEmpty() || itemAmount.isEmpty()){
                Toast.makeText(context,"Please fill the required data",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            var item = ShoppingItem(itemName,itemAmount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()

        }
        tvAddShoppingItemCancel.setOnClickListener {
            cancel()
        }


    }

}