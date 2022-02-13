package com.cihadgokce.wallet.core.helper

// connection ağına bakıyoruz internet var mı yok mu
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkHelper {
    fun isNetworkConnection(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}