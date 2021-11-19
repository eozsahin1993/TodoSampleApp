package com.eozsahin.todosampleapp.ui.models

import com.eozsahin.todosampleapp.ui.components.TodoListRowModel

data class TodoModel(
    val title: String = "",
    val isCompleted: Boolean = true
)

fun TodoModel.toTodoListRowModel(): TodoListRowModel {
    return TodoListRowModel(this.title, this.isCompleted)
}
