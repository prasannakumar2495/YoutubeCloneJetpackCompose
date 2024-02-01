package com.pk.youtubeclone.modelclasses

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

data class ProfileDetails(
	val id: Int,
	val headLineText: String? = null,
	val leadingIcon: ImageVector? = null,
	val trailingIcon: ImageVector? = null,
)

val dummyTop3ProfileDetails = listOf(
	ProfileDetails(
		id = 1,
		leadingIcon = Icons.Filled.Person,
		headLineText = "Your Channel",
	),
	ProfileDetails(
		id = 2,
		leadingIcon = Icons.Filled.Search,
		headLineText = "Turn on Incognito",
	),
	ProfileDetails(
		id = 3,
		leadingIcon = Icons.Filled.AddCircle,
		headLineText = "Add Account",
	)
)
val dummy2ndProfileDetails = listOf(
	ProfileDetails(
		id = 5,
		leadingIcon = Icons.Filled.PlayArrow,
		headLineText = "Get YouTube Premium",
	),
	ProfileDetails(
		id = 6,
		leadingIcon = Icons.Filled.ThumbUp,
		headLineText = "Purchases and memberships",
	),
	ProfileDetails(
		id = 7,
		leadingIcon = Icons.Filled.Share,
		headLineText = "Time watched",
	),
	ProfileDetails(
		id = 8,
		leadingIcon = Icons.Filled.Person,
		headLineText = "Your data in YouTube",
	)
)
val dummy3rdProfileDetails = listOf(
	ProfileDetails(
		id = 10,
		leadingIcon = Icons.Filled.Settings,
		headLineText = "Settings",
	),
	ProfileDetails(
		id = 11,
		leadingIcon = Icons.Filled.List,
		headLineText = "Help & feedback",
	),
)
val dummy4thProfileDetails = listOf(
	ProfileDetails(
		id = 13,
		leadingIcon = Icons.Filled.Favorite,
		headLineText = "YouTube Studio",
	),
	ProfileDetails(
		id = 14,
		leadingIcon = Icons.Filled.Favorite,
		headLineText = "YouTube Music",
	),
	ProfileDetails(
		id = 15,
		leadingIcon = Icons.Filled.Favorite,
		headLineText = "YouTube Kids",
	)
)
val completeProfileData = listOf(
	dummyTop3ProfileDetails, dummy2ndProfileDetails,
	dummy3rdProfileDetails, dummy4thProfileDetails
)