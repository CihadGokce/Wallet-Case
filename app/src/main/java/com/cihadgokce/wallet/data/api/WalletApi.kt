package com.cihadgokce.wallet.data.api

import com.cihadgokce.wallet.core.model.ResponseModel
import retrofit2.http.GET

interface WalletApi {

    @GET("/wallet/")
    suspend fun getWalletList() : ResponseModel

}