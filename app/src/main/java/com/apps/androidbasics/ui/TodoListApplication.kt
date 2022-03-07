package com.apps.androidbasics.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.androidbasics.R
import com.apps.androidbasics.data.Todo
import com.apps.androidbasics.adapters.TodoAdapter
import kotlinx.android.synthetic.main.activity_todo_list_application.*

class TodoListApplication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list_application)

        val listOfTodos = mutableListOf(
            Todo("Visit Doctor",false),
            Todo("Buy Pizza",false),
            Todo("Study Flutter",false),
            Todo("Study Android",false),
            Todo("Firebase",false),
            Todo("call my father",false),
            Todo("Tide my room",false),
            Todo("Pray and go to the gym",false),
            Todo("study ML",false),
        )


        val adapter = TodoAdapter(listOfTodos)
        rvTodos.layoutManager = LinearLayoutManager(this)
        rvTodos.adapter = adapter

        btnAddTodo.setOnClickListener {
            val newTodo = etAddTodo.text.toString()
            val addNewTodo = Todo(newTodo,false)
            listOfTodos.add(addNewTodo)
            adapter.notifyDataSetChanged()
            etAddTodo.text.clear()
        }

    }
}