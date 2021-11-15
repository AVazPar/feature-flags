package com.avazpar.featureflag.data.datasource

import com.avazpar.featureflag.data.FeatureFlag
import com.avazpar.featureflag.utils.Either
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteFeatureFlagDataSourceImpl : RemoteFeatureFlagDataSource {
    private val remoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

    init {
        val configSettings = FirebaseRemoteConfigSettings.Builder().build()
        remoteConfig.setConfigSettingsAsync(configSettings)
        refreshFeatureFlags()
    }

    override fun isFeatureFlagEnabled(featureFlag: FeatureFlag): Flow<Either<String, Boolean>> = flow {
        emit(Either.Right(remoteConfig.getBoolean(featureFlag.id)))
    }

    override fun refreshFeatureFlags() {
        remoteConfig.fetch(getCacheExpirationSeconds()).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                remoteConfig.fetchAndActivate()
            }
        }
    }

    private fun getCacheExpirationSeconds(): Long = CACHE_EXPIRATION_SECS_DEV

    companion object {
        const val CACHE_EXPIRATION_SECS_DEV = 1L
    }
}