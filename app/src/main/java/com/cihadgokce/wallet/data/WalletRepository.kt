package com.cihadgokce.wallet.data

import com.cihadgokce.wallet.core.model.ResponseModel
import com.cihadgokce.wallet.core.service.ResponseState
import kotlinx.coroutines.flow.Flow

interface WalletRepository {

    suspend fun getWalletList() : Flow<ResponseState<ResponseModel>>

}