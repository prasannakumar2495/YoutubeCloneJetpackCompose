package com.pk.youtubeclone.commonComponents

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

@Composable
fun CustomBoldText(
	text: String,
	textSize: TextUnit,
	textColor: Color,
	modifier: Modifier = Modifier,
) {
	Text(
		text = text,
		color = textColor,
		style = TextStyle(fontWeight = FontWeight.Bold, fontSize = textSize),
		modifier = modifier
	)
}

@Composable
fun CustomTextRegular(
	text: String,
	textSize: TextUnit,
	textColor: Color,
	modifier: Modifier = Modifier,
) {
	Text(
		modifier = modifier,
		text = text,
		color = textColor,
		style = TextStyle(fontWeight = FontWeight.Normal, fontSize = textSize),
	)
}

@Composable
fun CustomTextThin(
	text: String,
	textSize: TextUnit,
	textColor: Color,
	modifier: Modifier = Modifier,
) {
	Text(
		text = text,
		color = textColor,
		style = TextStyle(fontWeight = FontWeight.Thin, fontSize = textSize),
		modifier = modifier,
		maxLines = 1,
		overflow = TextOverflow.Ellipsis
	)
}