package InUppg2.AOC.Y2022.D08

import java.io.File

fun main() {
    val rowStrings: List<String> = File("src/InUppg2/AOC/Y2022/D08/sample").readLines()

    val columnString = rowStrings.first().indices.map { index ->
        rowStrings.map { it[index] }.joinToString("")
    }

    var counter = (rowStrings.size + columnString.size - 2) * 2     //räknaren börjar på alla de yttersta träden
    println(counter)
    var hiddenTrees = mutableListOf<String>()
    for (i in 1..rowStrings.size - 2) {
        val row = rowStrings[i].map { it.digitToInt() }
        val column = columnString[i].map { it.digitToInt() }

        if (isVisible(row, i) || isVisible(column, i)) counter++
    }

    println(counter)
    for (i in 1..columnString.size - 2) {
        val row = rowStrings[i].map { it.digitToInt() }
        val column = columnString[i].map { it.digitToInt() }

        if (isVisible(row, i) || isVisible(column, i)) counter++
    }

    println(counter)

}

private fun isVisible(line: List<Int>, index: Int): Boolean {


 if (line.subList(0, index).maxOf  { it < line[index] }
     || line.subList(index + 1, line.size).maxOf { it < line[index] }) {
     println("${line[index]}, i:$index")
     return true
 }
    else
    return false
}


//val columns = input[0].indices
/*

private fun List<String>.countBitsInColumn(column: Int): BitCount {    //extensionfunktion för att räkna 1:or och 0:or
    var zeroes = 0
    var ones = 0
    for (line in this) {
        if (line[column] == '0') zeroes++ else ones++
    }
    return BitCount(zeroes, ones)   //returnerar resultat för båda siffrorna
}

 */