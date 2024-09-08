package com.dwa.mycar.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CarProfileDT(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val brand: String,
    val model: String,
    val distance: Double,
)