package com.dwa.mycar.feature.main.add.profile.state

data class CreateProfileState(
    val profile:String="",
    val error:String?=null,
    val enable:Boolean=true,
    val finished:Boolean=false

)
