package com.pk.youtubeclone.commonComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.media3.exoplayer.ExoPlayer
import coil.compose.rememberAsyncImagePainter
import com.pk.youtubeclone.BulletPoint
import com.pk.youtubeclone.EMPTY
import com.pk.youtubeclone.R
import com.pk.youtubeclone.SampleImageURL1
import com.pk.youtubeclone.UserEmailID
import com.pk.youtubeclone.UserFullName
import com.pk.youtubeclone.modelclasses.BottomNavigationItems
import com.pk.youtubeclone.modelclasses.ProfileDetails
import com.pk.youtubeclone.modelclasses.VideoDetails
import com.pk.youtubeclone.modelclasses.dummyVideoDetails
import com.pk.youtubeclone.navigations.NavigationRoutes
import com.pk.youtubeclone.ui.theme.almostBlack
import com.pk.youtubeclone.ui.theme.customBlue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppLogo(modifier: Modifier) {
	Image(
		painter = painterResource(id = R.drawable.youtube),
		contentDescription = null,
		modifier = modifier
	)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopAppBar(
	profileImageUrl: String = EMPTY,
	backGroundColor: Color = almostBlack,
	clickOnProfileImage: () -> Unit = {},
	clickOnSearchButton: () -> Unit = {},
	clickOnNotificationButton: () -> Unit = {},
	clickOnScreenCastButton: () -> Unit = {},
) {
	TopAppBar(
		title = {
			Row(verticalAlignment = Alignment.CenterVertically) {
				Image(
					painter = painterResource(id = R.drawable.youtube),
					contentDescription = stringResource(id = R.string.youtube),
					modifier = Modifier
						.height(60.dp)
						.width(60.dp)
						.padding(8.dp)
				)
				
				CustomBoldText(
					text = stringResource(id = R.string.youtube),
					textSize = 16.sp,
					textColor = Color.White
				)
			}
		},
		actions = {
			IconButton(onClick = clickOnScreenCastButton) {
				Icon(
					painter = painterResource(id = R.drawable.ic_screen_cast),
					contentDescription = stringResource(R.string.click_to_screen_cast),
					tint = Color.White
				)
			}
			BadgedBox(badge = {
				Badge {
					Text(
						text = "12",
						color = Color.White,
					)
				}
			}) {
				Icon(
					imageVector = Icons.Outlined.Notifications,
					contentDescription = stringResource(R.string.click_to_view_notifications),
					tint = Color.White,
					modifier = Modifier.clickable(onClick = clickOnNotificationButton)
				)
			}
			IconButton(onClick = clickOnSearchButton) {
				Icon(
					imageVector = Icons.Outlined.Search,
					contentDescription = stringResource(R.string.click_to_search_anything),
					tint = Color.White
				)
			}
			CircularImageComposable(
				imageUrl = profileImageUrl,
				clickOnImage = clickOnProfileImage
			)
		},
		colors = TopAppBarDefaults.topAppBarColors(containerColor = backGroundColor)
	)
}

@Composable
fun VideoAndTitleComposable(
	clickOnChannelImage: () -> Unit = {},
	videoDetails: VideoDetails = dummyVideoDetails[0],
) {
	Column(verticalArrangement = Arrangement.Center) {
		VideoPlayer(onVideoClick = {}, onAudioButtonClick = {}, onSubtitleButtonClick = {})
		Row(
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier.fillMaxWidth()
		) {
			Row(
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Start,
				modifier = Modifier.weight(1f)
			) {
				CircularImageComposable(
					imageUrl = videoDetails.channelImageUrl,
					clickOnImage = clickOnChannelImage
				)
				Column {
					CustomTextRegular(
						text = videoDetails.videoTitle,
						textSize = 16.sp,
						textColor = Color.White
					)
					CustomTextThin(
						text = videoDetails.channelName + BulletPoint +
								videoDetails.numberOfViews + BulletPoint +
								videoDetails.uploadedTime,
						textSize = 12.sp,
						textColor = Color.White
					)
				}
			}
			IconButton(onClick = { /*TODO*/ }) {
				Icon(
					imageVector = Icons.Rounded.MoreVert,
					contentDescription = "Three dots",
					tint = Color.White
				)
			}
		}
	}
}

@Composable
fun CircularImageComposable(
	imageUrl: String,
	modifier: Modifier = Modifier,
	clickOnImage: () -> Unit = {},
) {
	Image(
		painter = rememberAsyncImagePainter(
			model = imageUrl, placeholder = painterResource(
				id = R.drawable.ic_launcher_background
			)
		),
		contentDescription = EMPTY,
		modifier = modifier
			.height(50.dp)
			.width(50.dp)
			.clickable(onClick = clickOnImage)
			.padding(8.dp)
			.clip(shape = CircleShape),
		contentScale = ContentScale.FillBounds
	)
}

@Composable
fun CustomChips(
	modifier: Modifier = Modifier,
	chipName: String = EMPTY,
	textColor: Color = Color.White,
	textSize: TextUnit = 12.sp,
) {
	Card(
		colors = CardDefaults.cardColors(containerColor = almostBlack),
		modifier = modifier,
		elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
	) {
		CustomTextRegular(
			text = chipName,
			textSize = textSize,
			textColor = textColor,
			modifier = Modifier.padding(8.dp)
		)
	}
}

@Composable
fun CustomBottomNavigationSheet(
	navigationItems: List<BottomNavigationItems>,
	selectedItem: Int,
	onItemClick: (Int, String) -> Unit,
) {
	NavigationBar(containerColor = Color.Black) {
		navigationItems.forEach {
			NavigationBarItem(
				selected = selectedItem == it.position,
				onClick = { onItemClick(it.position, it.name) },
				icon = {
					if (selectedItem != it.position)
						Icon(
							imageVector = it.iconNotSelected,
							contentDescription = it.name,
							tint = Color.White,
							modifier = if (it.name == NavigationRoutes.Post.name) Modifier.size(50.dp) else Modifier
						)
					else
						Icon(
							imageVector = it.iconSelected,
							contentDescription = it.name,
							tint = Color.White,
							modifier = if (it.name == NavigationRoutes.Post.name) Modifier.size(50.dp) else Modifier
						)
				},
				label = {
					if (it.name != NavigationRoutes.Post.name)
						CustomTextRegular(
							text = it.name,
							textSize = 8.sp,
							textColor = Color.White
						)
				},
				colors = NavigationBarItemDefaults.colors(
					indicatorColor = Color.Transparent
				)
			)
		}
	}
}

@Composable
fun VideoPlayer(
	onVideoClick: () -> Unit,
	onAudioButtonClick: () -> Unit,
	onSubtitleButtonClick: () -> Unit,
) {
	val context = LocalContext.current
	val exoPlayer = remember {
		ExoPlayer.Builder(context).build().apply {
			prepare()
		}
	}
	ConstraintLayout {
		val (muteUnMuteIcon, subtitleIcon, videoPlayer) = createRefs()
		//TODO => To work with YouTube video, uncomment the below code.
		/**
		 * AndroidView(factory = {
		 * 			PlayerView(it).apply {
		 * 				player = exoPlayer.apply {
		 * 					//setMediaItem(MediaItem.fromUri("https://www.youtube.com/watch?v=E_8LHkn4g-Q"))
		 * 				}
		 * 			}
		 * 		}, modifier = Modifier
		 * 			.fillMaxWidth()
		 * 			.height(200.dp)
		 * 			.padding(8.dp)
		 * 			.constrainAs(videoPlayer) { top.linkTo(parent.top) }
		 * 			.clickable { onVideoClick() })
		 */
		Image(painter = painterResource(id = R.drawable.youtube), contentDescription = null,
			modifier = Modifier
				.fillMaxWidth()
				.height(200.dp)
				.padding(8.dp)
				.constrainAs(videoPlayer) { top.linkTo(parent.top) }
				.clickable { onVideoClick() })
		IconButton(
			onClick = { onAudioButtonClick() },
			modifier = Modifier.constrainAs(muteUnMuteIcon) { end.linkTo(videoPlayer.end) }) {
			Icon(
				painter = painterResource(id = R.drawable.ic_volume_off),
				contentDescription = null,
				tint = Color.White
			)
		}
		IconButton(
			onClick = { onSubtitleButtonClick() },
			modifier = Modifier.constrainAs(subtitleIcon) {
				end.linkTo(videoPlayer.end)
				top.linkTo(muteUnMuteIcon.bottom)
			}) {
			Icon(
				painter = painterResource(id = R.drawable.ic_subtitles),
				contentDescription = null,
				tint = Color.White
			)
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomDrawer(
	listOfProfileItems: List<List<ProfileDetails>>,
	displayBottomSheet: MutableState<Boolean>,
	bottomSheetState: SheetState,
	scope: CoroutineScope,
) {
	val profileItemsData = remember {
		listOfProfileItems
	}
	ModalBottomSheet(
		onDismissRequest = {
			displayBottomSheet.value = false
			scope.launch {
				bottomSheetState.hide()
			}
		},
		containerColor = Color.Black,
		shape = RectangleShape,
		dragHandle = {},
	) {
		//Close Button
		IconButton(onClick = {
			displayBottomSheet.value = false
			scope.launch {
				bottomSheetState.hide()
			}
		}, modifier = Modifier.padding(8.dp)) {
			Icon(imageVector = Icons.Filled.Close, contentDescription = null, tint = Color.Gray)
		}
		//User Details
		ListItem(
			leadingContent = {
				CircularImageComposable(imageUrl = SampleImageURL1)
			},
			trailingContent = {
				Icon(
					imageVector = Icons.Filled.KeyboardArrowRight,
					contentDescription = null,
					tint = Color.Gray
				)
			},
			overlineContent = {
				CustomTextRegular(
					text = UserFullName,
					textSize = 14.sp,
					textColor = Color.White
				)
			},
			headlineContent = {
				CustomTextRegular(
					text = UserEmailID,
					textSize = 14.sp,
					textColor = Color.White
				)
			},
			supportingContent = {
				CustomTextRegular(
					text = "Manage your Google Account",
					textSize = 10.sp,
					textColor = customBlue,
					modifier = Modifier.padding(top = 8.dp)
				)
			},
			colors = ListItemDefaults.colors(containerColor = Color.Black)
		)
		profileItemsData.forEachIndexed { index, profileDetails ->
			val currentProfileData = remember {
				profileDetails
			}
			LazyColumn(verticalArrangement = Arrangement.spacedBy((-12).dp)) {
				items(
					count = currentProfileData.size,
					key = { currentProfileData[it].id }) { position ->
					ListItem(
						headlineContent = {
							currentProfileData[position].headLineText?.let {
								CustomTextRegular(
									text = it,
									textSize = 12.sp,
									textColor = Color.White
								)
							}
						},
						leadingContent = {
							currentProfileData[position].leadingIcon?.let {
								Icon(
									imageVector = it,
									contentDescription = null,
									tint = Color.Gray
								)
							}
						},
						colors = ListItemDefaults.colors(containerColor = Color.Black)
					)
				}
			}
			if (profileItemsData.lastIndex != index)
				Divider()
		}
		Spacer(modifier = Modifier.height(20.dp))
		Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
			CustomTextRegular(
				text = "Privacy Policy $BulletPoint Terms of Service",
				textSize = 10.sp,
				textColor = Color.White,
				modifier = Modifier.padding(12.dp)
			)
		}
	}
}

@Composable
fun AnalyticsButtons(
	icon: ImageVector,
	text: String,
	textSize: TextUnit,
	textColor: Color,
	onButtonClick: () -> Unit,
) {
	Column(horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier.clickable { onButtonClick() }
	) {
		Icon(
			imageVector = icon,
			contentDescription = null,
			modifier = Modifier
				.padding(6.dp)
				.size(30.dp),
			tint = Color.White
		)
		CustomTextRegular(text = text, textSize = textSize, textColor = textColor)
	}
}