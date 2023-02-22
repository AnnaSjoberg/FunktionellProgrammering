package InUppg2.AOC.Y2022.D06

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AB1KtTest {



    @Test
    fun findPositionTest() {
        val sample = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
        val a = 4
        val b = 14

        assertEquals(findPosition(sample,a), 7)
        assertEquals(findPosition(sample,b), 19)


    }
}