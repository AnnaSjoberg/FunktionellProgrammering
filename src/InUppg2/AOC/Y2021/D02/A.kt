package InUppg2.AOC.Y2021.D02

import java.io.File
import java.util.*

fun getFinalPosition(x: Int, y: Int) = x * y


fun main() {
    val scanner = Scanner(File("src/InUppg2/AOC/Y2021/D02/input"))
    val mapFromFile = mutableMapOf<String, MutableList<Int>>()


    while (scanner.hasNext()) {
        val direction = scanner.next()
        //val digit = scanner.nextInt()
        val digit = if (direction.equals("up")) -scanner.nextInt() else scanner.nextInt()

        //myMap.putIfAbsent(direction, digit)
        mapFromFile.getOrPut(direction) { mutableListOf() }.add(digit)
    }
    val calculatedMap = mutableMapOf<String, Int>()

    for ((k, v) in mapFromFile) {
        if (k.equals("forward"))
            calculatedMap.putIfAbsent("x", v.sum())
        else if (!calculatedMap.containsKey("y"))
            calculatedMap.putIfAbsent("y", v.sum())
        else
            calculatedMap.put("y", calculatedMap.getValue("y")+v.sum())
    }

    for ((k, v) in calculatedMap) println("$k : $v")

    println(getFinalPosition(calculatedMap.getValue("x"),calculatedMap.getValue("y")))
}