package InUppg2.AOC.Y2021.D04

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class ABKtTest {

    val fromFile: List<String> = File("src/InUppg2/AOC/Y2021/D04/sample").readLines()
    val boards = getBingoBoardsToMap(fromFile)
    val calls = getAllCallsToList(fromFile[0])

    @Test
    fun getAllCallsToListTest() {

        assertEquals(calls.size, 27)
        assertEquals(calls[0], 7)
        assertEquals(calls[26], 1)
    }

    @Test
    fun getBingoBoardsToMapTest() {

        assertEquals(boards.size, 3)
        assertEquals(boards.getValue(1)[0], 22)
        assertEquals(boards.getValue(2)[8], 17)
        assertNotEquals(boards.getValue(1)[0], 17)

    }

    @Test
    fun registerCall() {

    }

    @Test
    fun checkBingoTest() {
        val rowBingo = listOf(-1, -1, 23, -1, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
        val colBingo =
            listOf(1, 2, 3, 4, 5, -1, 7, 8, 9, 10, -1, 12, 13, 14, 15, -1, 17, 18, 19, 20, -1, 22, 23, 24, 25)

        assertEquals(checkBingo(rowBingo, 23), true)
        assertEquals(checkBingo(colBingo, 1), true)
        assertEquals(checkBingo(boards.getValue(1), 1), false)

    }

}