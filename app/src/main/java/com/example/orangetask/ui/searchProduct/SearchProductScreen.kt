package com.example.orangetask.ui.searchProduct

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.orangetask.ui.Card.SwipeProduct

@Composable
fun SearchProductScreen(
    modifier: Modifier = Modifier,
    state: SearchProductUiState = SearchProductUiState(),
    onClickBack: () -> Unit = {},
    removeProduct: (Long) -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            AppBarSearchProduct(
                value = state.nameProduct,
                valueChange = state.onChangeNameProduct,
                onClickBack = onClickBack
            )
        }
    ) { paddingValues ->
        LazyColumn(modifier.padding(paddingValues)) {
            items(state.products) { products ->
                SwipeProduct(
                    product = products,
                    removeProduct = removeProduct
                )
            }
        }
    }
}

@Composable
fun AppBarSearchProduct(
    value: String,
    valueChange: (String) -> Unit = {},
    onClickBack: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onClickBack
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )

            }

            BasicTextField(
                value = value,
                onValueChange = valueChange,
                decorationBox = { interValue ->
                    Box(
                        Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        if (value.isEmpty()) {
                            Text("Buscar Produtos")
                        }
                        interValue()
                    }
                },
                cursorBrush = SolidColor(Color(0xFF6200EE)),

                )
        }
        VerticalDivider(thickness = 4.dp)
    }
}


@Preview(showSystemUi = true)
@Composable
private fun SearchProductPrev() {
    SearchProductScreen()
}