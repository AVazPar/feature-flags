package com.avazpar.featureflag.di

import com.avazpar.featureflag.data.datasource.LocalFeatureFlagDataSource
import com.avazpar.featureflag.data.datasource.LocalFeatureFlagDataSourceImpl
import com.avazpar.featureflag.data.datasource.RemoteFeatureFlagDataSource
import com.avazpar.featureflag.data.datasource.RemoteFeatureFlagDataSourceImpl
import com.avazpar.featureflag.data.repository.FeatureFlagRepository
import com.avazpar.featureflag.data.repository.FeatureFlagRepositoryImpl
import com.avazpar.featureflag.domain.CreditScoreFlagUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { CreditScoreFlagUseCase(get()) }
}

val dataModule = module {
    single<FeatureFlagRepository> { FeatureFlagRepositoryImpl(get(), get()) }

    single<LocalFeatureFlagDataSource> { LocalFeatureFlagDataSourceImpl(get()) }
    single<RemoteFeatureFlagDataSource> { RemoteFeatureFlagDataSourceImpl() }
}

val viewModelModule = module {

}