package com.example.orangetask.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orangetask.data.Product
import com.example.orangetask.ui.theme.orangeBackGroud

@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState(),
    onCheckBoxChange: (Long, Boolean) -> Unit = {_, _ -> },
    modifier: Modifier = Modifier,
    clickFloatActionButton: () -> Unit = {},
    clickSearchButton: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBarOrangeTask(modifier = modifier, clickSearchButton = clickSearchButton)
        },
        floatingActionButton = {
            FloatActionButtonOrangeTask(
                clickFloatActionButton = clickFloatActionButton
            )
        },

        ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(bottom = 65.dp)
        ) {
            items(state.products) { product ->
                ProductCard(
                    product = product,
                    onCheckBoxChange = onCheckBoxChange

                )
            }
        }
        Spacer(modifier = Modifier.padding(20.dp))
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

@Composable
fun ProductCard(
    product: Product,
    onCheckBoxChange: (Long, Boolean) -> Unit = {_, _ -> },
    elevetion: Dp = 4.dp, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(50.dp)
            .padding(10.dp),
        onClick = { /*TODO*/ },
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevetion
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(text = product.name)

            Checkbox(
                checked = product.isCheck,
                onCheckedChange = {
                    onCheckBoxChange(product.id, !product.isCheck)
                }
            )
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPrev() {
    HomeScreen(HomeScreenUiState())
}