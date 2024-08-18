package com.dwa.mycar.common.di

import android.content.Context
import com.dwa.mycar.common.reader.DataReader
import com.dwa.mycar.common.reader.DataReaderImpl
import com.dwa.mycar.data.database.CarProfileDao
import com.dwa.mycar.data.mapper.CarProfileMapper
import com.dwa.mycar.data.repo.CarProfileRepoImpl
import com.dwa.mycar.domain.repo.CarProfileRepo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped

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

    @Provides
    fun provideJsonReader(
        @ApplicationContext context: Context,
        gson: Gson
    ): DataReader = DataReaderImpl(context, gson)


}