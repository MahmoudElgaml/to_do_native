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
        binding = FragmentTaskListBinding.inflate(inflater,container,false)





        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myadapter = TaskAdapter(
            mutableListOf(),
            onDelete = {
                viewModel.deleteTask(it)
            },
            onUpdate = {
                findNavController().navigate(R.id.updateTaskFragment, Bundle().apply {
                    putSerializable("user", it)
                })
            },
        )
        binding.tasklist.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myadapter
        }
        binding.floatButton.setOnClickListener {
            findNavController().navigate(R.id.addTaskFragment)
        }

        viewModel.allTasks.observe(viewLifecycleOwner) {
            myadapter.updateList(it)


        }
    }

}