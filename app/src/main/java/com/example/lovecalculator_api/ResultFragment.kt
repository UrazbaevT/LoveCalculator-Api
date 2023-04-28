package com.example.lovecalculator_api

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator_api.databinding.FragmentResultBinding
import com.example.lovecalculator_api.remote.LoveModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            val result = arguments?.getSerializable("result") as LoveModel
            etYou.text = result.firstName
            etMe.text = result.secondName
            tvPercentage.text = result.percentage + "%"
            tvResult.text = result.result

            btnTryAgain.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }


}