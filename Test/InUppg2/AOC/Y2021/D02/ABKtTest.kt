package InUppg2.AOC.Y2021.D02

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.io.File
import java.util.*

internal class ABKtTest {
    val scanner = Scanner(File("src/InUppg2/AOC/Y2021/D02/sample"))
    val list = mutableListOf<Int>()

    @BeforeEach
    internal fun setUp() {

        while (scanner.hasNextInt())
            list.add(scanner.nextInt())

    }


    @Test
    fun getFinalPosition() {
        val x = 5
        val y = 10

        assertEquals(getFinalPosition(x,y),50)
        assertNotEquals(getFinalPosition(x,y),20)

    }
}