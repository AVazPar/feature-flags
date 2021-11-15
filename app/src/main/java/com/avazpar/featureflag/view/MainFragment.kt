package com.avazpar.featureflag.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        initView()
    }

    private fun observeViewModel(){
        viewModel.creditScore.observe(viewLifecycleOwner, Observer {

        })
    }

    private fun initView(){
        viewModel.getCreditScore()
    }

}