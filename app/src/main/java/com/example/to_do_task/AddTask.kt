package com.example.to_do_task

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.to_do_task.databinding.FragmentAddTaskBinding
import com.example.to_do_task.databinding.FragmentTaskListBinding
import java.util.Calendar


class AddTaskFragment : Fragment() {

lateinit var  binding:FragmentAddTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentAddTaskBinding.inflate(layoutInflater)

        binding.dateEditText.setOnClickListener{
            showDatePicker()
        }
        // Inflate the layout for this fragment
        return binding.root
    }
    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Create DatePickerDialog and show it
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                // Set the selected date to the TextView
                val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                binding.dateEditText.hint =formattedDate
            },
            year, month, day
        )
        datePickerDialog.show()
    }


}