package com.pk.youtubeclone.profile

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.pk.youtubeclone.BulletPoint
import com.pk.youtubeclone.SampleImageURL1
import com.pk.youtubeclone.UserChannelName
import com.pk.youtubeclone.UserFullName
import com.pk.youtubeclone.commonComponents.CircularImageComposable
import com.pk.youtubeclone.commonComponents.CommonTopAppBar
import com.pk.youtubeclone.commonComponents.CustomBoldText
import com.pk.youtubeclone.commonComponents.CustomBottomNavigationSheet
import com.pk.youtubeclone.commonComponents.CustomTextRegular
import com.pk.youtubeclone.commonComponents.OnlyVideoPlayer
import com.pk.youtubeclone.modelclasses.completeProfileData
import com.pk.youtubeclone.modelclasses.dummyNavigationItems
import com.pk.youtubeclone.modelclasses.dummyVideoDetails
import com.pk.youtubeclone.navigations.NavigationRoutes
import com.pk.youtubeclone.sampleImages
import com.pk.youtubeclone.ui.theme.almostBlack
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
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
		LazyColumn(
			modifier = Modifier
				.fillMaxWidth()
				.padding(it)
				.background(Color.Black)
		) {
			item {
				//Displaying user profile image, user name and user ID
				ConstraintLayout {
					val (
						profileImage, userName,
						userEmailId,
					) = createRefs()
					CircularImageComposable(
						imageUrl = sampleImages.random(),
						modifier = Modifier
							.constrainAs(profileImage) {
								top.linkTo(parent.top)
								start.linkTo(parent.start)
							}
							.height(80.dp)
							.width(80.dp)
					)
					CustomBoldText(
						text = UserFullName,
						textSize = 16.sp,
						textColor = Color.White,
						modifier = Modifier
							.constrainAs(userName) {
								top.linkTo(profileImage.top)
								start.linkTo(profileImage.end)
							}
							.padding(top = 8.dp)
					)
					CustomTextRegular(text = "$UserChannelName $BulletPoint View Channel >",
						textSize = 12.sp,
						textColor = Color.White,
						modifier = Modifier.constrainAs(userEmailId) {
							top.linkTo(userName.bottom)
							start.linkTo(profileImage.end)
						})
				}
				//Displaying the list of (Switch account,Google Account, Turn on Incognito)
				LazyRow(modifier = Modifier.padding(horizontal = 8.dp)) {
					items(count = 20) {
						Card(
							colors = CardDefaults.cardColors(containerColor = almostBlack),
							elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
							modifier = Modifier.padding(4.dp)
						) {
							Row(
								verticalAlignment = Alignment.CenterVertically,
								modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
							) {
								Icon(
									imageVector = Icons.Filled.Person,
									contentDescription = null,
									tint = Color.White
								)
								CustomTextRegular(
									text = "Switch account",
									textSize = 12.sp,
									textColor = Color.White
								)
							}
						}
					}
				}
				//Displaying History Videos
				ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
					val (sectionTitle, viewAll, videos) = createRefs()
					CustomBoldText(
						text = "History",
						textSize = 14.sp,
						textColor = Color.White,
						modifier = Modifier.constrainAs(sectionTitle) {
							start.linkTo(parent.start)
						})
					CustomTextRegular(
						text = "View all",
						textSize = 12.sp,
						textColor = Color.White,
						modifier = Modifier
							.border(
								width = (0.25).dp,
								color = Color.White,
								shape = RoundedCornerShape(8.dp)
							)
							.padding(vertical = 2.dp, horizontal = 8.dp)
							.constrainAs(viewAll) {
								end.linkTo(parent.end)
							})
					LazyRow(modifier = Modifier.constrainAs(videos) {
						top.linkTo(sectionTitle.bottom)
						start.linkTo(parent.start)
					}) {
						items(items = dummyVideoDetails, key = { videoDetails ->
							videoDetails.id
						}) { data ->
							OnlyVideoPlayer(
								modifier = Modifier
									.width(100.dp)
									.height(50.dp),
								onVideoClick = { /*TODO*/ },
								onSubtitleButtonClick = { /*TODO*/ },
								videoDetails = data
							)
						}
					}
				}
				Row(
					horizontalArrangement = Arrangement.SpaceBetween,
					modifier = Modifier
						.fillMaxWidth()
						.padding(vertical = 4.dp, horizontal = 8.dp)
				) {
					CustomBoldText(text = "Playlist", textSize = 14.sp, textColor = Color.White)
					CustomTextRegular(
						text = "View all", textSize = 12.sp, textColor = Color.White,
						modifier = Modifier
							.border(
								width = 0.5.dp,
								color = Color.White,
								shape = RoundedCornerShape(8.dp)
							)
							.padding(horizontal = 8.dp, vertical = 2.dp)
					)
				}
				LazyRow {
					items(items = dummyVideoDetails,
						key = { videoDetails -> videoDetails.id }) { data ->
						OnlyVideoPlayer(
							onVideoClick = { /*TODO*/ },
							onSubtitleButtonClick = { /*TODO*/ },
							videoDetails = data,
							modifier = Modifier
								.width(100.dp)
								.height(50.dp)
						)
					}
				}
				//Display other list of content
				val currentProfileData = remember {
					completeProfileData
				}
				currentProfileData.forEachIndexed { index, profileDetails ->
					Column {
						profileDetails.forEachIndexed { _, details ->
							ListItem(
								headlineContent = {
									details.headLineText?.let { headLine ->
										CustomTextRegular(
											text = headLine,
											textSize = 12.sp,
											textColor = Color.White
										)
									}
								},
								leadingContent = {
									details.leadingIcon?.let { icon ->
										Icon(
											imageVector = icon,
											contentDescription = null,
											tint = Color.Gray
										)
									}
								},
								colors = ListItemDefaults.colors(containerColor = Color.Black)
							)
						}
					}
					if (completeProfileData.lastIndex != index)
						Divider()
				}
			}
		}
	}
}