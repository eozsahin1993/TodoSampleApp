package com.eozsahin.todosampleapp.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    @SerialName("id") val id: Long,
    @SerialName("userId") val userId: Long,
    @SerialName("title") val title: String,
    @SerialName("completed") val completed: Boolean,
)
