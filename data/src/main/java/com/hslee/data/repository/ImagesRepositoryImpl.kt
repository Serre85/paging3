package com.hslee.data.repository

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hslee.data.api.ApiService
import com.hslee.domain.Constants
import com.hslee.domain.model.Images
import com.hslee.domain.repository.ImagesRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class ImagesRepositoryImpl @Inject constructor(
    @ApplicationContext
    val applicationContext: Context,
    private val api: ApiService
) : ImagesRepository {
    override suspend fun images(rq: Images.RQ): Response<List<Images.RS>> {
        return api.images(rq.value, Constants.DEFAULT_LIMIT)
    }

    override suspend fun image(rq: Images.RQ): Response<Images.RS> {
        return api.image(rq.value)
    }

    override fun fetchImageList(): Flow<PagingData<Images.RS>> {
        return Pager(
            config = PagingConfig(Constants.DEFAULT_LIMIT, enablePlaceholders = false),
            pagingSourceFactory = { ImagesSource(api) }
        ).flow
    }
}