package com.uolimzhanov.eshopeffectivemobile.ui.generic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
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
import com.uolimzhanov.eshopeffectivemobile.model.entity.UiItem
import com.uolimzhanov.eshopeffectivemobile.ui.theme.EShopEffectiveMobileTheme
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Gray
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Orange
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Pink

/**
 * created by uolimzhanov on 02.02.2024
 */
@Composable
fun ItemCard(
    item: UiItem,
    modifier: Modifier = Modifier,
    images: List<Int> = listOf(1, 2),
    onSaveClick: (UiItem) -> Unit = {},
    onOpenClick: (UiItem) -> Unit = {}
){
    OutlinedCard(
        onClick = { onOpenClick(item) },
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.aspectRatio(7f/12f)
    ) {
        ImagePager(
            images = images,
            modifier = Modifier.aspectRatio(7/6f),
            isProductLiked = item.isLiked,
            onSaveItem = {
                onSaveClick(item)
            }
        )
        Box(modifier = Modifier.weight(1f)) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                        Text(
                            text = "${item.price.price} ${item.price.unit}",
                            textDecoration = TextDecoration.LineThrough,
                            color = Gray,
                            fontWeight = FontWeight.W400,
//                            fontFamily = sfProDisplay,
                            style = MaterialTheme.typography.labelSmall,
                            fontSize = 9.sp,
                            maxLines = 1,
                            lineHeight = 14.sp
                        )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.wrapContentHeight()
                    ) {
                        Text(
                            text = "${item.price.priceWithDiscount} ${item.price.unit}",
                            color = Color.Black,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
//                            fontFamily = sfProDisplay,
                            fontSize = 14.sp,
                            maxLines = 1,
                            lineHeight = 14.sp
                        )
                        Box(
                            modifier = Modifier
                                .wrapContentSize()
                                .background(Pink, RoundedCornerShape(4.dp))
                        ) {
                            Text(
                                text = "-${item.price.discount}%",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.W400,
//                                fontFamily = sfProDisplay,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(
                                        vertical = 1.dp, horizontal = 4.dp
                                    )
                                    .align(Alignment.Center),
                                fontSize = 9.sp,
                                maxLines = 1,
                                lineHeight = 14.sp
                            )
                        }
                    }
                    Text(
                        text = item.title,
                        color = Color.Black,
                        style = MaterialTheme.typography.titleLarge,
//                        fontFamily = sfProDisplay,
                        fontSize = 12.sp,
                        maxLines = 1,
                        lineHeight = 14.sp
                    )
                }

                Text(
                    text = item.subtitle,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 24.dp)
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.labelLarge,
//                    fontFamily = sfProDisplay,
                    fontSize = 10.sp,
                    lineHeight = 14.sp,
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
                                append("${item.feedback.rating} ")
                            }
                            withStyle(style = SpanStyle(color = Gray)) {
                                append("(${item.feedback.count})")
                            }
                        },
//                        fontFamily = sfProDisplay,
                        fontWeight = FontWeight.W400,
                        fontSize = 9.sp,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
            IconButton(
                onClick = { onSaveClick(item) },
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
//                    fontFamily = sfProDisplay,
                    color = Color.White
                )
            }
        }
    }
}


@Preview
@Composable
fun ItemCardPreview(){
    EShopEffectiveMobileTheme {
        /*val items = listOf(
            UiItem(
                isLiked = true,
                id = "cbf0c984-7c6c-4ada-82da-e29dc698bb50",
                title = "ESFOLIO",
                subtitle = "Лосьон для тела `ESFOLIO` COENZYME Q10 Увлажняющий 500 мл",
                price = Price(
                    price = "749",
                    discount = 35,
                    priceWithDiscount = "489",
                    unit = "₽"),
                feedback = Feedback(
                    count= 51,
                    rating = 4.5
                ),
                tags = listOf(
                    "body"
                ),
                available = 100,
                description = "Лосьон для тела `ESFOLIO` COENZYME Q10 Увлажняющий содержит минеральную воду и соду, способствует глубокому очищению пор от различных загрязнений, контроллирует работу сальных желез, сужает поры. Обладает мягким антиептическим действием, не пересушивает кожу. Минеральная вода тонизирует и смягчает кожу.",
                info = listOf(
                    Info(
                        title = "Артикул товара",
                        value = "441187"
                    ),
                    Info(
                        title = "Область использования",
                        value = "Тело"
                    ),
                    Info(
                        title = "Страна производства",
                        value = "Франция"
                    )
                ),
                ingredients = "Glycerin Palmitic Acid, Stearic Acid, Capric Acid, Sodium Benzoate"
            ),
            Item(subtitle = "2"),
            Item(subtitle = "3"),
            Item(subtitle = "4"),
            Item(subtitle = "5"),
            Item(subtitle = "6"),
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier,
            contentPadding = PaddingValues(2.dp),
            content = {
                items(items) { item ->
                    ItemCard(item = item)
                }
            }
        )*/
    }
}