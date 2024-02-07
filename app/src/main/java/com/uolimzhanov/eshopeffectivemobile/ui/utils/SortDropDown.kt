package com.uolimzhanov.eshopeffectivemobile.ui.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uolimzhanov.eshopeffectivemobile.R
import com.uolimzhanov.eshopeffectivemobile.model.entity.SortOrder
import com.uolimzhanov.eshopeffectivemobile.ui.theme.EShopEffectiveMobileTheme

/**
 * created by uolimzhanov on 06.02.2024
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SortDropDown(
    modifier: Modifier = Modifier,
    isExpanded: Boolean = true,
    selectedOrder: SortOrder = SortOrder.RATING,
    onExpandChange: () -> Unit = {},
    onDismiss: () -> Unit = {},
    onSelected: (SortOrder) -> Unit = {},
){
    var sortMenuExpanded by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    ExposedDropdownMenuBox(
        expanded = sortMenuExpanded,
        onExpandedChange = { sortMenuExpanded = it },
        modifier = modifier
    ) {
        BasicTextField(
            value = TextFieldValue(
                text  = stringResource(id = selectedOrder.textId)
            ),
            onValueChange = { },
            readOnly = true,
            singleLine = true,
            modifier = Modifier.
                menuAnchor()
                .clickable { sortMenuExpanded = !sortMenuExpanded },
            decorationBox = @Composable { innerTextField ->
                Row {
                    Row(
                        modifier = Modifier
                            .wrapContentWidth()
                            .clickable {  sortMenuExpanded = !sortMenuExpanded },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.sort_by),
                            contentDescription = null
                        )
                        innerTextField()
                        Icon(
                            painter = painterResource(id = R.drawable.down_arrow),
                            contentDescription = null
                        )
                    }}
            }
        )
        ExposedDropdownMenu(
            expanded = sortMenuExpanded,
            onDismissRequest = {
                sortMenuExpanded = false
            },
            scrollState = scrollState,
            modifier = Modifier
                .exposedDropdownSize(true)
        ) {
            SortOrder.entries.forEach{ sortOrder ->
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.sort_by),
                            contentDescription = null
                        )
                    },
                    text = {
                        Text(
                            text = stringResource(id = sortOrder.textId),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onSelected(sortOrder)
                        sortMenuExpanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}

@Preview
@Composable
fun SortMenuPreview(){
    EShopEffectiveMobileTheme {
        SortDropDown()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    ){

        BasicTextField(
            value = value,
            modifier = modifier,
            onValueChange = onValueChange,
            decorationBox = @Composable { innerTextField ->
                Row {
                    Row(
                        modifier = Modifier
                            .wrapContentWidth()
                            .clickable { },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.sort_by),
                            contentDescription = null
                        )
                        innerTextField()
                        Icon(
                            painter = painterResource(id = R.drawable.down_arrow),
                            contentDescription = null
                        )
                }}
            }
        )
}