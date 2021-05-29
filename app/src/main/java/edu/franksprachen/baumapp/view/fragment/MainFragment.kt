package edu.franksprachen.baumapp.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import edu.franksprachen.baumapp.R
import edu.franksprachen.baumapp.intent.Intent
import edu.franksprachen.baumapp.util.AdapterTrees
import edu.franksprachen.baumapp.util.DataState
import edu.franksprachen.baumapp.view.MainViewModel
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment constructor(
): Fragment(R.layout.fragment_first) {
    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var treesAdapter: AdapterTrees

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        val layoutManager = LinearLayoutManager(
            requireActivity().applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        recyclerViewCats.layoutManager = layoutManager
        recyclerViewCats.adapter = treesAdapter
        subscribeObservers()
        lifecycleScope.launch {
            viewModel.userIntent.send(Intent.GetTreeEvent)
        }
    }

    private fun subscribeObservers() {
        lifecycleScope.launch {
            viewModel.dataState.collect {
                when(it) {
                    is DataState.Success -> {
                        displayProgressBar(false)
                        treesAdapter.setTrees(it.trees)
                    }
                    is DataState.Error -> {
                        displayProgressBar(false)
                        displayError(it.exception.message)
                    }
                    is DataState.Loading -> {
                        displayProgressBar(true)
                    }
                }
            }
        }
    }

    private fun displayError(message: String?) {
        if (message != null) textDemo.text = message else textDemo.text = "Unknown error."
    }


    private fun displayProgressBar(isDisplayed: Boolean) {
        progress_bar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }
}