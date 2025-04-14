package com.hslee.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hslee.domain.model.Images
import com.hslee.domain.usecase.ImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val useCase: ImagesUseCase
) : ViewModel() {
    val images: Flow<PagingData<Images.RS>> = useCase.fetchImageList()
        .cachedIn(viewModelScope)
}