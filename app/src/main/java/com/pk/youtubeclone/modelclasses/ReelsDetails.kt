package com.pk.youtubeclone.modelclasses

import com.pk.youtubeclone.SampleDescription
import com.pk.youtubeclone.SampleImageURL1
import com.pk.youtubeclone.SampleImageURL2
import com.pk.youtubeclone.SampleImageURL3
import com.pk.youtubeclone.SampleSong

data class ReelsDetails(
	val id: Int,
	val channelImage: String,
	val channelName: String,
	val isSubscribed: Boolean = false,
	val reelDescription: String? = null,
	val reelSong: String? = null,
	val numberOfLikes: Long = 0,
	val numberOfComments: Long = 0,
)

val dummyReelsDetails = listOf(
	ReelsDetails(
		id = 1, channelName = "Channel 1",
		channelImage = SampleImageURL1, isSubscribed = true,
		reelDescription = SampleDescription,
		reelSong = SampleSong, numberOfLikes = 102,
		numberOfComments = 12
	),
	ReelsDetails(
		id = 2, channelName = "Channel 2",
		channelImage = SampleImageURL2, isSubscribed = false,
		reelDescription = SampleDescription,
		reelSong = SampleSong, numberOfLikes = 102,
		numberOfComments = 12
	),
	ReelsDetails(
		id = 3, channelName = "Channel 3",
		channelImage = SampleImageURL3, isSubscribed = true,
		reelDescription = SampleDescription,
		reelSong = SampleSong, numberOfLikes = 102,
		numberOfComments = 12
	),
	ReelsDetails(
		id = 4, channelName = "Channel 4",
		channelImage = SampleImageURL1, isSubscribed = true,
		reelDescription = SampleDescription,
		reelSong = SampleSong, numberOfLikes = 102,
		numberOfComments = 12
	),
	ReelsDetails(
		id = 5, channelName = "Channel 5",
		channelImage = SampleImageURL1, isSubscribed = false,
		reelDescription = SampleDescription,
		reelSong = SampleSong, numberOfLikes = 102,
		numberOfComments = 12
	),
	ReelsDetails(
		id = 6, channelName = "Channel 6",
		channelImage = SampleImageURL1, isSubscribed = false,
		reelDescription = SampleDescription,
		reelSong = SampleSong, numberOfLikes = 102,
		numberOfComments = 12
	),
	ReelsDetails(
		id = 7, channelName = "Channel 7",
		channelImage = SampleImageURL1, isSubscribed = true,
		reelDescription = SampleDescription,
		reelSong = SampleSong, numberOfLikes = 102,
		numberOfComments = 12
	),
	ReelsDetails(
		id = 8, channelName = "Channel 8",
		channelImage = SampleImageURL1, isSubscribed = true,
		reelDescription = SampleDescription,
		reelSong = SampleSong, numberOfLikes = 102,
		numberOfComments = 12
	),
	ReelsDetails(
		id = 9, channelName = "Channel 9",
		channelImage = SampleImageURL1, isSubscribed = false,
		reelDescription = SampleDescription,
		reelSong = SampleSong, numberOfLikes = 102,
		numberOfComments = 12
	),
	ReelsDetails(
		id = 10, channelName = "Channel 10",
		channelImage = SampleImageURL1, isSubscribed = true,
		reelDescription = SampleDescription,
		reelSong = SampleSong, numberOfLikes = 102,
		numberOfComments = 12
	),
	ReelsDetails(
		id = 11, channelName = "Channel 11",
		channelImage = SampleImageURL1, isSubscribed = true,
		reelDescription = SampleDescription,
		reelSong = SampleSong, numberOfLikes = 102,
		numberOfComments = 12
	),
	ReelsDetails(
		id = 12, channelName = "Channel 12",
		channelImage = SampleImageURL1, isSubscribed = true,
		reelDescription = SampleDescription,
		reelSong = SampleSong, numberOfLikes = 102,
		numberOfComments = 12
	)
)