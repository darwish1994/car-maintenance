package com.dwa.mycar.common.di

import android.content.Context
import androidx.room.Room
import com.dwa.mycar.app.AppDatabase
import com.dwa.mycar.common.dispatcher.DispatcherProvider
import com.dwa.mycar.common.dispatcher.StanderDispatcherProvider
import com.dwa.mycar.data.database.CarProfileDao
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provedGson(): Gson = Gson()


    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "myCar_db"
        ).fallbackToDestructiveMigration()
            .build()


    @Provides
    @Singleton
    fun provideCarProfileDao(db: AppDatabase): CarProfileDao = db.carProfileDao()


    @Provides
    fun provideDispatcher(): DispatcherProvider = StanderDispatcherProvider

}