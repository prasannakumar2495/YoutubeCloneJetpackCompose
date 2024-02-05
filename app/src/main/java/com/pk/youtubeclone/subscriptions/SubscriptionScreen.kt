package com.pk.youtubeclone.subscriptions

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
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
import com.pk.youtubeclone.commonComponents.CustomChannelImageNameComposable
import com.pk.youtubeclone.commonComponents.CustomChips
import com.pk.youtubeclone.commonComponents.VideoAndTitleComposable
import com.pk.youtubeclone.modelclasses.dummyCategories
import com.pk.youtubeclone.modelclasses.dummyChannelsDetails
import com.pk.youtubeclone.modelclasses.dummyNavigationItems
import com.pk.youtubeclone.modelclasses.dummyVideoDetails
import com.pk.youtubeclone.navigations.NavigationRoutes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionScreen(
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
					}
					
					NavigationRoutes.Subscription.name -> navController.navigate(
						NavigationRoutes.Subscription.name
					)
					
					NavigationRoutes.Profile.name -> navController.navigate(NavigationRoutes.Profile.name)
				}
			}
		}
	) {
		Column(
			modifier = Modifier
				.padding(it)
				.background(color = Color.Black)
		) {
			//Displaying the list channel images and there names
			LazyRow(modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)) {
				items(items = dummyChannelsDetails, key = { items -> items.id }) { channelDetails ->
					CustomChannelImageNameComposable(
						channelDetails.channelName,
						channelDetails.channelImage
					)
				}
			}
			//Displaying the list of categories
			LazyRow(modifier = Modifier.padding(top = 2.dp, bottom = 4.dp)) {
				items(items = dummyCategories, key = { categories ->
					categories.id
				}) { categoriesData ->
					CustomChips(
						modifier = Modifier.padding(horizontal = 2.dp),
						chipName = categoriesData.categoryName,
						textColor = Color.White,
						textSize = 14.sp
					)
				}
			}
			LazyColumn {
				items(items = dummyVideoDetails, key = { videoDetails ->
					videoDetails.id
				}) { videoData ->
					VideoAndTitleComposable(videoDetails = videoData)
				}
			}
		}
	}
}