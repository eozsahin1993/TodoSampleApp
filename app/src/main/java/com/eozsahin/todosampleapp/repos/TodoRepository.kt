package com.eozsahin.todosampleapp.repos

import com.eozsahin.todosampleapp.api.TodoApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TodoRepository @Inject constructor(
    private val apiService: TodoApiService
) {
    suspend fun fetchTodos() = withContext(Dispatchers.IO) { apiService.getPosts() }
}