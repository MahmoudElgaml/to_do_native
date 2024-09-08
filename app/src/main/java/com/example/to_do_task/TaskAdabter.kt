package com.example.myapplication3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.to_do_task.TaskModel
import com.example.to_do_task.databinding.CardTaskBinding

class TaskAdapter(private val taskList: List<TaskModel>) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    // ViewHolder class using ViewBinding
    class TaskViewHolder(val binding: CardTaskBinding) : RecyclerView.ViewHolder(binding.root)

    // Inflate the item layout using ViewBinding and return a ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = CardTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    // Bind the data to the views for each item in the list
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentTask = taskList[position]
        holder.binding.apply {
            taskTitle.text = currentTask.title
            taskDescription.text = currentTask.description
            taskDate.text = currentTask.date
        }
    }

    // Return the total number of items in the list
    override fun getItemCount(): Int {
        return taskList.size
    }
}
