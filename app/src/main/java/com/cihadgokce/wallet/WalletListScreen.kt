package com.cihadgokce.wallet

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cihadgokce.wallet.core.error.ErrorScreen
import com.cihadgokce.wallet.core.loading.LoadingScreen
import com.cihadgokce.wallet.core.model.ResponseModel
import com.cihadgokce.wallet.core.service.ResponseState
import com.cihadgokce.wallet.uicomponent.BottomSection
import com.cihadgokce.wallet.uicomponent.CreditCard
import com.cihadgokce.wallet.uicomponent.CreditCardView
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import retrofit2.Response

@ExperimentalPagerApi
@ExperimentalUnitApi
@Composable
fun WalletListScreen(navController: NavController,viewModel: WalletViewModel = hiltViewModel()) {

    val response by viewModel.response()
    when(response){
        is ResponseState.Success -> {
            val data = (response as ResponseState.Success<ResponseModel>).data
            val state = rememberPagerState(pageCount = data.wallet.size)
            val scope = rememberCoroutineScope()
            val pending_balance = remember{
                mutableStateOf("0.00 TL")
            }
            val balance = remember{
                mutableStateOf("0.00,00 TL")
            }
            Surface() {
                    Box(){
                        Column(modifier = Modifier.fillMaxWidth()) {
                            HorizontalPager(state = state ,modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.5f)
                            ) { page ->   val creditCardModel = CreditCard(
                                creditCardNumber = data.wallet[page].number,
                                holderName = "Cihad Gökce",
                                expiration = "12/23",
                                isNfc = true,
                                textColor = R.color.white,
                                cardBackgroundColor = androidx.appcompat.R.color.material_blue_grey_900,

                                )
                                balance.value = "${data.wallet[page].balance.currency} ${data.wallet[page].balance.value}"
                                pending_balance.value = "${data.wallet[page].pendingBalance.currency} ${data.wallet[page].pendingBalance.value}"
                                CreditCardView(creditCard = creditCardModel )
                            }

                            BottomSection(size = data.wallet.size, index = state.currentPage ) {
                                if(state.currentPage + 1 < data.wallet.size){
                                    scope.launch {
                                        state.scrollToPage(state.currentPage + 1)

                                    }
                                }
                            }


                            Text(text = "BALANCE ", fontSize = 30.sp,textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth())
                            Text(text = balance.value,fontSize = 50.sp,textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth(),)

                            Row(modifier = Modifier.fillMaxWidth()) {
                                Text(text = "PENDING BALANCE " , textAlign = TextAlign.Start, modifier = Modifier.padding(16.dp))
                                Text(
                                    text = balance.value,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier.padding(16.dp)
                                )

                            }

                            Row(modifier = Modifier.fillMaxWidth()) {
                                Button(
                                    modifier = Modifier.padding(16.dp).weight(1f),
                                    elevation = ButtonDefaults.elevation(5.dp),
                                    onClick = {
                                    }) {
                                    Text(text = "Top Up", modifier = Modifier.padding(16.dp))
                                }

                                Button(
                                    modifier = Modifier.padding(16.dp).weight(1f),
                                    elevation = ButtonDefaults.elevation(5.dp),
                                    onClick = {
                                    }) {
                                    Text(text = "Manage", modifier = Modifier.padding(16.dp))
                                }
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