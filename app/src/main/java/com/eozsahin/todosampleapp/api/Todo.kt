package com.eozsahin.todosampleapp.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    @SerialName("id") val id: Long = 0,
    @SerialName("userId") val userId: Long = 0,
    @SerialName("title") val title: String,
    @SerialName("completed") val completed: Boolean = false,
)
