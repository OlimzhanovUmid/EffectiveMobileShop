package com.uolimzhanov.eshopeffectivemobile.ui.generic

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.uolimzhanov.eshopeffectivemobile.R
import com.uolimzhanov.eshopeffectivemobile.ui.theme.EShopEffectiveMobileTheme
import com.uolimzhanov.eshopeffectivemobile.ui.theme.LightGray
import com.uolimzhanov.eshopeffectivemobile.ui.theme.Pink

/**
 * created by uolimzhanov on 04.02.2024
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImagePager(
    modifier: Modifier = Modifier,
    images: List<Int> = listOf(1, 2),
    isProductLiked: Boolean = false
){
    Box(modifier = modifier){
        val pagerState = rememberPagerState(pageCount = {
            images.size
        })
        HorizontalPager(
            state = pagerState,
        ) {
            SubcomposeAsyncImage(
                model = images,
                contentScale = ContentScale.FillBounds,
                error = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(0.7f)
                        )
                    }
                },
                contentDescription = null,
                modifier = Modifier
            )
        }
        IconButton(onClick = { /*TODO*/ }, Modifier.align(Alignment.TopEnd)) {
            Icon(
                painter = painterResource(
                    id = if(isProductLiked)
                            R.drawable.heart_filled
                        else
                            R.drawable.heart_outlined
                ),
                contentDescription = null,
                tint = Pink,
                modifier = Modifier.size(24.dp)
            )
        }
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter).background(Color.Transparent),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) {iteration ->
                val color = if(pagerState.currentPage == iteration) Pink else LightGray
                Box(
                    Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(6.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun ImagePagerPreview(){
    EShopEffectiveMobileTheme {
        ImagePager(Modifier.aspectRatio(1f), isProductLiked = true)
    }
}