package InUppg2.AOC.Y2021.D04

import java.io.File

fun main() {
    val fromFile: List<String> = File("src/InUppg2/AOC/Y2021/D04/input").readLines()
   // val fromFile: List<String> = File("src/InUppg2/AOC/Y2021/D04/sample").readLines()

    val allCalls = getAllCallsToList(fromFile[0])


    val bingoBoards = getBingoBoardsToMap(fromFile)


    //playToWin(allCalls,bingoBoards)
    playToLose(allCalls, bingoBoards)


}

fun getAllCallsToList(calls: String) = calls.split(',').map { it.toInt() }

fun getBingoBoardsToMap(fullList: List<String>): MutableMap<Int, MutableList<Int>> {
    val map = mutableMapOf<Int, MutableList<Int>>()
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
        var boardAsList = mutableListOf<Int>()
        for (s in tempS) {
            val rowS: List<String> = s.split(' ')
            val rowI = rowS.filterNot { it == "" }.map { it.toInt() }
            boardAsList.addAll(rowI)

        }
        map.put(key, boardAsList)
        key++
    }
    return map
}

fun playToWin(allCalls: List<Int>, bingoBoards: MutableMap<Int, MutableList<Int>>) {
    for (call in allCalls) {
        println(registerCall(call, bingoBoards))

    }
}

fun playToLose(allCalls: List<Int>, bingoBoards: MutableMap<Int, MutableList<Int>>) {
    val ordered = mutableMapOf<Int, Int>()
    for (call in allCalls) {
        val res = registerCall(call, bingoBoards)
        if (!res.startsWith("No")) {
            ordered.putIfAbsent(res.substringBefore(':').toInt(), res.substringAfter(' ').toInt())
            bingoBoards.remove(res.substringBefore(':').toInt())
           println(res)
        }
    }
   // ordered.forEach({ println(it) })
    println(bingoBoards.size)
    println(ordered.size)

}

fun registerCall(call: Int, map: MutableMap<Int, MutableList<Int>>): String {
    var result = "No one got bingo"
    var counter=0
    for (entry in map) {
        if (entry.value.contains(call)) { //siffran finns på brickan
            counter++
            if (!checkBingo(entry.value, call)) {//inte blivit bingo
                entry.value[entry.value.indexOf(call)] = -1

            } else {
                result = calculateScore(call, entry)

            }
        }
    }

    return result
}

fun calculateScore(call: Int, board: MutableMap.MutableEntry<Int, MutableList<Int>>): String {
    val score = board.value.filterNot { it < 0 }.filterNot { it == call }.sum() * call

    return ("${board.key}: $score")
}

fun checkBingo(boardList: List<Int>, call: Int): Boolean {
    val columnNumber = boardList.indexOf(call) % 5
    val fromIndex = boardList.indexOf(call) - columnNumber
    val row = boardList.subList(fromIndex, (fromIndex + 5))
    var column = mutableListOf<Int>()
    for ((i, value) in boardList.withIndex()) {
        if (i % 5 == columnNumber) {
            column.add(value)
        }
    }
    if (row.contains(call) && row.filterNot { it.equals(call) }.all { it.equals(-1) }
        || column.contains(call) && column.filterNot { it.equals(call) }.all { it.equals(-1) }) {
        return true
    }
    return false
}

/*

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

 */