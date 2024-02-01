package com.pk.youtubeclone.posts

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pk.youtubeclone.commonComponents.CustomBoldText
import com.pk.youtubeclone.navigations.NavigationRoutes

@Composable
fun PostScreen(navController: NavHostController) {
	CustomBoldText(text = NavigationRoutes.Post.name, textSize = 32.sp, textColor = Color.Black)
}