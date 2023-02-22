package InUppg2.AOC.Y2022.D06

import java.io.File

fun main() {
    val input: List<String> = File("src/InUppg2/AOC/Y2022/D06/input").readLines()
    val answerA = findPosition(input[0], 4)
    println(answerA)
    val answerB = findPosition(input[0], 14)
    println(answerB)
}

fun findPosition(string: String, markerLength: Int): Int {
    var unChecked = string
    var checked = unChecked.take(markerLength)
    var result = 0
    unChecked = unChecked.drop(markerLength)

    while (true) {
        if (marker(checked.substring(checked.length - markerLength))) {
            result = checked.length
            break
        } else {
            checked += unChecked.take(1)
            unChecked = unChecked.drop(1)
        }
    }
    return result
}

private fun marker(string: String): Boolean {
    for (c in string) {
        if (string.count { it.equals(c) } > 1) return false
    }
    return true
}