package io.vanite.android.firebase.listener

import com.google.firebase.auth.FirebaseUser
import java.lang.Exception

/**
 * Created By : Yazan Tarifi
 * Date : 10/26/2019
 * Time : 10:32 PM
 */

interface VaniteAuthListener {

    fun onAuthSuccess(user: FirebaseUser?)

    fun onAuthError(exception: Exception)

}