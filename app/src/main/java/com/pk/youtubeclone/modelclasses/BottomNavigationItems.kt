package com.pk.youtubeclone.modelclasses

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import com.pk.youtubeclone.navigations.NavigationRoutes

@Stable
data class BottomNavigationItems(
	val position: Int,
	val name: String,
	val iconNotSelected: ImageVector,
	val iconSelected: ImageVector,
)

val dummyNavigationItems = listOf(
	BottomNavigationItems(
		0,
		NavigationRoutes.Home.name,
		Icons.Outlined.Home,
		Icons.Filled.Home
	),
	BottomNavigationItems(
		1,
		NavigationRoutes.Reels.name,
		Icons.Outlined.Search,
		Icons.Filled.Search
	),
	BottomNavigationItems(
		2,
		NavigationRoutes.Post.name,
		Icons.Outlined.Add,
		Icons.Filled.Add
	),
	BottomNavigationItems(
		3,
		NavigationRoutes.Subscription.name,
		Icons.Outlined.Share,
		Icons.Filled.Share
	),
	BottomNavigationItems(
		4,
		NavigationRoutes.Profile.name,
		Icons.Outlined.Person,
		Icons.Filled.Person
	)
)