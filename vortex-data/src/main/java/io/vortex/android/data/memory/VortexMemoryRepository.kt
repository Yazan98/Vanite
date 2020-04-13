package io.vortex.android.data.memory

abstract class VortexMemoryRepository : MemoryRepositoryImpl<Any> {

    private var listener: VortexMemoryListener<Any>? = null
    private val keys: HashMap<String, Any> by lazy {
        HashMap<String, Any>()
    }

    override fun add(key: String, value: Any) {
        this.keys[key] = value
    }

    override fun addAll(items: HashMap<String, Any>) {
        this.keys.putAll(items)
    }

    override fun execute() {
        this.listener?.acceptMemoryKeys(keys)
    }

    override fun withListener(listener: VortexMemoryListener<Any>) {
        this.listener = listener
    }

    override fun destroyListener() {
        this.listener = null
    }

}
