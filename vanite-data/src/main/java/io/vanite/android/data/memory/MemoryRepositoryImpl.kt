package io.vanite.android.data.memory

interface MemoryRepositoryImpl<Type> {

    fun add(key: String, value: Type)

    fun addAll(items: HashMap<String, Type>)

    fun withListener(listener: VaniteMemoryListener<Type>)

    fun destroyListener()

    fun getByKey(key: String, defVal: String): Type?

    fun save(key: String, value: Any)

    fun execute()

}
