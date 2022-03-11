package io.vanite.android.firebase

import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import io.vanite.android.firebase.impl.FirebaseAuthImpl
import io.vanite.android.firebase.listener.VaniteAuthListener
import io.vanite.android.firebase.listener.VaniteGoogleAuthLIstener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/26/2019
 * Time : 10:29 PM
 */

class VaniteFirebaseAuth(
    private val auth: FirebaseAuth,
    private var listener: VaniteAuthListener?
) : FirebaseAuthImpl {

    companion object {
        const val RC_SIGN_IN = 9001
    }

    override suspend fun checkAccountStatus(): Boolean {
        return withContext(Dispatchers.IO) { auth.currentUser == null }
    }

    override suspend fun signInEmailAndPassword(email: String, password: String) {
        withContext(Dispatchers.IO) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        it.result?.let {
                            listener?.onAuthSuccess(it.user)
                        }
                    } else {
                        it.exception?.let {
                            listener?.onAuthError(it)
                        }
                    }
                }
        }
    }

    override suspend fun signInByGoogle(context: Context, defWebClientId: String, reqCode: Int) {
        withContext(Dispatchers.IO) {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(defWebClientId)
                .requestEmail()
                .build()

            val intent = GoogleSignIn.getClient(context, gso).signInIntent
            (context as FragmentActivity).startActivityForResult(intent, reqCode)
        }
    }

    override suspend fun registerGoogleSignInHandler(
        requestCode: Int,
        data: Intent?,
        googleListener: VaniteGoogleAuthLIstener?
    ) {
        withContext(Dispatchers.IO) {
            if (requestCode == RC_SIGN_IN) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    googleListener?.onAuthSuccess(account)
                } catch (e: ApiException) {
                    googleListener?.onAuthError(e)
                }
            }
        }
    }

    override suspend fun registerWithEmailAndPassword(email: String, password: String) {
        withContext(Dispatchers.IO) {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                        it.result?.let {
                            listener?.onAuthSuccess(it.user)
                        }
                } else {
                    it.exception?.let {
                        listener?.onAuthError(it)
                    }
                }
            }
        }
    }

    override suspend fun signOut() {
        withContext(Dispatchers.IO) {
            auth.signOut()
        }
    }

    override suspend fun destroyAuth() {
        withContext(Dispatchers.IO) {
            listener = null
        }
    }

}
