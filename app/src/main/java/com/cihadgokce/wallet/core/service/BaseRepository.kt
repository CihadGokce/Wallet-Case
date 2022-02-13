package com.cihadgokce.wallet.core.service

import android.content.Context
import com.cihadgokce.wallet.core.constant.GlobalConstant
import com.cihadgokce.wallet.core.helper.NetworkHelper
import com.cihadgokce.wallet.core.model.ResponseModel
import com.cihadgokce.wallet.core.model.WalletModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.lang.reflect.Type

// servis çağırımı tetiklendiği yer manipule ediliyor json gönderiliyor

suspend fun <T> fetch(context: Context, dispatcher: CoroutineDispatcher, apiCall: suspend () -> T): Flow<ResponseState<ResponseModel>> = flow {
    emit(ResponseState.Loading)
    if(NetworkHelper.isNetworkConnection(context)) {
        emit(ResponseState.Success(getWalletModel()))
    } else {
        emit(ResponseState.Error("0", "Internet Baglantınızı kontrol ediniz!"))
    }
}.catch {
    when (it) {
        is java.io.IOException -> emit(ResponseState.Error("1", it.message.toString()))
        is HttpException -> {
            emit(ResponseState.Error("2",  it.response()?.errorBody().toString()))
        }
        else -> {
            emit(ResponseState.Error("3", "İşleminiz yapılırken anlık hata alındı"))
        }
    }
}.flowOn(dispatcher)

fun getWalletModel() : ResponseModel{


    val moshi = Moshi.Builder().build()
    val type: Type = Types.newParameterizedType(
        List::class.java,
        WalletModel::class.java
    )
    val jsonString = GlobalConstant.FAKE_RESPONSE

    val adapter: JsonAdapter<List<WalletModel>> = moshi.adapter<List<WalletModel>>(type)
    val walletList: List<WalletModel>? = adapter.fromJson(GlobalConstant.FAKE_RESPONSE)
    val response = ResponseModel(walletList!!.toCollection(ArrayList()))
    return response
}
