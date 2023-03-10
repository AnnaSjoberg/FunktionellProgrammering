package InUppg2.AOC.Y2021.D02

import java.io.File
//Hittade inte någon version som jag tyckte var bättre än den jag hade.

fun calculatePosition(list: List<String>): Map<String,Int> {
    var aim = 0
    var horizontal = 0
    var depth = 0

    for (s in list) {
        val temp = s.split(' ')
        val dir = temp.first()
        val num = temp.last().toInt()
        when (dir) {
            "forward" -> {
                horizontal += num
                depth += (aim * num)
            }
            "up" -> aim -= num
            "down" -> aim += num
        }
    }
    return mapOf("aim" to aim, "horizontal" to horizontal, "depth" to depth)
}

fun main() {
    val input =  File("src/InUppg2/AOC/Y2021/D02/input").readLines()
    val mappedPosition = calculatePosition(input)

    println("${mappedPosition.getValue("depth")} * ${mappedPosition.getValue("horizontal")} = " +
            "${mappedPosition.getValue("depth")*mappedPosition.getValue("horizontal")}")

}