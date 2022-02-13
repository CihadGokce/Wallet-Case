package com.cihadgokce.wallet.data.di

import com.cihadgokce.wallet.data.WalletRepository
import com.cihadgokce.wallet.data.WalletRepositoryImpl
import com.cihadgokce.wallet.data.api.WalletApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class WalletDIModule {

    @Binds
    abstract fun provideWalletRepository(
        walletRepository: WalletRepositoryImpl
    ):WalletRepository

    companion object {
        @Provides
        fun provideWalletApi(
            retrofit: Retrofit
        )  : WalletApi = retrofit.create(WalletApi::class.java)
    }
}