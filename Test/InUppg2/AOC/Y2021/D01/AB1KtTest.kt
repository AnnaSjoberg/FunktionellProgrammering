package InUppg2.AOC.Y2021.D01

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AB1KtTest {
    val testList = fromFileToList("src/InUppg2/AOC/Y2021/D01/sample")//199,200,208,210,200,207,240,269,260,263
    @Test
    fun fromFileToListTest() {
        assertTrue(testList.size==8)
        assertTrue(testList[testList.size-1]==263)
    }

    @Test
    fun isIncreasingTest() {
        assertEquals(isIncreasing(testList[0],testList[1]),true)
        assertEquals(isIncreasing(testList[3],testList[4]),false)
    }

    @Test
    fun countIncreasesTest() {
        assertEquals(countIncreases(testList),7)
        assertNotEquals(countIncreases(testList),17)
    }

    @Test
    fun groupListTest() {
        val grouped = groupList(testList)//607, 618, 618, 617, 647, 716, 769, 792
        assertTrue(grouped.size==8)
        assertTrue(grouped[0]==607)
        assertTrue(grouped[7]==792)

    }
}