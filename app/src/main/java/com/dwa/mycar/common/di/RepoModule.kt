package com.dwa.mycar.common.di

import com.dwa.mycar.data.database.CarProfileDao
import com.dwa.mycar.data.mapper.CarProfileMapper
import com.dwa.mycar.data.repo.CarProfileRepoImpl
import com.dwa.mycar.domain.repo.CarProfileRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepoModule {

    @Provides
    fun provideProfileCarRepo(
        profileDao: CarProfileDao,
        mapper: CarProfileMapper
    ): CarProfileRepo =
        CarProfileRepoImpl(
            profileDao = profileDao,
            mapper = mapper
        )


}