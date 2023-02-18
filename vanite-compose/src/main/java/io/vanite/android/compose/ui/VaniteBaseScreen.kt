package io.vanite.android.compose.ui


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import io.vanite.android.compose.components.VaniteErrorScreen
import io.vanite.android.compose.components.VaniteToolbar
import io.vanite.android.compose.logic.VaniteViewModel
import io.vanite.android.compose.props.VaniteAction
import io.vanite.android.compose.props.VaniteState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class VaniteBaseScreen<Action: VaniteAction, State: VaniteState, ViewModel: VaniteViewModel<Action, State>> : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VaniteTheme(
                whiteModeStatusBarColor = getStatusBarWhiteMode(),
                darkModeStatusBarColor = getStatusBarDarkMode(),
                whiteColorSchema = getApplicationWhiteModeColorScheme(),
                darkColorSchema = getApplicationDarkModeColorScheme()
            ) {
                val scaffoldState = rememberScaffoldState()
                val corotineScope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        if (isToolbarEnabled()) {
                            VaniteToolbar(
                                getApplicationName(),
                                true,
                                this
                            )
                        }

                        if (!isToolbarEnabled() && isCustomToolbarEnabled()) {
                            getCustomToolbar()
                        }
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        getComposableView(savedInstanceState, scaffoldState, corotineScope).apply {
                            LaunchedEffect(key1 = errorScreenListener.value) {
                                if (errorScreenListener.value != null) {
                                    VaniteErrorScreen.startScreen(
                                        this@VaniteBaseScreen,
                                        errorScreenListener.value,
                                        getErrorScreenTitle(),
                                        isErrorExceptionEnabled(),
                                        getCustomErrorScreenMessage(),
                                        getErrorScreenIconUrl(),
                                        isErrorScreenDismissEnabled()
                                    )
                                    errorScreenListener.value = null
                                }
                            }

                            LaunchedEffect(key1 = errorMessageListener.value) {
                                if (!TextUtils.isEmpty(errorMessageListener.value)) {
                                    corotineScope.launch {
                                        scaffoldState.snackbarHostState.showSnackbar(errorMessageListener.value, duration = SnackbarDuration.Short)
                                        errorMessageListener.value = ""
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        onScreenStarted(savedInstanceState)
    }

    @Composable
    abstract fun getComposableView(savedInstanceState: Bundle?, scaffoldState: ScaffoldState, coroutinesScope: CoroutineScope): ViewModel

    open fun onScreenStarted(savedInstanceState: Bundle?) = Unit

    @Composable
    protected open fun getApplicationColor(): Color {
        return Color.White
    }

    @Composable
    protected fun getTextColor(): Color {
        return VaniteColors.getTextColor()
    }

    @Composable
    protected fun getWhiteColor(): Color {
        return Color.White
    }

    protected open fun isToolbarEnabled(): Boolean {
        return true
    }

    protected open fun isCustomToolbarEnabled(): Boolean {
        return false
    }

    protected open fun getApplicationName(): String {
        return "Vanite"
    }

    protected open fun getErrorScreenTitle(): String {
        return "Error Title"
    }

    protected open fun isErrorExceptionEnabled(): Boolean {
        return true
    }

    protected open fun getCustomErrorScreenMessage(): String {
        return "UnExpected Error"
    }

    protected open fun getErrorScreenIconUrl(): String {
        return ""
    }

    protected open fun isErrorScreenDismissEnabled(): Boolean {
        return true
    }

    protected open fun getStatusBarWhiteMode(): Color {
        return Color.White
    }

    protected open fun getStatusBarDarkMode(): Color {
        return Color.Black
    }

    protected open fun getApplicationWhiteModeColorScheme(): ColorScheme {
        return lightColorScheme()
    }

    protected open fun getApplicationDarkModeColorScheme(): ColorScheme {
        return darkColorScheme()
    }

    @Composable
    protected open fun getCustomToolbar() = Unit

}