package com.uolimzhanov.eshopeffectivemobile.ui.generic

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W200
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uolimzhanov.eshopeffectivemobile.R
import com.uolimzhanov.eshopeffectivemobile.model.entity.Product
import com.uolimzhanov.eshopeffectivemobile.ui.theme.EShopEffectiveMobileTheme
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Gray
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Orange
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Pink

/**
 * created by uolimzhanov on 02.02.2024
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
    images: List<Int> = listOf(1, 2),
    onSaveClick: (Product) -> Unit = {}
){
    OutlinedCard(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.aspectRatio(7f/12f)
    ) {
        ImagePager(
            images = images,
            modifier = Modifier.aspectRatio(7/6f)
        )
        Box(modifier = Modifier.weight(1f)) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                        Text(
                            text = "${product.price.price} ${product.price.unit}",
                            textDecoration = TextDecoration.LineThrough,
                            color = Gray,
                            fontWeight = FontWeight.W400,
                            style = MaterialTheme.typography.labelSmall,
                            fontSize = 9.sp
                        )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.wrapContentHeight()
                    ) {
                        Text(
                            text = "${product.price.priceWithDiscount} ${product.price.unit}",
                            color = Color.Black,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                        Box(
                            modifier = Modifier
                                .wrapContentSize()
                                .background(Pink, RoundedCornerShape(4.dp))
                        ) {
                            Text(
                                text = "-${product.price.discount}%",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.W400,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(
                                        vertical = 1.dp, horizontal = 4.dp
                                    )
                                    .align(Alignment.Center),
                                fontSize = 9.sp
                            )
                        }
                    }
                    Text(
                        text = product.title,
                        color = Color.Black,
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 12.sp
                    )
                }

                Text(
                    text = product.subtitle,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 24.dp)
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = 10.sp
                )
                Row(
                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.small_star),
                        tint = Orange,
                        contentDescription = null
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Orange)) {
                                append("${product.feedback.rating} ")
                            }
                            withStyle(style = SpanStyle(color = Gray)) {
                                append("(${product.feedback.count})")
                            }
                        },
                        fontWeight = FontWeight.W400,
                        fontSize = 9.sp,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
            IconButton(
                onClick = { onSaveClick(product) },
                Modifier
                    .background(Pink, RoundedCornerShape(8.dp, 0.dp, 8.dp, 0.dp))
                    .align(Alignment.BottomEnd).fillMaxHeight(32/144f).fillMaxWidth(32/168f)
            ) {
                Text(
                    text = "+",
                    modifier = Modifier
                        .fillMaxSize(),
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = W200,
                    color = Color.White
                )
            }
        }
    }
}


@Preview
@Composable
fun ProductCardPreview(){
    EShopEffectiveMobileTheme {
        val products = listOf(
            Product(subtitle = "1"),
            Product(subtitle = "2"),
            Product(subtitle = "3"),
            Product(subtitle = "4"),
            Product(subtitle = "5"),
            Product(subtitle = "6"),
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier,
            contentPadding = PaddingValues(2.dp),
            content = {
                items(products) { product ->
                    ProductCard(product = product)
                }
            }
        )
    }
}