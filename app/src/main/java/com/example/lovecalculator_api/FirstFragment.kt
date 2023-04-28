package com.example.lovecalculator_api

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator_api.databinding.FragmentFirstBinding
import com.example.lovecalculator_api.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var utils: Utils

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveLove(
                    firstName = firstEt.text.toString(),
                    secondName = secondEt.text.toString()
                ).observe(viewLifecycleOwner,
                    Observer {
                        Log.d("ololo", "initListener: $it")
                        findNavController().navigate(
                            R.id.resultFragment, bundleOf(
                                "result" to it
                            )
                        )
                    })
                utils.showToast(requireContext())
            }
        }
    }
}