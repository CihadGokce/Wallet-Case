package com.cihadgokce.wallet

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.cihadgokce.wallet.core.BaseViewModel
import com.cihadgokce.wallet.core.di.IoDispatcher
import com.cihadgokce.wallet.core.model.ResponseModel
import com.cihadgokce.wallet.core.service.ResponseState
import com.cihadgokce.wallet.data.WalletRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WalletViewModel @Inject constructor(
    private val repository: WalletRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
    ) : BaseViewModel(){

    private val uiState = mutableStateOf<ResponseState<ResponseModel>>(ResponseState.Loading)

    fun response(): State<ResponseState<ResponseModel>> = uiState

        fun getWalletList() {
            viewModelScope.launch {
                repository.getWalletList().collect {
                    uiState.value = it
                }
            }
        }

}