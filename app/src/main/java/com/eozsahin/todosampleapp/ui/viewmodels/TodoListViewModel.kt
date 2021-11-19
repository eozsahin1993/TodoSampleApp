package com.eozsahin.todosampleapp.ui.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eozsahin.todosampleapp.repos.TodoRepository
import com.eozsahin.todosampleapp.ui.models.TodoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    todoRepository: TodoRepository
): ViewModel() {
    var todos = mutableStateListOf<TodoModel>()

    init {
        viewModelScope.launch {
            val fetchedTodos = todoRepository.fetchTodos()
                .map { TodoModel(it.title, it.completed) }
            todos.addAll(fetchedTodos)
        }
    }
}