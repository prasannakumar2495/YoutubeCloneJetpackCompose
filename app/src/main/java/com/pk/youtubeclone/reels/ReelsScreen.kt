package com.pk.youtubeclone.reels

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pk.youtubeclone.commonComponents.CustomBoldText
import com.pk.youtubeclone.commonComponents.CustomBottomNavigationSheet
import com.pk.youtubeclone.modelclasses.dummyNavigationItems
import com.pk.youtubeclone.modelclasses.dummyReelsDetails
import com.pk.youtubeclone.navigations.NavigationRoutes
import com.pk.youtubeclone.posts.PostScreen

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ReelsScreen(navController: NavHostController, displayPostBottomSheet: MutableState<Boolean>) {
	val selectedNavigation = remember {
		mutableIntStateOf(1)
	}
	//TODO => Need to update this value
	val isReelPaused = remember {
		mutableStateOf(false)
	}
	val pagerState = rememberPagerState(initialPage = 0, pageCount = { dummyReelsDetails.size })
	Scaffold(
		topBar = {
			if (isReelPaused.value)
				TopAppBar(
					title = {
						CustomBoldText(
							text = "Shorts",
							textSize = 20.sp,
							textColor = Color.White
						)
					},
					actions = {
						IconButton(onClick = { /*TODO*/ }) {
							Icon(
								imageVector = Icons.Filled.Search,
								contentDescription = null,
								tint = Color.White
							)
						}
						IconButton(onClick = { /*TODO*/ }) {
							Icon(
								imageVector = Icons.Filled.Call, contentDescription = null,
								tint = Color.White
							)
						}
						IconButton(onClick = { /*TODO*/ }) {
							Icon(
								imageVector = Icons.Filled.MoreVert, contentDescription = null,
								tint = Color.White
							)
						}
					},
					colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
				)
		},
		bottomBar = {
			val navigationItemsData = remember {
				dummyNavigationItems
			}
			CustomBottomNavigationSheet(
				navigationItems = navigationItemsData,
				selectedItem = selectedNavigation.intValue
			) { position, name ->
				selectedNavigation.intValue = position
				when (name) {
					NavigationRoutes.Home.name -> navController.navigate(NavigationRoutes.Home.name)
					NavigationRoutes.Reels.name -> navController.navigate(NavigationRoutes.Reels.name)
					NavigationRoutes.Post.name -> displayPostBottomSheet.value = true
					NavigationRoutes.Subscription.name -> navController.navigate(
						NavigationRoutes.Subscription.name
					)
					
					NavigationRoutes.Profile.name -> navController.navigate(NavigationRoutes.Profile.name)
				}
			}
		}) { paddingValues ->
		VerticalPager(state = pagerState) {
			CustomReelComposable(paddingValues, pagerState, dummyReelsDetails[it])
		}
		if (displayPostBottomSheet.value)
			PostScreen(
				navController = navController,
				displayPostBottomSheet = displayPostBottomSheet
			)
	}
}