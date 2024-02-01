package com.pk.youtubeclone.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.pk.youtubeclone.commonComponents.AppLogo
import com.pk.youtubeclone.navigations.NavigationRoutes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
	val scale = remember {
		Animatable(0f)
	}
	LaunchedEffect(key1 = true) {
		scale.animateTo(
			targetValue = 0.9f,
			animationSpec = tween(
				durationMillis = 800,
				easing = ({
					OvershootInterpolator(8f).getInterpolation(it)
				})
			)
		)
		delay(1000L)
		
		navController.navigate(route = NavigationRoutes.Home.name)
	}
	
	Surface(color = Color.Black) {
		AppLogo(modifier = Modifier.scale(scale.value))
	}
}