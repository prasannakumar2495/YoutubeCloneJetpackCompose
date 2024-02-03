package com.pk.youtubeclone.navigations

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pk.youtubeclone.home.HomeScreen
import com.pk.youtubeclone.library.LibraryScreen
import com.pk.youtubeclone.reels.ReelsScreen
import com.pk.youtubeclone.splash.SplashScreen
import com.pk.youtubeclone.subscriptions.SubscriptionScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YoutubeNavigationCenter(
	displayPostBottomSheet: MutableState<Boolean>,
	selectedNavigation: MutableIntState,
	displayProfileBottomSheet: MutableState<Boolean>,
	bottomSheetState: SheetState,
) {
	val navController = rememberNavController()
	NavHost(navController = navController, startDestination = NavigationRoutes.Splash.name) {
		composable(route = NavigationRoutes.Splash.name) {
			SplashScreen(navController = navController)
		}
		composable(route = NavigationRoutes.Home.name) {
			HomeScreen(
				navController = navController,
				displayPostBottomSheet = displayPostBottomSheet,
				selectedNavigation, displayProfileBottomSheet, bottomSheetState
			)
		}
		composable(route = NavigationRoutes.Reels.name) {
			ReelsScreen(
				navController = navController,
				displayPostBottomSheet = displayPostBottomSheet
			)
		}
		composable(route = NavigationRoutes.Subscription.name) {
			SubscriptionScreen(
				navController = navController,
				displayPostBottomSheet = displayPostBottomSheet
			)
		}
		composable(route = NavigationRoutes.Library.name) {
			LibraryScreen(
				navController = navController,
				displayPostBottomSheet = displayPostBottomSheet
			)
		}
	}
}