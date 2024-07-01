package com.example.orangetask.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orangetask.R
import com.example.orangetask.ui.theme.greyText
import com.example.orangetask.ui.theme.orangeBackGroud

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    state: LoginScreenUiState,
    onClickNext: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(orangeBackGroud)
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .shadow(elevation = 100.dp),
                painter = painterResource(id = R.drawable.cesta),
                contentDescription = "fruitbasket"
            )

        }
        Text(
            text = "Qual é o seu nome?",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp

        )

        OutlinedTextField(
            modifier = Modifier
                .background(greyText)
                .padding(10.dp),
            value = state.name,
            label = { Text("Digite seu nome") },
            onValueChange = state.onNameChange
        )

        Button(
            modifier = Modifier
                .widthIn(327.dp)
                .heightIn(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = com.example.orangetask.theme.orangeBackGroud
            ),
            onClick = onClickNext) {
            Text("Começar")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun LoginScreenPrev() {
    LoginScreen(state = LoginScreenUiState() )
}