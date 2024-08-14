package com.dwa.mycar.data.mapper

interface ModelMapper<T, TD> {
    fun mapToModel(model: TD): T
    fun mapToDomainModel(model: T): TD
    fun mapListToModel(model:List<TD>):List<T>
}