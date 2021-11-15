package com.avazpar.featureflag.data.repository

import com.avazpar.featureflag.data.FeatureFlag
import com.avazpar.featureflag.data.datasource.LocalFeatureFlagDataSource
import com.avazpar.featureflag.data.datasource.RemoteFeatureFlagDataSource
import com.avazpar.featureflag.utils.Either
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class FeatureFlagRepositoryImpl(
    private val sharedPreferencesDataSourceLocal: LocalFeatureFlagDataSource,
    private val remoteFeatureFlagDataSource: RemoteFeatureFlagDataSource
): FeatureFlagRepository {

    override fun isFeatureFlagEnabled(featureFlag: FeatureFlag): Flow<Either<String, Boolean>> = flow {
        remoteFeatureFlagDataSource.isFeatureFlagEnabled(featureFlag = featureFlag)
    }
}