package com.example.to_do_task

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.TaskDao
import com.example.task.TaskDatabase
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application){
  private  val taskDao:TaskDao
    init {
         taskDao=TaskDatabase.getDatabase(application).taskDao()
    }
    val allTasks: LiveData<MutableList<TaskModel>> = taskDao.getAllTasks()

     fun insertTask(task: TaskModel)= viewModelScope.launch{
        taskDao.insert(task)
    }

     fun updateTask(task: TaskModel) =viewModelScope.launch{
        taskDao.update(task)
    }

     fun deleteTask(task: TaskModel)=viewModelScope.launch {
        taskDao.delete(task)
    }



}