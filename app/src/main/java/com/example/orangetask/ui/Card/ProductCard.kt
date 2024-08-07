@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.orangetask.ui.Card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.orangetask.R
import com.example.orangetask.data.Product
import kotlinx.coroutines.launch


@Composable
fun SwipeProduct(
    product: Product,
    onCheckBoxChange: (Long, Boolean) -> Unit = { _, _ -> },
    elevetion: Dp = 4.dp, modifier: Modifier = Modifier,
    removeProduct: (Long) -> Unit = {},
) {

    val state = rememberSwipeToDismissBoxState()
    val coroutineScope = rememberCoroutineScope()


    LaunchedEffect(state.currentValue) {
        if (state.dismissDirection == SwipeToDismissBoxValue.EndToStart) {
            coroutineScope.launch {
                removeProduct(product.id)
                state.snapTo(SwipeToDismissBoxValue.Settled)
            }
        }
    }


    SwipeToDismissBox(
        state = state,
        enableDismissFromStartToEnd = false,
        backgroundContent = { DismissBackground(dismissState = state) }
    ) {
        ProductCard(
            product = product,
            onCheckBoxChange = onCheckBoxChange,
            elevetion = elevetion,
            modifier = modifier.padding(5.dp)
        )
    }


}

@Composable
private fun ProductCard(
    product: Product,
    onCheckBoxChange: (Long, Boolean) -> Unit = { _, _ -> },
    elevetion: Dp = 4.dp, modifier: Modifier = Modifier,
) {


    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(80.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevetion,
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(
                Modifier.padding(
                    horizontal = 5.dp,
                    vertical = 1.dp
                )
            ) {
                if (product.image.isNotEmpty() && product.image != "null") {
                    AsyncImage(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(48.dp),
                        model = product.image,
                        placeholder = painterResource(R.drawable.no_image),
                        error = painterResource(R.drawable.no_image),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Photo Product",
                    )
                }
            }
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
}

@Preview(showBackground = true)
@Composable
private fun PrevCard() {
    SwipeProduct(product = Product(name = "Roberta", image = ""))
}

@Preview(showBackground = true)
@Composable
private fun PrevCardWithImage() {
    SwipeProduct(product = Product(name = "Roberta", image = "null"))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DismissBackground(dismissState: SwipeToDismissBoxState) {
    if (dismissState.targetValue == SwipeToDismissBoxValue.EndToStart) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
                .padding(12.dp, 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                Icons.Default.Delete,
                contentDescription = "delete"
            )
            Spacer(modifier = Modifier)

        }
    }
}

