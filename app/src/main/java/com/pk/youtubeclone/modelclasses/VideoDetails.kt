package com.pk.youtubeclone.modelclasses

import android.net.Uri
import androidx.compose.runtime.Stable
import androidx.media3.common.MediaItem
import com.pk.youtubeclone.SampleImageURL1

@Stable
data class VideoDetails(
	val id: Int,
	val channelImageUrl: String,
	val videoUri: Uri?,
	val videoTitle: String,
	val channelName: String,
	val numberOfViews: Int,
	val uploadedTime: String,
	val mediaItem: MediaItem?,
)

val dummyVideoDetails = listOf(
	VideoDetails(
		1, SampleImageURL1, null, "This is the current video",
		"This is PK", 100000, "12", null
	),
	VideoDetails(
		2, SampleImageURL1, null, "This is the current video 2",
		"This is PK 2", 100000, "12", null
	),
	VideoDetails(
		3, SampleImageURL1, null, "This is the current video 3",
		"This is PK 3", 100000, "12", null
	),
	VideoDetails(
		4, SampleImageURL1, null, "This is the current video 4",
		"This is PK 4", 100000, "12", null
	),
	VideoDetails(
		5, SampleImageURL1, null, "This is the current video 5",
		"This is PK 5", 100000, "12", null
	),
	VideoDetails(
		6, SampleImageURL1, null, "This is the current video 6",
		"This is PK 5", 100000, "12", null
	),
	VideoDetails(
		7, SampleImageURL1, null, "This is the current video 7",
		"This is PK 7", 100000, "12", null
	),
	VideoDetails(
		8, SampleImageURL1, null, "This is the current video 8",
		"This is PK 8", 100000, "12", null
	),
	VideoDetails(
		9, SampleImageURL1, null, "This is the current video 9",
		"This is PK 9", 100000, "12", null
	), VideoDetails(
		923432, SampleImageURL1, null, "This is the current video 10",
		"This is PK 9", 100000, "12", null
	), VideoDetails(
		23549, SampleImageURL1, null, "This is the current video 11",
		"This is PK 9", 100000, "12", null
	), VideoDetails(
		235429, SampleImageURL1, null, "This is the current video 12",
		"This is PK 9", 100000, "12", null
	), VideoDetails(
		9467, SampleImageURL1, null, "This is the current video 13",
		"This is PK 9", 100000, "12", null
	), VideoDetails(
		5679, SampleImageURL1, null, "This is the current video 14",
		"This is PK 9", 100000, "12", null
	), VideoDetails(
		769, SampleImageURL1, null, "This is the current video 15",
		"This is PK 9", 100000, "12", null
	), VideoDetails(
		902, SampleImageURL1, null, "This is the current video 16",
		"This is PK 9", 100000, "12", null
	), VideoDetails(
		994, SampleImageURL1, null, "This is the current video 17",
		"This is PK 9", 100000, "12", null
	), VideoDetails(
		945, SampleImageURL1, null, "This is the current video 18",
		"This is PK 9", 100000, "12", null
	), VideoDetails(
		92345, SampleImageURL1, null, "This is the current video 19",
		"This is PK 9", 100000, "12", null
	), VideoDetails(
		94564674, SampleImageURL1, null, "This is the current video 20",
		"This is PK 9", 100000, "12", null
	)
)