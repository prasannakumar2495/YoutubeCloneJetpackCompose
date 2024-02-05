package com.pk.youtubeclone.commonComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.pk.youtubeclone.EMPTY
import com.pk.youtubeclone.R

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
fun AppLogo(modifier: Modifier) {
	Image(
		painter = painterResource(id = R.drawable.youtube),
		contentDescription = null,
		modifier = modifier
	)
}