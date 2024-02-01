package com.pk.youtubeclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.pk.youtubeclone.navigations.YoutubeNavigationCenter
import com.pk.youtubeclone.ui.theme.YoutubeCloneTheme

class MainActivity : ComponentActivity() {
	companion object {
		var TAG: String = MainActivity::class.java.simpleName
	}
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			YoutubeCloneTheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					YoutubeNavigationCenter()
				}
			}
		}
	}
}
