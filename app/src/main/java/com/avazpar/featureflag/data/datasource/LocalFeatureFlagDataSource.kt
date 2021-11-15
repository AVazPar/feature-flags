package com.avazpar.featureflag.data.datasource

import com.avazpar.featureflag.data.FeatureFlag
import com.avazpar.featureflag.utils.Either
import kotlinx.coroutines.flow.Flow

interface LocalFeatureFlagDataSource {
    fun isFeatureFlagEnabled(featureFlag: FeatureFlag): Flow<Either<String, Boolean>>
    fun setFeatureFlagEnabled(featureFlag: FeatureFlag, enabled: Boolean)
}
