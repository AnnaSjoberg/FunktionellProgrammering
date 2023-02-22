package InUppg2.AOC.Y2021.D02

import java.io.File

fun fromFileToMapOfInt(path: String): Map<String, Int> {
    val fromFile: List<String> = File(path).readLines()
    val map = mutableMapOf<String, Int>()
    for (line in fromFile) {
        val (direction, digitString) = line.split(" ", limit = 2) //delar upp raden i två delar (före och efter ' ')
        val digit = digitString.toInt()
        when (direction) {          //gick att förenkla så att jag summerade mängderna direkt, och slapp en funktion
            "forward" -> map.put(direction, (map.getOrDefault(direction, 0)+digit))
            "down" -> map.put("depth", (map.getOrDefault("depth",0)+digit))
            "up" -> map.put("depth", (map.getOrDefault("depth",0)-digit))
        }
    }
    return map
}
// https://github.com/ephemient/aoc2021/blob/main/kt/src/commonMain/kotlin/com/github/ephemient/aoc2021/Day2.kt

fun calculatePosition(map: Map<String, Int>) = map.getValue("forward") * map.getValue("depth")


fun main() {
    val mapFromFile = fromFileToMapOfInt("src/InUppg2/AOC/Y2021/D02/input")
    println(calculatePosition(mapFromFile))

}