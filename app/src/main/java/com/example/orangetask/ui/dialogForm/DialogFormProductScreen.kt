package com.example.orangetask.ui.dialogForm

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.orangetask.ui.theme.OrangeTaskTheme


@Composable
fun DialogFormProductScreen(
    state: DialogFormProductUiState,
    onClickSaveProduct: () -> Unit = {},
    closeDialog: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = { /*TODO*/ }, content = {
            Column(
                modifier =
                modifier
                    .clip(RoundedCornerShape(8))
                    .height(300.dp)
                    .background(Color.White)
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                Box(modifier = Modifier.align(Alignment.End)) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "CloseDialog",
                        modifier = Modifier.clickable {
                            closeDialog()
                        })
                }

                Text(
                    text = "Cadastre o seu Produto", fontWeight = FontWeight.SemiBold,
                    fontSize = 25.sp
                )
                OutlinedTextField(
                    leadingIcon = {
                        Icon(
                            Icons.Default.Create,
                            contentDescription = ""
                        )
                    },
                    value = state.name,
                    onValueChange = state.onNameChange,
                    label = {
                        Text(
                            text = "Nome do Produto",
                        )
                    })
                Spacer(modifier = Modifier)
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = com.example.orangetask.theme.orangeBackGroud
                    ),
                    onClick = onClickSaveProduct
                ) {
                    Text("Salvar Produto")
                }

            }

        })
}


@Preview(showBackground = true)
@Composable
private fun DialogFormScreenPrev() {
    OrangeTaskTheme {
        DialogFormProductScreen(DialogFormProductUiState())
    }
}