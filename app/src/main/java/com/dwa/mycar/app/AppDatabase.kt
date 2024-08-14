package com.dwa.mycar.app

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dwa.mycar.data.database.CarProfileDao
import com.dwa.mycar.data.model.CarProfileDT

@Database(
    entities = [
        CarProfileDT::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun carProfileDao(): CarProfileDao

}