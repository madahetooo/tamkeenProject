package com.apps.androidbasics.shoppinglist.data.local.db.repository

import com.apps.androidbasics.shoppinglist.data.local.db.ShoppingDatabase
import com.apps.androidbasics.shoppinglist.data.local.db.entities.ShoppingItem

class ShoppingRepository(private  val db:ShoppingDatabase) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItem() = db.getShoppingDao().getAllShoppingItems()

}