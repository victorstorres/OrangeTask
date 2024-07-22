package com.example.orangetask.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orangetask.ui.Card.SwipeProduct
import com.example.orangetask.ui.theme.orangeBackGroud

@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState(),
    onCheckBoxChange: (Long, Boolean) -> Unit = { _, _ -> },
    modifier: Modifier = Modifier,
    removeProduct: (Long) -> Unit = {},
    clickFloatActionButton: () -> Unit = {}

) {

    Scaffold(
        topBar = {
            TopAppBarOrangeTask(modifier = modifier, clickSearchButton = {
            })
        },
        floatingActionButton = {
            FloatActionButtonOrangeTask(
                clickFloatActionButton = clickFloatActionButton
            )
        },

        ) { paddingValues ->

        val context = LocalContext.current

        LazyColumn(
            modifier = modifier.padding(paddingValues),
            contentPadding = PaddingValues(bottom = 65.dp),
        ) {
            items(items = state.products) { product ->
                SwipeProduct(
                    modifier = modifier,
                    removeProduct = removeProduct,
                    product = product,
                    onCheckBoxChange = onCheckBoxChange,
                    context = context
                )
            }
        }
    }
}


@Composable
private fun FloatActionButtonOrangeTask(
    clickFloatActionButton: () -> Unit = { }
) {


    FloatingActionButton(
        containerColor = orangeBackGroud,
        onClick = clickFloatActionButton
    ) {
        Icon(Icons.Default.Add, contentDescription = "ButtonAddFloatActionButton")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBarOrangeTask(
    clickSearchButton: () -> Unit = { }, modifier: Modifier
) {
    TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
        containerColor = orangeBackGroud
    ), title = {
        Row(
            modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {
            Text(
                text = "Orange Task", fontSize = 20.sp, fontWeight = FontWeight.SemiBold
            )
            Icon(Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .clickable { clickSearchButton.invoke() })
        }
    })
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPrev() {
    HomeScreen(HomeScreenUiState())
}


@Preview
@Composable
private fun ProductCardPrev() {
//    ProductCard(product = Product(name = "Teste"), context = LocalContext.current)
}