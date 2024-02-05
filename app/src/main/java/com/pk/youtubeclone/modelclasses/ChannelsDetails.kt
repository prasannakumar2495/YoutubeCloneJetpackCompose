package com.pk.youtubeclone.modelclasses

import com.pk.youtubeclone.sampleImages

data class ChannelsDetails(
	val id: Int,
	val channelName: String,
	val channelImage: String,
)

val dummyChannelsDetails = listOf(
	ChannelsDetails(id = 1, channelName = "Channel 1", channelImage = sampleImages.random()),
	ChannelsDetails(id = 2, channelName = "Channel 2", channelImage = sampleImages.random()),
	ChannelsDetails(id = 3, channelName = "Channel 3", channelImage = sampleImages.random()),
	ChannelsDetails(id = 4, channelName = "Channel 4", channelImage = sampleImages.random()),
	ChannelsDetails(id = 5, channelName = "Channel 5", channelImage = sampleImages.random()),
	ChannelsDetails(id = 6, channelName = "Channel 6", channelImage = sampleImages.random()),
	ChannelsDetails(id = 7, channelName = "Channel 7", channelImage = sampleImages.random()),
	ChannelsDetails(id = 8, channelName = "Channel 8", channelImage = sampleImages.random()),
	ChannelsDetails(id = 9, channelName = "Channel 9", channelImage = sampleImages.random()),
	ChannelsDetails(id = 10, channelName = "Channel 10", channelImage = sampleImages.random()),
)
