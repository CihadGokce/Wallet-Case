package com.cihadgokce.wallet.core.navigation

sealed class Screens(val road : String){
    object WalletListScreen : Screens("WalletScreen")

}