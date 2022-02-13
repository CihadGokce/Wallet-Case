package com.cihadgokce.wallet.core.error

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorScreen(errorMessage:String) {
    Surface() {
        Box{
            Text(text = errorMessage)
        }
    }
}