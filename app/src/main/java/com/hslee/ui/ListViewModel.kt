package com.hslee.ui

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hslee.adapter.ImageAdapter
import com.hslee.adapter.OnItemClickListener
import com.hslee.domain.usecase.ImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListViewModel @Inject constructor(
    private val useCase: ImagesUseCase
) : ViewModel(), DefaultLifecycleObserver {
    val adapter = ImageAdapter()

    init {
        viewModelScope.launch {
            useCase.fetchImageList().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    fun setAdapter(listener: OnItemClickListener) {
        adapter.listener = listener
    }
}