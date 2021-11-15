package com.avazpar.featureflag.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf

interface UseCase<out Response, out String, in UseCaseParams> {
    suspend fun observe(params: UseCaseParams): Flow<Either<String, Response>> = flowOf(invoke(params))
    suspend operator fun invoke(params: UseCaseParams): Either<String, Response>
}

interface SimpleFlowUseCase<out Response, UseCaseParams> : UseCase<Response, String, UseCaseParams> {

    override suspend fun observe(params: UseCaseParams): Flow<Either<String, Response>> = run(params = params)

    override suspend operator fun invoke(params: UseCaseParams): Either<String, Response> = run(params = params).first()

    suspend fun run(params: UseCaseParams): Flow<Either<String, Response>>
}
