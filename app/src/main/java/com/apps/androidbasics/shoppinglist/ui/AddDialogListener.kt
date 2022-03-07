package com.apps.androidbasics.shoppinglist.ui

import com.apps.androidbasics.shoppinglist.data.local.db.entities.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item:ShoppingItem)
}