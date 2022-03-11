package io.vanite.android.firebase

import com.google.firebase.firestore.FirebaseFirestore
import io.vanite.android.firebase.impl.VaniteFirestoreImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


/**
 * Created By : Yazan Tarifi
 * Date : 10/26/2019
 * Time : 10:56 PM
 */

class VaniteFirestore(private val firestore: FirebaseFirestore) : VaniteFirestoreImpl {

    override suspend fun createDocument(collection: String, model: Any) {
        withContext(Dispatchers.IO) {
            firestore.collection(collection).document().set(model)
        }
    }

    override suspend fun deleteDocument(collection: String, documentId: String) {
        withContext(Dispatchers.IO) {
            firestore.collection(collection).document(documentId).delete()
        }
    }

    override suspend fun updateDocument(collection: String, documentId: String, model: HashMap<String, Any>) {
        withContext(Dispatchers.IO) {
            firestore.collection(collection).document().update(model)
        }
    }

    override suspend fun getAllDocumentsAtCollection(collection: String): ArrayList<String> =
        suspendCoroutine { cont ->
            val result: ArrayList<String> = ArrayList()
            firestore.collection(collection).get().addOnCompleteListener {
                if (it.isSuccessful) {
                    it.result?.let {
                        for (document in it) {
                            result.add(document.id)
                        }
                        cont.resume(result)
                    }
                } else {
                    it.exception?.let {
                        cont.resumeWithException(it)
                    }
                }
            }
        }

}
