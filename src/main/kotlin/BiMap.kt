import java.lang.StringBuilder
import java.util.function.BiFunction


/**
 * a bidirectional hashmap, allowing to get a key from a value.
 * both keys and values are uniques.
 */
class BiMap<K, V>() : MutableMap<K, V> {

    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
        get() = map.entries
    val reverseEntries : MutableSet<MutableMap.MutableEntry<V, K>>
        get() = reverse.entries
    override val keys: MutableSet<K>
        get() = map.keys
    override val values: MutableSet<V>
        get() = reverse.keys
    override val size: Int
        get() = values.size

    private val reverse = HashMap<V, K>()
    private val map = HashMap<K, V>()

    constructor(map: Map<K, V>) : this() {
        this.putAll(map)
    }

    override fun put(key: K, value: V): V? {
        remove(key,value)
        reverse[value] = key
        map[key] = value
        return null
    }

    override fun putAll(from: Map<out K, V>) {
       from.forEach { (k, v) -> this[k] = v}
    }

    override fun putIfAbsent(key: K, value: V): V? {
        this[key] = value
        return null
    }

    override fun clear() {
        reverse.clear()
        map.clear()
    }

    override fun remove(key: K, value: V): Boolean {
        reverse.remove(value,key);
        return map.remove(key,value)
    }

    override fun remove(key: K): V? {
        reverse.remove(map[key])
        return map.remove(key)
    }

    fun removeVal(value : V) : K?{
        map.remove(reverse[value])
        return reverse.remove(value)
    }

    override fun replace(key: K, value: V): V? {
        remove(key,value)
        return put(key,value)
    }

    override fun replace(key: K, oldValue: V, newValue: V): Boolean {
        this.remove(key,oldValue)
        this[key] = newValue
        return true
    }

    override fun containsKey(key: K) = map.containsKey(key)

    override fun containsValue(value: V) = values.contains(value)

    override fun get(key: K) = map[key]

    fun getVal(value : V) = reverse[value]

    override fun isEmpty() = map.isEmpty()

    override fun merge(key: K, value: V, remappingFunction: BiFunction<in V, in V, out V?>): V? {
        throw UnsupportedOperationException("method not supported")
    }

    override fun replaceAll(function: BiFunction<in K, in V, out V>) {
        throw UnsupportedOperationException("method not supported")
    }

    fun deepToString() : String {
        val b = StringBuilder()
        forEach { t, u ->  b.append("[$t,$u]") }
        return b.toString()
    }
}