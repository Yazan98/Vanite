package io.vanite.android.compose.components

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.vanite.android.compose.ui.VaniteColors
import java.lang.Exception

class VaniteErrorScreen: ComponentActivity() {

    companion object {
        private const val IS_ERROR_EXCEPTION_ENABLED = "args.exception,message.enabled"
        private const val CUSTOM_ERROR_MESSAGE = "args.custom.error"
        private const val ERROR_TITLE = "args.error.title"
        private const val ERROR_IMAGE_URL = "args.error.image.url"
        private const val ERROR_MESSAGE_EXCEPTION = "args.error.message"
        private const val IS_SCREEN_DISMISS_ENABLED = "args.dismiss.enabled"

        fun startScreen(
            context: Context,
            exception: Throwable?,
            errorTitle: String,
            isExceptionErrorEnabled: Boolean,
            customErrorMessage: String,
            errorImageUrl: String,
            isScreenDismissEnabled: Boolean
        ) {
            context.startActivity(Intent(context, VaniteErrorScreen::class.java).apply {
                putExtra(IS_ERROR_EXCEPTION_ENABLED, isExceptionErrorEnabled)
                putExtra(CUSTOM_ERROR_MESSAGE, customErrorMessage)
                putExtra(ERROR_IMAGE_URL, errorImageUrl)
                putExtra(ERROR_TITLE, errorTitle)
                putExtra(ERROR_MESSAGE_EXCEPTION, exception?.message ?: "")
                putExtra(IS_SCREEN_DISMISS_ENABLED, isScreenDismissEnabled)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isExceptionErrorEnabled = intent?.extras?.getBoolean(IS_ERROR_EXCEPTION_ENABLED, false) ?: false
        val errorImageUrl = intent?.extras?.getString(ERROR_IMAGE_URL, "") ?: ""
        val customErrorMessage = intent?.extras?.getString(CUSTOM_ERROR_MESSAGE, "") ?: ""
        val errorTitle = intent?.extras?.getString(ERROR_TITLE, "") ?: ""
        val exceptionMessage = intent?.extras?.getString(ERROR_MESSAGE_EXCEPTION, "") ?: ""
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(VaniteColors.getScreenBackgroundColor()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(model = errorImageUrl, contentDescription = "Error Icon", modifier = Modifier.size(60.dp))
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = errorTitle, color = VaniteColors.getTextColor())
                Spacer(modifier = Modifier.height(3.dp))
                if (isExceptionErrorEnabled) {
                    Text(text = exceptionMessage, color = VaniteColors.getTextColor())
                } else {
                    Text(text = customErrorMessage, color = VaniteColors.getTextColor())
                }
            }
        }
    }

    override fun onBackPressed() {
        val isScreenDismissEnabled = intent?.extras?.getBoolean(IS_SCREEN_DISMISS_ENABLED, false) ?: false
        if (isScreenDismissEnabled) {
            super.onBackPressed()
        }
    }

}