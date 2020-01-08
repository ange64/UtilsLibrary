

internal class BiMapTest {

    @org.junit.jupiter.api.Test
    fun put() {
        val bimap = BiMap<String, Int>()

        bimap["a"] = 1
        bimap["b"] = 2
        bimap["d"] = 5
        println(bimap.deepToString())
        bimap["c"] = 1
        bimap["b"] = 4
        println(bimap.deepToString())
    }
}