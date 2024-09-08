package com.example.to_do_task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel :ViewModel(){
    private  val _taskList=MutableLiveData<MutableList<TaskModel>>()
    val taskList: LiveData<MutableList<TaskModel>> get() = _taskList
    init {
        _taskList.value= mutableListOf()
    }
    fun addTask(task: TaskModel) {
        val updatedList = _taskList.value ?: mutableListOf()
        updatedList.add(task)
        _taskList.value = updatedList
    }



}