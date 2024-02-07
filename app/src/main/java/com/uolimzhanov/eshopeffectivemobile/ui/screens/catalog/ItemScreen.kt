package com.uolimzhanov.eshopeffectivemobile.ui.screens.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uolimzhanov.eshopeffectivemobile.R
import com.uolimzhanov.eshopeffectivemobile.model.entity.Feedback
import com.uolimzhanov.eshopeffectivemobile.model.entity.Info
import com.uolimzhanov.eshopeffectivemobile.model.entity.Item
import com.uolimzhanov.eshopeffectivemobile.model.entity.Price
import com.uolimzhanov.eshopeffectivemobile.ui.controls.EMButton
import com.uolimzhanov.eshopeffectivemobile.ui.generic.ImagePager
import com.uolimzhanov.eshopeffectivemobile.ui.generic.RatingBar
import com.uolimzhanov.eshopeffectivemobile.ui.theme.EShopEffectiveMobileTheme
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Gray
import com.uolimzhanov.eshopeffectivemobile.ui.theme.LightGray
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Orange
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Pink

/**
 * created by uolimzhanov on 07.02.2024
 */
@Composable
fun ItemScreen(
    item: Item = Item(),
    isDescriptionVisible: Boolean = true,
    areIngredientsVisible: Boolean = true,
    onDescriptionVisibilityChange: () -> Unit = {},
    onIngredientsVisibilityChange: () -> Unit = {},
    paddingValues: PaddingValues = PaddingValues()
){
    val density = LocalDensity.current

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = paddingValues.calculateBottomPadding())
    ) {
        val maxWidthInPx by remember {
            mutableIntStateOf(
                with(density) {
                    (constraints.maxWidth.dp).toPx().toInt()
                }
            )
        }
        val style = MaterialTheme.typography.displayLarge
        val fontFamilyResolver = LocalFontFamilyResolver.current
        val paragraph = remember{ mutableStateOf(androidx.compose.ui.text.Paragraph(
            text = item.ingredients,
            style = style,
            constraints = Constraints(maxWidth = maxWidthInPx),
            density = density,
            fontFamilyResolver = fontFamilyResolver,
        ))}
        LazyColumn(
            contentPadding = paddingValues,
            content = {
                item{
                    Box(modifier = Modifier.aspectRatio(0.85f)){
                        ImagePager(modifier = Modifier.fillMaxSize())
                        Icon(
                            painter = painterResource(id = R.drawable.help_circle),
                            contentDescription = null,
                            tint = Gray,
                            modifier = Modifier.align(Alignment.BottomStart).padding(32.dp)
                        )
                    }
                }
                item{
                    ListItem(
                        overlineContent = {
                            Text(
                                text = item.title
                            )
                        },
                        headlineContent = {
                            Text(
                                text = item.subtitle
                            )
                        },
                        supportingContent = {
                            Text(
                                text = buildAnnotatedString {
                                    append()
                                    append("${item.available}")
                                    append()
                                }
                            )
                        }
                    )
                }
                item{
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = LightGray
                    )
                }
                item{
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, start = 16.dp, bottom = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RatingBar(item.feedback.rating.toFloat())
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Orange)) {
                                    append("${item.feedback.rating}")
                                }
                                append(" · ")
                                withStyle(style = SpanStyle(color = Gray)) {
                                    append("(${item.feedback.count})")
                                }
                            },
                            fontWeight = FontWeight.W400,
                            fontSize = 9.sp,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                    Row {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {
                            Text(
                                text = "${item.price.priceWithDiscount} ${item.price.unit}",
                                color = Color.Black,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                //                            fontFamily = sfProDisplay,
                                fontSize = 16.sp,
                                maxLines = 1,
                                lineHeight = 14.sp
                            )
                            Text(
                                text = "${item.price.price} ${item.price.unit}",
                                textDecoration = TextDecoration.LineThrough,
                                color = Gray,
                                fontWeight = FontWeight.W400,
                                //                            fontFamily = sfProDisplay,
                                style = MaterialTheme.typography.labelSmall,
                                fontSize = 10.sp,
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
                    }
                }
                item{
                    Text(
                        text = "Описание",
                        color = Color.Black,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        //                            fontFamily = sfProDisplay,
                        maxLines = 1,
                        lineHeight = 14.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                    )
                }
                if(isDescriptionVisible) {
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = item.title,
                                    color = Color.Black,
                                    style = MaterialTheme.typography.titleLarge,
                                    maxLines = 1,
                                    lineHeight = 14.sp
                                )
                                IconButton(onClick = { }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.right_arrow),
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                    }
                    item{
                        Text(
                            text = item.description,
                            modifier = Modifier.padding(horizontal = 16.dp),
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
                item{
                    Text(
                        text = if(isDescriptionVisible) "Скрыть" else "Подробнее",
                        color = Gray,
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .clickable {
                                onDescriptionVisibilityChange()
                            }
                    )
                }
                item{
                    Text(
                        text = "Характеристики",
                        color = Color.Black,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        //                            fontFamily = sfProDisplay,
                        maxLines = 1,
                        lineHeight = 14.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                    )
                }
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                    ) {
                        item.info.forEach{info ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = info.title)
                                Text(text = info.value)
                            }
                            HorizontalDivider(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                color = Gray
                            )

                        }
                    }
                }
                item{
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Состав",
                            color = Color.Black,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            //   fontFamily = sfProDisplay,
                            maxLines = 1,
                            lineHeight = 14.sp,
                        )
                        Icon(painter = painterResource(id = R.drawable.copy), contentDescription = null)
                    }
                }
                item {
                    Text(
                        text = item.ingredients,
                        modifier = Modifier.padding(horizontal = 16.dp),
                        style = MaterialTheme.typography.labelLarge,
                        maxLines = if(areIngredientsVisible) paragraph.value.lineCount else 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if(paragraph.value.lineCount > 2) {
                    item {
                        Text(
                            text = if (areIngredientsVisible) "Скрыть" else "Подробнее",
                            color = Gray,
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .clickable {
                                    onIngredientsVisibilityChange()
                                }
                        )
                    }
                }

            }
        )
        EMButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .align(Alignment.BottomCenter)
        ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${item.price.priceWithDiscount} ${item.price.unit}",
                            color = Color.Black,
                            style = MaterialTheme.typography.titleLarge,
                            fontSize = 14.sp,
    //                            fontFamily = sfProDisplay,
                            maxLines = 1,
                            lineHeight = 14.sp
                        )
                        Text(
                            text = "${item.price.price} ${item.price.unit}",
                            textDecoration = TextDecoration.LineThrough,
                            color = Gray,
                            fontWeight = FontWeight.W400,
                            style = MaterialTheme.typography.labelSmall,
                            fontSize = 10.sp,
    //                            fontFamily = sfProDisplay,
                            maxLines = 1,
                            lineHeight = 14.sp
                        )
                    }
                    Text(
                        text = stringResource(id = R.string.add_to_cart),
                        color = Color.White,
                        fontWeight = FontWeight.W500,
                        style = MaterialTheme.typography.labelSmall,
                        fontSize = 14.sp,
    //                            fontFamily = sfProDisplay,
                        maxLines = 1,
                        lineHeight = 14.sp
                    )
                }
            }
    }
}

@Preview
@Composable
fun ItemScreenPreview(){
    EShopEffectiveMobileTheme {
        Surface {
            ItemScreen(
                isDescriptionVisible = false,
                item = Item(
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
                    ingredients = "Glycerin Palmitic Acid, Stearic Acid, Capric Acid, Sodium BenzoateGlycerin Palmitic Acid, Stearic Acid, Capric Acid, Sodium BenzoateGlycerin Palmitic Acid, Stearic Acid, Capric Acid, Sodium Benzoate"
                ),
            )
        }
    }
}