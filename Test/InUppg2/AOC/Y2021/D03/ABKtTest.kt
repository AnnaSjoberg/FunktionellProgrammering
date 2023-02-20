package InUppg2.AOC.Y2021.D03

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ABKtTest {
    val bigList = fromFileToList("src/InUppg2/AOC/Y2021/D03/sample")
    @Test
    fun fromFileToListTest() {

        assertEquals(bigList.size,12)
    }

    @Test
    fun getBothValuesAsStringListTest() {
        val smallList = getBothValuesAsStringList(bigList)
        assertEquals(smallList.size,2)
        assertTrue(smallList[0].startsWith("gamma:"))
        assertTrue(smallList[1].startsWith("epsilon:"))
    }

    @Test
    fun getOneValueAsString() {
        val oxyString = getOneValueAsString(bigList,"oxygen")//10111
        val co2String = getOneValueAsString(bigList,"co2")//01010

        assertEquals(oxyString,"10111")
        assertEquals(co2String,"01010")
    }

    @Test
    fun calculateTest() {
        assertEquals(calculate("10110","01001"),198)//A
        assertEquals(calculate("10111","01010"),230)//B
    }
}