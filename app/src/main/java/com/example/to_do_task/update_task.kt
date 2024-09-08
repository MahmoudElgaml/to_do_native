package com.example.to_do_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.to_do_task.databinding.FragmentUpdateTaskBinding


class UpdateTaskFragment : Fragment() {

lateinit var binding: FragmentUpdateTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentUpdateTaskBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }


}