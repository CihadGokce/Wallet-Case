package com.cihadgokce.wallet.core.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun LoadingScreen() { 
    Surface() {
        Box{ 
            Text(text = "Loading...")
        }
    }

}