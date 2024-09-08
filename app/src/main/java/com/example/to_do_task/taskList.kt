package com.example.to_do_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication3.TaskAdapter
import com.example.to_do_task.databinding.FragmentTaskListBinding


class taskList : Fragment() {

    lateinit var binding: FragmentTaskListBinding
    val viewModel: TaskViewModel by activityViewModels()
    lateinit var myadapter: TaskAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskListBinding.inflate(layoutInflater)

        val taskList = mutableListOf(
            TaskModel("Task 1", "Description for Task 1", "01/09/2024"),
            TaskModel("Task 2", "Description for Task 2", "02/09/2024"),
            TaskModel("Task 3", "Description for Task 3", "03/09/2024")
        )
        myadapter = TaskAdapter(mutableListOf())
        binding.tasklist.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myadapter
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatButton.setOnClickListener {
            findNavController().navigate(R.id.addTaskFragment)
        }

        viewModel.taskList.observe(viewLifecycleOwner) {
            myadapter.updateList(it)

        }
    }

}