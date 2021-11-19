package com.eozsahin.todosampleapp.repos

import com.eozsahin.todosampleapp.api.Todo
import com.eozsahin.todosampleapp.api.TodoApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

class TodoRepository @Inject constructor(
    private val apiService: TodoApiService,
    private val localSaved: LocalCache
) {
    suspend fun getTodos() = localSaved.cache + withContext(Dispatchers.IO) { apiService.getPosts() }

    fun saveTodo(todo: Todo) {
        localSaved.cache.add(0, todo)
    }
}

// Usually this would be a data source, but keeping it here for demo purposes.
@Singleton
class LocalCache @Inject constructor() {
    var cache: MutableList<Todo> = mutableListOf()
}