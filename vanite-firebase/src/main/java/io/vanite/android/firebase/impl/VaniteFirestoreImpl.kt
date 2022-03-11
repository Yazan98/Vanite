package io.vanite.android.firebase.impl

/**
 * Created By : Yazan Tarifi
 * Date : 10/26/2019
 * Time : 10:56 PM
 */

interface VaniteFirestoreImpl {

    suspend fun createDocument(collection: String , model: Any)

    suspend fun deleteDocument(collection: String , documentId: String)

    suspend fun updateDocument(collection: String, documentId: String, model: HashMap<String , Any>)

    suspend fun getAllDocumentsAtCollection(collection: String): ArrayList<String>

}