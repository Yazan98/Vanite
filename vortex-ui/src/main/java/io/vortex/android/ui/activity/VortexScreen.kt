package io.vortex.android.ui.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import io.vortex.android.ui.VortexMessageDelegation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/9/2019
 * Time : 8:35 PM
 */

abstract class VortexScreen : AppCompatActivity() {

    protected val messageController: VortexMessageDelegation by lazy {
        VortexMessageDelegation()
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
    }

    protected suspend inline fun <reified T : Any> startScreen(
        isFinishEnabled: Boolean,
        options: Bundle? = null,
        noinline init: Intent.() -> Unit = {}
    ) {
        withContext(Dispatchers.Main) {
            val intent = newIntent<T>(this@VortexScreen)
            intent.init()
            startActivity(intent, options)
            if (isFinishEnabled) {
                finish()
            }
        }
    }

    protected suspend inline fun <reified T : Any> startScreenForResult(
        reqCode: Int,
        noinline init: Intent.() -> Unit = {}
    ) {
        withContext(Dispatchers.Main) {
            val intent = newIntent<T>(this@VortexScreen)
            intent.init()
            startActivityForResult(intent, reqCode)
        }
    }

    @SuppressLint("MissingPermission")
    protected suspend fun startPhoneCall(phoneNumber: String) {
        withContext(Dispatchers.Main) {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }
    }


    protected suspend inline fun <reified T> getExtra(extra: String): T? {
        return withContext(Dispatchers.IO) {
            intent.extras?.get(extra) as? T?
        }
    }

    protected suspend fun startApplicationByPackageName(packageName: String, context: Context) {
        withContext(Dispatchers.Main) {
            val launchIntent = context.packageManager.getLaunchIntentForPackage(packageName)
            context.startActivity(launchIntent)
        }
    }

    inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

}
