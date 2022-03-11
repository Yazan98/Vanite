package io.vanite.android.data.utils

interface VaniteDaoExecutor<T,ID> {

    suspend fun insert(entity: T)

    suspend fun getEntityById(id: ID): T

    suspend fun getAll(): List<T>

    suspend fun deleteAll()

    suspend fun deleteById(id: ID)

}