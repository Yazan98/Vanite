package io.vortex.android.ui

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 10:19 PM
 */

class VortexMessageDelegation : MessageDelegationImpl {

    override suspend fun showShortMessage(message: String, context: Context?) {
        withContext(Dispatchers.Main) {
            context?.let {
                Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override suspend fun showLongMessage(message: String, context: Context?) {
        withContext(Dispatchers.Main) {
            context?.let {
                Toast.makeText(it, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override suspend fun showShortMessage(message: Int, context: Context?) {
        withContext(Dispatchers.Main) {
            context?.let {
                Toast.makeText(it, it.getString(message), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override suspend fun showLongMessage(message: Int, context: Context?) {
        withContext(Dispatchers.Main) {
            context?.let {
                Toast.makeText(it, it.getString(message), Toast.LENGTH_LONG).show()
            }
        }
    }

    suspend fun showSnackbar(context: FragmentActivity?, message: String) {
        withContext(Dispatchers.Main) {
            context?.let {
                val parentLayout = it.findViewById<View>(android.R.id.content)
                Snackbar.make(parentLayout, message, Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }

}
