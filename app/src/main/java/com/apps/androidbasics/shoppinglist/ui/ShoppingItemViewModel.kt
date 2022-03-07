package com.apps.androidbasics.shoppinglist.ui

import androidx.lifecycle.ViewModel
import com.apps.androidbasics.shoppinglist.data.local.db.entities.ShoppingItem
import com.apps.androidbasics.shoppinglist.data.local.db.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingItemViewModel(private val repository: ShoppingRepository):ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItem()
}