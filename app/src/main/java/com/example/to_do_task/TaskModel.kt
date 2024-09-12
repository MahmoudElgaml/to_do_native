package com.example.to_do_task

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.UUID
@Entity(tableName = "task_table")
data class TaskModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,// Auto-generate a unique ID
    val title: String,
    val description: String,
    val date: String
) : Serializable
