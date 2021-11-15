package com.avazpar.featureflag.data.datasource

import android.content.SharedPreferences
import com.avazpar.featureflag.data.FeatureFlag
import com.avazpar.featureflag.utils.Either
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalFeatureFlagDataSourceImpl(
        private val sharedPreferences: SharedPreferences
) : LocalFeatureFlagDataSource {
    override fun isFeatureFlagEnabled(featureFlag: FeatureFlag): Flow<Either<String, Boolean>> =
            flow {
                emit(Either.Right(sharedPreferences.getBoolean(featureFlag.id, featureFlag.defaultValue)))
            }

    override fun setFeatureFlagEnabled(featureFlag: FeatureFlag, enabled: Boolean) {
        return sharedPreferences.edit().putBoolean(featureFlag.id, enabled).apply()
    }
}