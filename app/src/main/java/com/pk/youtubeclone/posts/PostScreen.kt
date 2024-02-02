package com.pk.youtubeclone.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pk.youtubeclone.commonComponents.CustomBoldText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostScreen(navController: NavHostController, displayPostBottomSheet: MutableState<Boolean>) {
	if (displayPostBottomSheet.value)
		ModalBottomSheet(
			onDismissRequest = { displayPostBottomSheet.value = false },
			dragHandle = null,
			containerColor = Color.Black
		) {
			Row(
				horizontalArrangement = Arrangement.SpaceBetween,
				modifier = Modifier.fillMaxWidth()
			) {
				CustomBoldText(text = "Create", textSize = 18.sp, textColor = Color.White)
				IconButton(onClick = { /*TODO*/ }) {
					Icon(
						imageVector = Icons.Filled.Close,
						contentDescription = null,
						tint = Color.Gray
					)
				}
			}
		}
}