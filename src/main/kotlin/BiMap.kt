import java.util.function.BiConsumer

class BiMap<K, V>() : HashMap<K, V>() {

    val reverse = HashMap<V, K>()

    constructor(map: Map<K, V>) : this() {
        this.putAll(map)
    }

    override fun put(key: K, value: V): V? {
        reverse[value] = key
        return super.put(key, value)
    }


    override fun putAll(from: Map<out K, V>) {
        from.forEach { (k, v) -> reverse[v] = k }
        super.putAll(from)
    }


    override fun clear() {
        reverse.clear()
        super.clear()
    }


}