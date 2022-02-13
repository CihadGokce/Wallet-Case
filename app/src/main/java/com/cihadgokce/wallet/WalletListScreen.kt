package com.cihadgokce.wallet

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cihadgokce.wallet.core.error.ErrorScreen
import com.cihadgokce.wallet.core.loading.LoadingScreen
import com.cihadgokce.wallet.core.model.ResponseModel
import com.cihadgokce.wallet.core.service.ResponseState
import com.cihadgokce.wallet.uicomponent.CreditCard
import com.cihadgokce.wallet.uicomponent.CreditCardView
import retrofit2.Response

@ExperimentalUnitApi
@Composable
fun WalletListScreen(navController: NavController,viewModel: WalletViewModel = hiltViewModel()) {

    val response by viewModel.response()
    when(response){
        is ResponseState.Success -> {
            val data = (response as ResponseState.Success<ResponseModel>).data
            Surface() {
                LazyColumn{
                    items(data.wallet){

                        val creditCardModel = CreditCard(
                            creditCardNumber = it.number,
                            holderName = "Cihad Gökce",
                            expiration = "12/23",
                            isNfc = true,
                            textColor = R.color.black,
                            cardBackgroundColor = R.color.teal_700
                        )

                        Row(modifier = Modifier.padding(16.dp)) {
                            CreditCardView(creditCard = creditCardModel)
                        }

                    }
                }

            }
        }
        is ResponseState.Loading ->{
            LoadingScreen()
        }
        is ResponseState.Error ->{
            ErrorScreen(errorMessage = "Lütfen tekrar deneyiniz !")
        }
    }










    LaunchedEffect(Unit){
        viewModel.getWalletList()
    }
}