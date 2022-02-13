package com.cihadgokce.wallet.data

import android.content.Context
import com.cihadgokce.wallet.core.di.IoDispatcher
import com.cihadgokce.wallet.core.model.ResponseModel
import com.cihadgokce.wallet.core.service.ResponseState
import com.cihadgokce.wallet.core.service.fetch
import com.cihadgokce.wallet.data.api.WalletDataSource
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WalletRepositoryImpl @Inject constructor(
  @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
  @ApplicationContext private val context: Context,
  private val dataSource: WalletDataSource
) : WalletRepository {
    override suspend fun getWalletList(): Flow<ResponseState<ResponseModel>> {
        return fetch(context,ioDispatcher){
            dataSource.getWalletList()
        }
    }

}