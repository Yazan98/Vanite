package io.vanite.android.ui

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Build
import android.view.View
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.fragment.app.FragmentActivity
import com.google.android.material.snackbar.Snackbar
import io.vanite.android.ui.impl.MessageDelegationImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 10:19 PM
 */

class VaniteMessageDelegation : MessageDelegationImpl {

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

    suspend fun showSnackbarWithColor(context: FragmentActivity?, message: String, @ColorRes color: Int) {
        withContext(Dispatchers.Main) {
            context?.let {
                val parentLayout = it.findViewById<View>(android.R.id.content)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Snackbar.make(parentLayout, message, Snackbar.LENGTH_LONG)
                        .withColor(it.getColor(color))
                        .show()
                }
            }
        }
    }

    private fun Snackbar.withColor(@ColorInt colorInt: Int): Snackbar{
        this.view.setBackgroundColor(colorInt)
        return this
    }

    suspend fun showAlertDialog(context: Context , title: String , message: String) {
        withContext(Dispatchers.Main) {
            AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton(android.R.string.ok) { dialogInterface: DialogInterface, i: Int -> dialogInterface.dismiss() }
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show()
        }
    }

}
