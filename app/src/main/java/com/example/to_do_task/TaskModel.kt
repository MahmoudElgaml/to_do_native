package com.example.to_do_task

import java.io.Serializable
import java.util.UUID

data class TaskModel(
    val id: String = UUID.randomUUID().toString(),  // Auto-generate a unique ID
    val title: String,
    val description: String,
    val date: String
) : Serializable
