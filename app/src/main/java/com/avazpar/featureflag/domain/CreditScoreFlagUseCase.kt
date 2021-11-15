package com.avazpar.featureflag.domain

import com.avazpar.featureflag.data.FeatureFlag
import com.avazpar.featureflag.data.repository.FeatureFlagRepository
import com.avazpar.featureflag.utils.Either
import com.avazpar.featureflag.utils.SimpleFlowUseCase
import kotlinx.coroutines.flow.Flow

class CreditScoreFlagUseCase(
        private val featureFlagRepository: FeatureFlagRepository
) : SimpleFlowUseCase<Boolean, Unit> {

    override suspend fun run(params: Unit): Flow<Either<String, Boolean>> =
            featureFlagRepository.isFeatureFlagEnabled(featureFlag = FeatureFlag.CREDIT_SCORE)
}