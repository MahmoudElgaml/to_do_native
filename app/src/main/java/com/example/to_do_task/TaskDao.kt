package com.example.task

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.to_do_task.TaskModel

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: TaskModel)

    @Update
    suspend fun update(task: TaskModel)

    @Delete
    suspend fun delete(task: TaskModel)

    @Query("SELECT * FROM task_table ORDER BY id ASC")
    fun getAllTasks(): LiveData<List<TaskModel>>
}