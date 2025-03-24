package com.apsakare.hellolottie

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition


@Composable
fun ComposeLottieScreen() {

    Surface(
       modifier =  Modifier.fillMaxSize(),

    ) {
        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(R.raw.loading)
        )
        var isPlaying by remember {
            mutableStateOf(true)
        }
        val progress by animateLottieCompositionAsState(
            composition = composition,
            isPlaying = isPlaying
        )
        val sContext = LocalContext.current;
        LaunchedEffect(key1 = progress) {

            if (progress == 0f) {
                isPlaying = true

            }
            if (progress == 1f) {
                isPlaying = false
                Toast.makeText(sContext, sContext.getText(R.string.animationdone), Toast.LENGTH_LONG).show()




            }

        }

        LottieAnimation(
            composition = composition,
            modifier = Modifier
                .size(1500.dp)
                .clickable {
                    isPlaying = true
                },

            progress = {
                progress
            }
        )
    }
}



@Preview
@Composable
fun MainScreenPreview() {
    ComposeLottieScreen()
}