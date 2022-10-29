package com.hslee.data.di

import android.content.Context
import com.hslee.data.api.ApiService
import com.hslee.data.repository.ImagesRepositoryImpl
import com.hslee.domain.repository.ImagesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providePicsumRepository(
        @ApplicationContext context: Context,
        picsum: ApiService,
    ): ImagesRepository {
        return ImagesRepositoryImpl(context, picsum)
    }
}