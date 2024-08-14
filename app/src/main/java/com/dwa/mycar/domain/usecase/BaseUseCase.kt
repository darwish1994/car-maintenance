package com.dwa.mycar.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseUseCase<out Type, in Params> where Type : Any{

    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO

    suspend operator fun invoke(params: Params): Type {
        return withContext(defaultDispatcher) {
            execute(params)
        }
    }

    protected abstract suspend fun execute(params: Params): Type
}