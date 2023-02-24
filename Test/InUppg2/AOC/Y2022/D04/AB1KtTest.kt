package InUppg2.AOC.Y2022.D04

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class AB1KtTest {
    val input: List<String> = File("src/InUppg2/AOC/Y2022/D04/sample").readLines()
    val list = mutableListOf<List<Int>>()


    @Test
    fun convertInputToPairsOfIntRangeTest() {
        assertEquals(convertInputToPairsOfIntList(input[0]), listOf(2,4,6,8))  //input 2-4,6-8
        assertNotEquals(convertInputToPairsOfIntList(input[0]),listOf(1,2,3,4))  //input 2-4,6-8
    }

    @Test
    fun countTotalOverlapTest() {
        for (line in input) {
            list.add(convertInputToPairsOfIntList(line))
        }
        assertEquals(countTotalOverlap(list),2)
        assertNotEquals(countTotalOverlap(list),-1)

    }

    @Test
    fun countPartialOverlapTest() {
        for (line in input) {
            list.add(convertInputToPairsOfIntList(line))
        }
        assertEquals(countPartialOverlap(list),4)
    }
}

