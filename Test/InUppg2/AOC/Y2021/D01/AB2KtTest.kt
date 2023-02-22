package InUppg2.AOC.Y2021.D01

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AB2KtTest {
    val testList = fromFileToList("src/InUppg2/AOC/Y2021/D01/sample")//199,200,208,210,200,207,240,269,260,263
    @Test
    fun countIncreasesWindowedTest() {
        assertEquals(countIncreases(testList),7)
        assertNotEquals(countIncreases(testList),17)
    }
}