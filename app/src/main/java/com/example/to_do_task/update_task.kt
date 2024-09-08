package com.example.to_do_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.to_do_task.databinding.FragmentUpdateTaskBinding


class UpdateTaskFragment : Fragment() {

lateinit var binding: FragmentUpdateTaskBinding
lateinit var task:TaskModel
val viewModel:TaskViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentUpdateTaskBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getSerializable("user")?.let {
            task = it as TaskModel
            populateFields(task)
        }
        binding.saveTaskButton.setOnClickListener{
            val updateTask=task.copy(
                title = binding.titleEditText.text.toString(),
                description = binding.descriptionEditText.text.toString(),
                date = binding.dateEditText.text.toString(),
            )
            viewModel.updateTask(updateTask)
            findNavController().popBackStack()
        }
        binding.deleteTaskButton.setOnClickListener{
            viewModel.deleteTask(task)
            findNavController().popBackStack()
        }
    }
    private fun populateFields(task: TaskModel) {
        binding.titleInputLayout.editText?.setText(task.title)
        binding.descriptionEditText.setText(task.description)
        binding.dateEditText.setText(task.date)
    }



}