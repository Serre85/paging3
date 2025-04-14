package com.hslee.ui

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hslee.domain.model.Images
import com.hslee.domain.usecase.ImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: ImagesUseCase
) : ViewModel(), DefaultLifecycleObserver {

    private val _image = MutableStateFlow<Images.RS?>(null)
    val image: StateFlow<Images.RS?> = _image.asStateFlow()

    fun getImage(value: Int) {
        viewModelScope.launch {
            _image.value = useCase.image(Images.RQ(value)).body()
        }
    }
}