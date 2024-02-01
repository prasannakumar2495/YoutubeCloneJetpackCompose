package com.pk.youtubeclone.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pk.youtubeclone.home.HomeScreen
import com.pk.youtubeclone.library.LibraryScreen
import com.pk.youtubeclone.posts.PostScreen
import com.pk.youtubeclone.reels.ReelsScreen
import com.pk.youtubeclone.splash.SplashScreen
import com.pk.youtubeclone.subscriptions.SubscriptionScreen

@Composable
fun YoutubeNavigationCenter() {
	val navController = rememberNavController()
	NavHost(navController = navController, startDestination = NavigationRoutes.Splash.name) {
		composable(route = NavigationRoutes.Splash.name) {
			SplashScreen(navController = navController)
		}
		composable(route = NavigationRoutes.Home.name) {
			HomeScreen(navController = navController)
		}
		composable(route = NavigationRoutes.Reels.name) {
			ReelsScreen(navController = navController)
		}
		composable(route = NavigationRoutes.Post.name) {
			PostScreen(navController = navController)
		}
		composable(route = NavigationRoutes.Subscription.name) {
			SubscriptionScreen(navController = navController)
		}
		composable(route = NavigationRoutes.Library.name) {
			LibraryScreen(navController = navController)
		}
	}
}