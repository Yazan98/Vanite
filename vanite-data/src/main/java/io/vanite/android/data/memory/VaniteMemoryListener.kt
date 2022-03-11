package io.vanite.android.data.memory

interface VaniteMemoryListener<Type> {

    fun acceptMemoryKeys(items: HashMap<String, Type>)

}
