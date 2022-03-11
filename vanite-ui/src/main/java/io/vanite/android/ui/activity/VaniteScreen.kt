package io.vanite.android.ui.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import io.vanite.android.ui.VaniteMessageDelegation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/9/2019
 * Time : 8:35 PM
 */

abstract class VaniteScreen : AppCompatActivity() {

    protected val messageController: VaniteMessageDelegation by lazy {
        VaniteMessageDelegation()
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isScreenLayoutBinding()) {
            setContentView(getLayoutRes())
        }
    }

    protected open fun isScreenLayoutBinding(): Boolean {
        return true
    }

    protected suspend inline fun <reified T : Any> startScreen(
        isFinishEnabled: Boolean,
        options: Bundle? = null,
        noinline init: Intent.() -> Unit = {}
    ) {
        withContext(Dispatchers.Main) {
            val intent = newIntent<T>(this@VaniteScreen)
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
            val intent = newIntent<T>(this@VaniteScreen)
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

    override fun onBackPressed() {
        if (isBackStackScreenCheckEnabled()) {
            val numberOfFragments = supportFragmentManager.backStackEntryCount
            if (numberOfFragments < 1) {
                setResult(Activity.RESULT_CANCELED)
                finish()
            } else {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }

    /**
     * If You need to Disable the Check on onBackPressed override this method
     * and change the return to false, the activity will back to normal mode and will not check
     * the Fragments Count
     */
    protected fun isBackStackScreenCheckEnabled(): Boolean {
        return true
    }

    inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

}
