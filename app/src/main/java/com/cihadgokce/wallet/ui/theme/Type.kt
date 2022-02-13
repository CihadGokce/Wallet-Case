package com.cihadgokce.wallet.ui.theme

import android.graphics.Typeface
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp



@ExperimentalUnitApi
val typography = Typography(
        defaultFontFamily = FontFamily(Typeface.SANS_SERIF),
        h1 = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Light,
                fontFamily = FontFamily(Typeface.SANS_SERIF),
                letterSpacing = TextUnit(2.2F, TextUnitType.Sp)
        ),
        h2 = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal,
                color = androidx.compose.ui.graphics.Color.White, fontFamily = FontFamily(Typeface.SANS_SERIF)),
        h3 = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal,
                color = androidx.compose.ui.graphics.Color.White, fontFamily = FontFamily(Typeface.SANS_SERIF)),
        h4 = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Light,
                fontFamily = FontFamily(Typeface.SANS_SERIF),
                letterSpacing = TextUnit(1.5F, TextUnitType.Sp)),
        h5 = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Light,
                fontFamily = FontFamily(Typeface.SANS_SERIF),
                letterSpacing = TextUnit(1.5F, TextUnitType.Sp)),
)