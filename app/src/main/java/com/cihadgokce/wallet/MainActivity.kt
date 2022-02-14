package com.cihadgokce.wallet

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.cihadgokce.wallet.core.BaseActivity
import com.cihadgokce.wallet.core.navigation.NavigationHost
import com.cihadgokce.wallet.ui.theme.WalletTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagerApi
@ExperimentalUnitApi
@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalletTheme {
                NavigationHost()
            }
        }
    }
}



