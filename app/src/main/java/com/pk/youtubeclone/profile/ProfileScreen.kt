package com.pk.youtubeclone.profile

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pk.youtubeclone.commonComponents.CustomBoldText
import com.pk.youtubeclone.navigations.NavigationRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
	navController: NavHostController,
	displayPostBottomSheet: MutableState<Boolean>,
	selectedNavigation: MutableIntState,
	displayProfileBottomSheet: MutableState<Boolean>,
	bottomSheetState: SheetState,
) {
	CustomBoldText(text = NavigationRoutes.Profile.name, textSize = 32.sp, textColor = Color.Black)
}