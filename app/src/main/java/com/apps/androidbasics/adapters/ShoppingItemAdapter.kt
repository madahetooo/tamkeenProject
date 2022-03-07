package com.apps.androidbasics.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.androidbasics.R
import com.apps.androidbasics.shoppinglist.data.local.db.entities.ShoppingItem
import com.apps.androidbasics.shoppinglist.ui.ShoppingItemViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingItemViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingItemViewHolder>() {
    inner class ShoppingItemViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {

        var currentShoppingItem = items[position]
        holder.itemView.tvShoppingItemName.text = currentShoppingItem.name
        holder.itemView.tvShoppingItemAmount.text = "${currentShoppingItem.amount}"
        holder.itemView.ivShoppingItemDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }
        holder.itemView.ivShoppingItemAdd.setOnClickListener {
        currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)

        }
        holder.itemView.ivShoppingItemMinus.setOnClickListener {

            if (currentShoppingItem.amount > 0){
                currentShoppingItem.amount--
                viewModel.upsert(currentShoppingItem)
            }

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}