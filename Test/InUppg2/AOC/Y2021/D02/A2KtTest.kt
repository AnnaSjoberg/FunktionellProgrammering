package InUppg2.AOC.Y2021.D02

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class A2KtTest {

    @Test
    fun fromFileToMapOfIntTest() {
        val map = fromFileToMapOfInt("src/InUppg2/AOC/Y2021/D02/sample")

        assertEquals(map.size,2)
        assertEquals(map.getValue("forward"),15)
        assertEquals(map.getValue("depth"),10)

    }

    @Test
    fun calculatePositionTest() {
        val map = mapOf("forward" to 10, "depth" to 15)

        assertEquals(calculatePosition(map),150)
        assertNotEquals(calculatePosition(map),-1)

    }
}