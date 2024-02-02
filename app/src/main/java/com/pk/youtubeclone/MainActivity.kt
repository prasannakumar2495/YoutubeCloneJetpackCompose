package com.pk.youtubeclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.pk.youtubeclone.navigations.YoutubeNavigationCenter
import com.pk.youtubeclone.ui.theme.YoutubeCloneTheme

class MainActivity : ComponentActivity() {
	companion object {
		var TAG: String = MainActivity::class.java.simpleName
	}
	
	@OptIn(ExperimentalMaterial3Api::class)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			YoutubeCloneTheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					val displayPostBottomSheet = remember {
						mutableStateOf(false)
					}
					val selectedNavigation = remember {
						mutableIntStateOf(0)
					}
					val displayProfileBottomSheet = remember {
						mutableStateOf(false)
					}
					val bottomSheetState = rememberModalBottomSheetState()
					YoutubeNavigationCenter(
						displayPostBottomSheet,
						selectedNavigation,
						displayProfileBottomSheet,
						bottomSheetState
					)
				}
			}
		}
	}
}
