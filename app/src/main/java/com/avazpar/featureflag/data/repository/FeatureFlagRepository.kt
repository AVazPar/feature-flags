package com.avazpar.featureflag.data.repository

import com.avazpar.featureflag.data.FeatureFlag
import com.avazpar.featureflag.utils.Either
import kotlinx.coroutines.flow.Flow

interface FeatureFlagRepository {

    fun isFeatureFlagEnabled(featureFlag: FeatureFlag): Flow<Either<String, Boolean>>
}