package com.cihadgokce.wallet.core

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// uygulama açıldığında açılan ilk app

@HiltAndroidApp
class WalletApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}