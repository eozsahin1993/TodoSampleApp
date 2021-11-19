package com.eozsahin.todosampleapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eozsahin.todosampleapp.api.Todo
import com.eozsahin.todosampleapp.repos.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository
): ViewModel() {
    fun addTodo(text: String) {
        viewModelScope.launch {
            todoRepository.saveTodo(Todo(title = text))
        }
    }
}