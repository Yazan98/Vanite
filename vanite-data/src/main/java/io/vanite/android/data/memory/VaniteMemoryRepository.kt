package io.vanite.android.data.memory

abstract class VaniteMemoryRepository : MemoryRepositoryImpl<Any> {

    private var listener: VaniteMemoryListener<Any>? = null
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

    override fun withListener(listener: VaniteMemoryListener<Any>) {
        this.listener = listener
    }

    override fun destroyListener() {
        this.listener = null
    }

}
