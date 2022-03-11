package io.vanite.android.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import io.vanite.android.ui.VaniteMessageDelegation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 11:47 AM
 */

/**
 * This Fragment is the Super Fragment in Vanite for All Types Of Fragments
 * This One is Handling 2 Types of View Injection
 * 1. Layout XML Injection
 * 2. ViewBinding Injection
 *
 * This Fragment Has Utility Classes That Needed a lot Inside Fragments By Inline Functions
 * And Provide One Structure of Fragments
 * This Fragments is Customized By Passed Parameters in Generic Types
 */
abstract class VaniteBaseFragment : Fragment() {

    protected val messageController: VaniteMessageDelegation by lazy {
        VaniteMessageDelegation()
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (isScreenLayoutBinding()) {
            return inflater.inflate(getLayoutRes() , container , false)
        } else {
            return super.onCreateView(inflater, container, savedInstanceState)
        }
    }

    protected open fun isScreenLayoutBinding(): Boolean {
        return true
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initScreen(view)
    }

    protected suspend inline fun <reified T : Any> startScreen(isFinishEnabled: Boolean, options: Bundle? = null, noinline init: Intent.() -> Unit = {}) {
        withContext(Dispatchers.Main) {
            activity?.let {
                val intent = newIntent<T>(it)
                intent.init()
                startActivity(intent, options)
                if (isFinishEnabled) {
                    it.finish()
                }
            }
        }
    }

    protected suspend inline fun <reified T : Any> startScreenForResult(reqCode: Int, noinline init: Intent.() -> Unit = {}) {
        withContext(Dispatchers.Main) {
            activity?.let {
                val intent = newIntent<T>(it)
                intent.init()
                startActivityForResult(intent, reqCode)
            }
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
            activity?.let {
                it.intent.extras?.get(extra) as? T?
            }
        }
    }

    protected suspend fun startApplicationByPackageName(packageName: String, context: Context) {
        withContext(Dispatchers.Main) {
            val launchIntent = context.packageManager.getLaunchIntentForPackage(packageName)
            context.startActivity(launchIntent)
        }
    }

    protected fun getCurrentContext(): Context {
        return try {
            activity ?: requireActivity()
        } catch (ex: Exception) {
            requireContext()
        }
    }

    inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)

    @LayoutRes
    protected abstract fun getLayoutRes(): Int
    protected abstract fun initScreen(view: View)

}
