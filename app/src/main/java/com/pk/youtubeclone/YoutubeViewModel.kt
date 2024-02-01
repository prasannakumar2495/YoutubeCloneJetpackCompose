package com.pk.youtubeclone

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import com.pk.youtubeclone.modelclasses.VideoDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class YoutubeViewModel @Inject constructor(
	private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
	private val videoUris = savedStateHandle.getStateFlow("getVideoUris", emptyList<Uri>())
	val videoItems = videoUris.map {
		it.map { uri ->
			VideoDetails(
				id = 123,
				channelImageUrl = SampleImageURL1,
				videoUri = uri,
				videoTitle = "Video Title",
				channelName = "Channel Name",
				numberOfViews = 23432,
				uploadedTime = "123123",
				mediaItem = MediaItem.fromUri(uri)
			)
		}
	}.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}