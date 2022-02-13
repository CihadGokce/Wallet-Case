package com.cihadgokce.wallet.data.api

import javax.inject.Inject

class WalletDataSource @Inject constructor(
    private  val api :WalletApi
){
    suspend fun getWalletList()=api.getWalletList()
}