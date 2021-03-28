package com.khadija.nyarticles.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.khadija.nyarticles.MainActivity
import com.khadija.nyarticles.R
import com.khadija.nyarticles.ViewModelFactory
import com.khadija.nyarticles.databinding.HomeFragmentBinding
import com.khadija.nyarticles.ui.ResultsAdapter
import javax.inject.Inject

class HomeFragment:Fragment() {

    private lateinit var binding: HomeFragmentBinding
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    // inject home view model
    lateinit var viewModel: HomeViewModel
    lateinit var resultsAdapter: ResultsAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).mainComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        binding.lifecycleOwner = this

        resultsAdapter= ResultsAdapter(viewModel)
        binding.resultsRv.adapter=resultsAdapter

        viewModel.getArticles()
        viewModel.articlesList.observe(viewLifecycleOwner, Observer {

            if (it.isNotEmpty()){

                resultsAdapter.submitList(it)

            }
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            }else{
                binding.progressBar.visibility = View.GONE

            }
        })
        viewModel.message.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context,it, Toast.LENGTH_LONG).show()
        })

        viewModel.navTo.observe(viewLifecycleOwner, Observer {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToArticleViewFragment(it))
        })

        return binding.root
    }
}