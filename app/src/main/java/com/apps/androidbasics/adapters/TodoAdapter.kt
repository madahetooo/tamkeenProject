package com.apps.androidbasics.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.androidbasics.R
import com.apps.androidbasics.data.Todo
import kotlinx.android.synthetic.main.todo_item.view.*

class TodoAdapter(var todos:List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item,parent,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.tvTodoName.text = todos[position].name
        holder.itemView.cbTodoDone.isChecked = todos[position].isChecked

    }

    override fun getItemCount(): Int {
        return todos.size
    }
}