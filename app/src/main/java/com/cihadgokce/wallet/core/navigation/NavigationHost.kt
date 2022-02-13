package com.cihadgokce.wallet.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cihadgokce.wallet.WalletListScreen

@ExperimentalUnitApi
@Composable
fun NavigationHost(){
    val navigation = rememberNavController()
    NavHost(navController = navigation,
        startDestination = Screens.WalletListScreen.road)
    {
        composable(route = Screens.WalletListScreen.road) {
            WalletListScreen(navController = navigation)
        }
    }

}