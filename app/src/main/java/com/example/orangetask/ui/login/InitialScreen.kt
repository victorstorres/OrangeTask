package com.example.orangetask.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orangetask.R
import com.example.orangetask.theme.orangeBackGroud


@Composable
fun InitiaScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier =
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(
                    orangeBackGroud,
                ),

            contentAlignment = Alignment.Center

        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .shadow(elevation = 100.dp)
                ,
                painter = painterResource(id = R.drawable.orange),
                contentDescription = "Orange_Image",
            )

        }
            Text(
                text = "Bem vindo ao OrangeTask",
                fontWeight = FontWeight.SemiBold,
                fontSize = 25.sp
            )
            Text(
                modifier = Modifier.padding(10.dp),
                text ="Aplicativo de lista de compras",
                fontWeight = FontWeight.Light,
                fontSize = 24.sp

                )
            Button(
                modifier = Modifier
                    .width(327.dp)
                    .height(56.dp)
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = orangeBackGroud
                ),
                onClick = {


                }) {
                Text(text = "Proximo")
            }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun InitialScreenPrev() {
    InitiaScreen()
}
