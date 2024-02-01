package com.pk.youtubeclone.reels

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.pk.youtubeclone.commonComponents.AnalyticsButtons
import com.pk.youtubeclone.commonComponents.CircularImageComposable
import com.pk.youtubeclone.commonComponents.CustomBoldText
import com.pk.youtubeclone.commonComponents.CustomTextRegular
import com.pk.youtubeclone.modelclasses.ReelsDetails
import com.pk.youtubeclone.ui.theme.almostBlack

/**
 * This composable is about the Reel UI.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomReelComposable(
	paddingValues: PaddingValues = PaddingValues(),
	pagerState: PagerState,
	reelsDetails: ReelsDetails,
) {
	Box(
		modifier = Modifier
			.background(Color.Gray)
			.padding(paddingValues)
			.clickable {},
		contentAlignment = Alignment.BottomStart
	) {
		AsyncImage(
			model = reelsDetails.channelImage,
			contentDescription = reelsDetails.reelDescription,
			modifier = Modifier.fillMaxSize(),
			contentScale = ContentScale.FillBounds
		)
		/**
		 * Below we have the code to display the various options on the video.
		 */
		ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
			val (reelInformation, reelAnalytics) = createRefs()
			//Creator and Reels details
			ConstraintLayout(modifier = Modifier
				.constrainAs(reelInformation) {
					start.linkTo(parent.start)
					bottom.linkTo(parent.bottom)
				}
				.padding(end = 8.dp))
			{
				val (
					channelImage, channelName, subscribeButton,
					reelDescription, reelSong,
				) = createRefs()
				//TODO => Need to update with user channel logo
				CircularImageComposable(
					imageUrl = reelsDetails.channelImage,
					modifier = Modifier.constrainAs(channelImage) {
						start.linkTo(parent.start)
					})
				CustomBoldText(text = reelsDetails.channelName,
					textSize = 12.sp,
					textColor = Color.White,
					modifier = Modifier.constrainAs(channelName) {
						start.linkTo(channelImage.end)
						top.linkTo(channelImage.top)
						bottom.linkTo(channelImage.bottom)
					})
				Button(
					onClick = { /*TODO*/ },
					modifier = Modifier
						.padding(start = 8.dp)
						.constrainAs(subscribeButton) {
							start.linkTo(channelName.end)
							top.linkTo(channelName.top)
							bottom.linkTo(channelName.bottom)
						},
					colors = ButtonDefaults.buttonColors(containerColor = Color.White),
					contentPadding = PaddingValues(horizontal = 12.dp)
				) {
					CustomTextRegular(
						text = if (reelsDetails.isSubscribed) "Subscribed" else "Subscribe",
						textSize = 12.sp,
						textColor = almostBlack
					)
				}
				CustomTextRegular(
					text = reelsDetails.reelDescription ?: "",
					textSize = 12.sp,
					textColor = Color.White,
					modifier = Modifier
						.constrainAs(reelDescription) {
							top.linkTo(channelImage.bottom)
							start.linkTo(channelImage.start)
						}
						.padding(horizontal = 8.dp, vertical = 4.dp)
				)
				CustomTextRegular(
					text = reelsDetails.reelSong ?: "", textSize = 12.sp, textColor = Color.White,
					modifier = Modifier
						.constrainAs(reelSong) {
							top.linkTo(reelDescription.bottom)
							start.linkTo(channelImage.start)
						}
						.padding(horizontal = 8.dp, vertical = 4.dp)
				)
			}
			//Reel analytics
			Column(
				modifier = Modifier
					.constrainAs(reelAnalytics) {
						bottom.linkTo(parent.bottom)
						end.linkTo(parent.end)
					}
					.wrapContentSize(),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				AnalyticsButtons(
					icon = Icons.Filled.ThumbUp,
					text = reelsDetails.numberOfLikes.toString(),
					textSize = 12.sp,
					textColor = Color.White
				) {}
				AnalyticsButtons(
					icon = Icons.Filled.ThumbUp,
					text = "Dislike",
					textSize = 12.sp,
					textColor = Color.White
				) {}
				AnalyticsButtons(
					icon = Icons.Filled.Email,
					text = reelsDetails.numberOfComments.toString(),
					textSize = 12.sp,
					textColor = Color.White
				) {}
				
				AnalyticsButtons(
					icon = Icons.Filled.Send,
					text = "Share",
					textSize = 12.sp,
					textColor = Color.White
				) {}
				AnalyticsButtons(
					icon = Icons.Filled.PlayArrow,
					text = "Remix",
					textSize = 12.sp,
					textColor = Color.White
				) {}
				
				IconButton(onClick = { /*TODO*/ }) {
					AsyncImage(
						model = reelsDetails.channelImage,
						contentDescription = reelsDetails.reelDescription,
						modifier = Modifier
							.height(50.dp)
							.width(50.dp),
						contentScale = ContentScale.Fit
					)
				}
			}
		}
	}
}