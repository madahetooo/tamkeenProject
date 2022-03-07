package com.apps.androidbasics.shoppinglist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.androidbasics.shoppinglist.data.local.db.repository.ShoppingRepository

class ShoppingItemViewModelFactory(val repository: ShoppingRepository) :ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingItemViewModel(repository) as T
    }
}