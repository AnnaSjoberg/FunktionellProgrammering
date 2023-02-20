package InUppg2.AOC.Y2021.D02

import java.io.File
import java.util.*

fun fromFileToMap(path: String): Map<String, List<Int>>{

    val scanner = Scanner(File(path))
    val mapFromFile = mutableMapOf<String, MutableList<Int>>()

    while (scanner.hasNext()) {
        val direction = scanner.next()

        val digit = if (direction.equals("up")) -scanner.nextInt() else scanner.nextInt()

        mapFromFile.getOrPut(direction) { mutableListOf() }.add(digit)
    }
    return mapFromFile
}

fun sumUpMap(mapFromFile:Map<String, List<Int>>): Map<String, Int>{
val result = mutableMapOf<String,Int>()
    for ((k, v) in mapFromFile) {
        if (k.equals("forward"))
            result.putIfAbsent("horizontal", v.sum())
        else if (!result.containsKey("depth"))
            result.putIfAbsent("depth", v.sum())
        else
            result.put("depth", result.getValue("depth")+v.sum())
    }
    return result
}

fun getFinalPosition(x: Int, y: Int) = x * y

fun main() {
    val mapFromFile = fromFileToMap("src/InUppg2/AOC/Y2021/D02/sample")
    val calculatedMap = sumUpMap(mapFromFile)


    for ((k, v) in calculatedMap) println("$k : $v")

    println(getFinalPosition(calculatedMap.getValue("x"),calculatedMap.getValue("y")))
}