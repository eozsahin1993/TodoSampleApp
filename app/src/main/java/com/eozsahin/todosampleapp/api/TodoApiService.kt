package com.eozsahin.todosampleapp.api

import retrofit2.http.GET

interface TodoApiService {

    @GET("/todos")
    suspend fun getPosts(): List<Todo>
}