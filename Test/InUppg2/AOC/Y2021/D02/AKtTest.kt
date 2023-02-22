package InUppg2.AOC.Y2021.D02

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AKtTest {

    @Test
    fun fromFileToMapTest() {
        val testMap = fromFileToMapOfList("src/InUppg2/AOC/Y2021/D02/sample")

        assertEquals(testMap.size,3)
    }

    @Test
    fun sumUpMapTest() {
        val test = sumUpMap(fromFileToMapOfList("src/InUppg2/AOC/Y2021/D02/sample"))
        assertEquals(test.size,2)
        assertEquals(test.getValue("horizontal"),15)
        assertEquals(test.getValue("depth"),10)
    }

    @Test
    fun getFinalPositionTest() {
        val res = getFinalPosition(15,10)
        assertEquals(res,150)
        assertNotEquals(res,15)
    }
}