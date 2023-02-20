package InUppg2.AOC.Y2021.D04

import KotlinPackage.övn9.filter
import java.io.File
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    //   val fromFile: List<String> = File("src/InUppg2/AOC/Y2021/D04/input").readLines()
    val fromFile: List<String> = File("src/InUppg2/AOC/Y2021/D04/sample").readLines()


    var boards = mutableMapOf<Int, List<String>>()
    var atomicInteger = AtomicInteger(1)
    var boardCounter = 0

    val callstrings = fromFile[0].split(',')
    val calls: List<Int> = callstrings.map { it.toInt() }
    println(fromFile[0].length)


    val bingoBoards = getBingoBoardsToMap(fromFile)
    println(bingoBoards.size)
    println(bingoBoards.getValue(1))

    println(bingoBoards.getValue(1).get(0).get(0))
    println(bingoBoards.getValue(1)[0][0])

    //println(bingoBoards.getValue(1))


}

fun getBingoBoardsToMap(fullList: List<String>): Map<Int, List<List<Int>>> {
    val map = mutableMapOf<Int, List<List<Int>>>()
    var key = 1
    var blankIndices = mutableListOf<Int>()
    for ((ix, s) in fullList.withIndex()) {
        if (s == "")
            blankIndices.add(ix)

    }
    for (bIx in blankIndices) {
        val start = bIx + 1
        val stop = bIx + 6
        val tempS = fullList.subList(start, stop)
        var tempI = mutableListOf<List<Int>>()
        //  var counter =0
        for (s in tempS) {
            val rowS: List<String> = s.split(' ')
            val row: List<Int> = rowS.filterNot { it == "" }.map { it.toInt() }
            tempI.add(row)

        }
        map.put(key, tempI)
        key++
    }
    return map
}

fun registerCall(call:Int, map: Map<Int,List<List<Int>>>){

}