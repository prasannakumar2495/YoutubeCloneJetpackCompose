package com.pk.youtubeclone.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pk.youtubeclone.commonComponents.CustomBoldText
import com.pk.youtubeclone.commonComponents.CustomTextRegular
import com.pk.youtubeclone.ui.theme.almostBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostScreen(navController: NavHostController, displayPostBottomSheet: MutableState<Boolean>) {
	if (displayPostBottomSheet.value)
		ModalBottomSheet(
			onDismissRequest = { displayPostBottomSheet.value = false },
			dragHandle = null,
			containerColor = almostBlack,
			shape = RoundedCornerShape(12.dp),
		) {
			Row(
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.fillMaxWidth()
					.padding(start = 12.dp, end = 12.dp, top = 12.dp)
			) {
				CustomBoldText(text = "Create", textSize = 18.sp, textColor = Color.White)
				IconButton(onClick = { displayPostBottomSheet.value = false }) {
					Icon(
						imageVector = Icons.Filled.Close,
						contentDescription = null,
						tint = Color.Gray
					)
				}
			}
			ListItem(
				headlineContent = {
					CustomTextRegular(
						text = "Create a Short",
						textSize = 14.sp,
						textColor = Color.White
					)
				},
				leadingContent = {
					Icon(imageVector = Icons.Filled.Search, contentDescription = null)
				},
				colors = ListItemDefaults.colors(containerColor = almostBlack)
			)
			ListItem(
				headlineContent = {
					CustomTextRegular(
						text = "Upload a video",
						textSize = 14.sp,
						textColor = Color.White
					)
				},
				leadingContent = {
					Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = null)
				},
				colors = ListItemDefaults.colors(containerColor = almostBlack)
			)
			ListItem(
				headlineContent = {
					CustomTextRegular(
						text = "Go live",
						textSize = 14.sp,
						textColor = Color.White
					)
				},
				leadingContent = {
					Icon(imageVector = Icons.Filled.Face, contentDescription = null)
				},
				colors = ListItemDefaults.colors(containerColor = almostBlack)
			)
			ListItem(
				headlineContent = {
					CustomTextRegular(
						text = "Create a post",
						textSize = 14.sp,
						textColor = Color.White
					)
				},
				leadingContent = {
					Icon(imageVector = Icons.Filled.Edit, contentDescription = null)
				},
				colors = ListItemDefaults.colors(containerColor = almostBlack)
			)
		}
}