import org.junit.jupiter.api.Test

internal class BiMapTest {

    val bimap = BiMap<String, Int>()

    init {
        bimap["a"] = 1
        bimap["b"] = 2
        bimap["d"] = 5
    }

    @org.junit.jupiter.api.Test
    fun put() {

        assert(bimap["a"] == 1 && bimap["b"] == 2 && bimap["d"] == 5)
        bimap["b"] = 1
        assert(bimap["b"] == 1 && bimap(1) == "b")
        assert(!bimap.containsKey("a") && !bimap.contains("b",2))
        println(bimap.deepToString())
    }

    @Test
    fun forEachIndexed() {
        bimap.forEachIndexed{ i, s, i1 -> println("$s,$i1,$i")}
    }




}

