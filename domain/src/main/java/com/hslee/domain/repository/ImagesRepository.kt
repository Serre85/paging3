package com.hslee.domain.repository

import androidx.paging.PagingData
import com.hslee.domain.model.Images
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ImagesRepository {
    suspend fun images(rq: Images.RQ): Response<List<Images.RS>>

    suspend fun image(rq: Images.RQ): Response<Images.RS>

    fun fetchImageList(): Flow<PagingData<Images.RS>>
}