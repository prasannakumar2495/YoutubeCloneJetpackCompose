package com.pk.youtubeclone.home

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pk.youtubeclone.SampleImageURL1
import com.pk.youtubeclone.commonComponents.CommonTopAppBar
import com.pk.youtubeclone.commonComponents.CustomBottomNavigationSheet
import com.pk.youtubeclone.commonComponents.CustomChips
import com.pk.youtubeclone.commonComponents.ProfileBottomDrawer
import com.pk.youtubeclone.commonComponents.VideoAndTitleComposable
import com.pk.youtubeclone.modelclasses.VideoDetails
import com.pk.youtubeclone.modelclasses.completeProfileData
import com.pk.youtubeclone.modelclasses.dummyCategories
import com.pk.youtubeclone.modelclasses.dummyNavigationItems
import com.pk.youtubeclone.modelclasses.dummyVideoDetails
import com.pk.youtubeclone.navigations.NavigationRoutes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
	navController: NavHostController,
	displayPostBottomSheet: MutableState<Boolean>,
	selectedNavigation: MutableIntState,
	displayProfileBottomSheet: MutableState<Boolean>,
	bottomSheetState: SheetState,
) {
	val context = LocalContext.current
	val scope = rememberCoroutineScope()
	Scaffold(
		topBar = {
			CommonTopAppBar(
				profileImageUrl = SampleImageURL1,
				backGroundColor = Color.Black,
				clickOnProfileImage = {
					displayProfileBottomSheet.value = true
					scope.launch {
						bottomSheetState.expand()
					}
				},
				clickOnSearchButton = {
					Toast.makeText(context, "SEARCH", Toast.LENGTH_SHORT).show()
				},
				clickOnNotificationButton = {
					Toast.makeText(context, "NOTIFICATION", Toast.LENGTH_SHORT).show()
				},
				clickOnScreenCastButton = {
					Toast.makeText(context, "CAST", Toast.LENGTH_SHORT).show()
				})
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
					NavigationRoutes.Post.name -> {
						displayPostBottomSheet.value = true
						navController.navigate(NavigationRoutes.Post.name)
					}
					
					NavigationRoutes.Subscription.name -> navController.navigate(
						NavigationRoutes.Subscription.name
					)
					
					NavigationRoutes.Library.name -> navController.navigate(NavigationRoutes.Library.name)
				}
			}
		}) {
		Surface(color = Color.Black, modifier = Modifier.padding(it)) {
			Column {
				HomeScreenCategoriesList()
				HomeScreenVideoList(
					listOfVideo = dummyVideoDetails, context
				)
				if (displayProfileBottomSheet.value)
					ProfileBottomDrawer(
						completeProfileData,
						displayProfileBottomSheet,
						bottomSheetState,
						scope
					)
			}
		}
	}
}

@Composable
fun HomeScreenCategoriesList() {
	val categoriesData = remember {
		dummyCategories
	}
	LazyRow(modifier = Modifier.padding(start = 12.dp)) {
		items(categoriesData.size, key = { categoriesData[it].id }) {
			CustomChips(
				chipName = categoriesData[it].categoryName,
				textColor = Color.White,
				textSize = 12.sp,
				modifier = Modifier.padding(4.dp)
			)
		}
	}
}

@Composable
fun HomeScreenVideoList(listOfVideo: List<VideoDetails>, context: Context) {
	val listOfVideoData = remember {
		listOfVideo
	}
	LazyColumn(modifier = Modifier.padding(top = 4.dp)) {
		items(count = listOfVideoData.size, key = { listOfVideoData[it].id }) {
			VideoAndTitleComposable(videoDetails = listOfVideoData[it], clickOnChannelImage = {
				Toast.makeText(context, "Click on video $it", Toast.LENGTH_SHORT)
					.show()
			})
		}
	}
}
