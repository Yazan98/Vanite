package io.vanite.android.permissions

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 6:49 PM
 */

class VanitePermissions : Permissions {

    private var requestCode: Int = 0
    private var permissionCallback: VanitePermissionCallback? = null

    override suspend fun isPermissionGenerated(permission: String): Boolean {
        return withContext(Dispatchers.IO) {
            ContextCompat.checkSelfPermission(
                VanitePermissionsConfiguration.getContext(),
                permission
            ) != PackageManager.PERMISSION_GRANTED
        }
    }

    override suspend fun isPermissionsGenerated(permissions: Array<String>): Boolean {
        var result = false
        withContext(Dispatchers.IO) {
            permissions.forEach {
                result = ContextCompat.checkSelfPermission(
                    VanitePermissionsConfiguration.getContext(),
                    it
                ) != PackageManager.PERMISSION_GRANTED
            }
        }
        return result
    }

    override suspend fun requestPermission(permission: String, requestCode: Int) {
        this.requestCode = requestCode
        withContext(Dispatchers.Main) {
            ActivityCompat.requestPermissions(
                VanitePermissionsConfiguration.getContext() as Activity,
                arrayOf(permission),
                requestCode
            )
        }
    }

    override suspend fun requestPermissions(permissions: Array<String>, requestCode: Int) {
        this.requestCode = requestCode
        withContext(Dispatchers.Main) {
            ActivityCompat.requestPermissions(
                VanitePermissionsConfiguration.getContext() as Activity,
                permissions,
                requestCode
            )
        }
    }

    override suspend fun requestContextMultiPermissions(context: FragmentActivity, vararg permissions: String, reqCode: Int) {
        withContext(Dispatchers.Main) {
            requestCode = reqCode
            ActivityCompat.requestPermissions(
                context,
                permissions,
                requestCode
            )
        }
    }

    override suspend fun requestContextPermission(context: FragmentActivity, permission: String, reqCode: Int) {
        withContext(Dispatchers.Main) {
            requestCode = reqCode
            ActivityCompat.requestPermissions(
                context,
                arrayOf(permission),
                requestCode
            )
        }
    }

    suspend fun registerPermissionCallback(permissionCallback: VanitePermissionCallback?) {
        withContext(Dispatchers.IO) {
            this@VanitePermissions.permissionCallback = permissionCallback
        }
    }

    suspend fun unRegisterPermissionCallback() {
        withContext(Dispatchers.IO) {
            this@VanitePermissions.permissionCallback = null
        }
    }

    suspend fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: Array<Int>
    ) {
        withContext(Dispatchers.IO) {
            val generatedPermissions: ArrayList<String> by lazy { ArrayList<String>() }
            val deniedPermissions: ArrayList<String> by lazy { ArrayList<String>() }

            for ((i, value) in permissions.withIndex()) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    generatedPermissions.add(value)
                } else {
                    deniedPermissions.add(value)
                }
            }

            permissionCallback?.let {
                it.onPermissionGenerated(requestCode, generatedPermissions)
                it.onPermissionDenied(requestCode, deniedPermissions)
            }
        }
    }

}
