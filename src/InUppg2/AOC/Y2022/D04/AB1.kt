package InUppg2.AOC.Y2022.D04

import java.io.File

fun main() {
    val input: List<String> = File("src/InUppg2/AOC/Y2022/D04/input").readLines()

    val listOfIntLists = mutableListOf<List<Int>>()
    for (line in input) {
        listOfIntLists.add(convertInputToPairsOfIntList(line))
    }

    println(countTotalOverlap(listOfIntLists))

    println(countPartialOverlap(listOfIntLists))
}

fun convertInputToPairsOfIntList(line: String): List<Int> {
    val (a, b, c, d) = line.split("-", ",", limit = 4) //delar upp raden i två delar (före och efter '-')
    return listOf(a.toInt(),b.toInt() , c.toInt(),d.toInt())
}

fun countTotalOverlap (listOfList: List<List<Int>>)=
    listOfList.count { (it[0] <= it[2] && it[1] >= it[3]) || (it[0] >= it[2] && it[1] <= it[3]) }

fun countPartialOverlap (listOfList: List<List<Int>>)= listOfList.count { ! (it[1] < it[2]  || it[3] < it[0]) }
