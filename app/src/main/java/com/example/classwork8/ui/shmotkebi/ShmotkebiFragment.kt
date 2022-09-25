package com.example.classwork8.ui.shmotkebi

import android.util.Log.d
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.classwork8.databinding.FragmentShmotkebiBinding
import com.example.classwork8.ui.adapter.ShmotkebiAdapter
import com.example.classwork8.ui.basefragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ShmotkebiFragment :
    BaseFragment<FragmentShmotkebiBinding>(FragmentShmotkebiBinding::inflate) {
    private val adapter by lazy {
        ShmotkebiAdapter()
    }
    private val viewModel: ShmotkebiViewModel by viewModels()
    override fun init() {
        bindRecycler()
        lifecycleScope.launch {
            viewModel.getShmotkebi()
        }
    }

    private fun bindRecycler() {
        binding.items.adapter = adapter
        binding.items.layoutManager = GridLayoutManager(context, 2)
    }

    override fun observe() {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.flow.collect { state ->
                    state.error?.let {
                        d("errror", it)
                    }

                    state.data?.let {
                        adapter.submitList(it)
                    }
                }
            }
        }
    }
}