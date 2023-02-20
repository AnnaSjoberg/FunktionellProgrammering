package InUppg2.AOC.Y2021.D01

import java.io.File
import java.util.Scanner

fun fromFileToList(path: String): List<Int> {
    val strings: List<String> = File(path).readLines()
    return strings.map { s -> s.toInt() }
}

fun isIncreasing(first: Int, second: Int) = first < second

fun countIncreases(groupedDepths: List<Int>): Int {
    var counter = 0
    for (i in 1..(groupedDepths.size - 1)) {
        if (isIncreasing(groupedDepths.get(i - 1), groupedDepths.get(i)))
            counter++
    }
    return counter
}

fun groupList(depths: List<Int>): List<Int> {
    val groupedList = mutableListOf<Int>()

    for (i in 2..(depths.size - 1)) {
        groupedList.add(depths.get(i - 2) + depths.get(i - 1) + depths.get(i))
    }

    return groupedList
}


fun main() {
    val depths = fromFileToList("src/InUppg2/AOC/Y2021/D01/sample")
    val counter = countIncreases(depths)
    println(counter)

    val bList = groupList(depths)

    println(bList)

    println(countIncreases(bList))

}
