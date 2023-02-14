package InUppg2.AOC.Y2021.D01

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.util.*

internal class A1KtTest {
    val scanner = Scanner(File("src/InUppg2/AOC/Y2021/D01/sample"))
    val list = mutableListOf<Int>()

    @BeforeEach
    internal fun setUp() {

        while (scanner.hasNextInt())
            list.add(scanner.nextInt())

    }

    @Test
    fun isIncreasingTest() {
        val i1 = 5
        val i2 = 8

        assertTrue(isIncreasing(i1,i2))
        assertFalse(isIncreasing(i2,i1))

    }

    @Test
    fun countIncreasesTest() {
        var counter = countIncreases(list)

        assertTrue(list.size >0)
        assertEquals(list.get(list.size-1),263)
        assertEquals(counter, 7)

    }

    @Test
    fun groupList() {
        val groupedList = groupList(list)

        assertEquals(groupedList.size,8)
        assertEquals(groupedList.get(0),607)
        assertEquals(groupedList.get(7),792)
        assertNotEquals(groupedList.get(7),607)
    }
}

