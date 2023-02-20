package InUppg2.AOC.Y2021.D02

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BKtTest {
    @Test
    fun fromFileToListTest() {
        val testList = fromFileToList("src/InUppg2/AOC/Y2021/D02/sample")
        assertEquals(testList.size,6)
        assertEquals(testList[0], "forward 5")
        assertNotEquals(testList[0], "Fel")
    }

    @Test
    fun calculatePosition() {
        val testMap = calculatePosition(fromFileToList("src/InUppg2/AOC/Y2021/D02/sample"))
        assertEquals(testMap.size, 3)
        assertEquals(testMap.getValue("depth"),60)
        assertEquals(testMap.getValue("horizontal"),15)
    }


}