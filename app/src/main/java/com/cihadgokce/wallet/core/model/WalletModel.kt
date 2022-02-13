package com.cihadgokce.wallet.core.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseModel (
    val wallet:ArrayList<WalletModel> = arrayListOf()
)

@JsonClass(generateAdapter = true)
data class WalletModel(
     val image:String,
     val number:String,
     val cvv:String,
     val balance:BalanceModel,
     val pendingBalance :BalanceModel,
)

@JsonClass(generateAdapter = true)
data class BalanceModel(
    val value:String,
    val currency:String
)
