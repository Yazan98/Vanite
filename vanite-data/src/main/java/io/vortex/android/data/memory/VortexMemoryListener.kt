package io.vortex.android.data.memory

interface VortexMemoryListener<Type> {

    fun acceptMemoryKeys(items: HashMap<String, Type>)

}
