package com.dwa.mycar.domain.model

data class CarProfile(
    val id: Int?=null,
    val name: String,
    val brand: String,
    val model: String,
    val distance: Double,
    )
