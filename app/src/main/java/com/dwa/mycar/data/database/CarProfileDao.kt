package com.dwa.mycar.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dwa.mycar.data.model.CarProfileDT
import kotlinx.coroutines.flow.Flow

@Dao
interface CarProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createProfile(profile:CarProfileDT)

    @Query("SELECT * FROM carprofiledt where id=:id")
    suspend fun getCarProfileByIg(id:Int):CarProfileDT?

    @Update
    suspend fun updateProfile(profile: CarProfileDT)

    @Delete
    suspend fun deleteProfile(profile: CarProfileDT)

    @Query("SELECT * FROM carprofiledt")
    fun getProfilesd():List<CarProfileDT>

    @Query("SELECT * FROM carprofiledt")
    fun getProfiles():Flow<List<CarProfileDT>>


}