package InUppg2.AOC.Y2021.D01

import java.io.File
import java.util.Scanner

fun isIncreasing (first:Int, second:Int) = first<second

fun countIncreases (groupedDepths: List<Int>):Int{
    var counter = 0
    for (i in 1..(groupedDepths.size-1)){
        if (isIncreasing(groupedDepths.get(i-1),groupedDepths.get(i)))
            counter++
    }
    return counter
}

fun groupList(depths: List<Int>):List<Int>{
    val groupedList = mutableListOf<Int>()

    for (i in 2..(depths.size-1)){
        groupedList.add(depths.get(i-2)+depths.get(i-1)+depths.get(i))
    }

    return groupedList
}


fun main() {
    val scanner = Scanner(File("src/InUppg2/AOC/Y2021/D01/input"))
    val depths = mutableListOf<Int>()

    while (scanner.hasNextInt())
        depths.add(scanner.nextInt())

    val counter = countIncreases(depths)
    println(counter)

    val bList = groupList(depths)

    println(countIncreases(bList))

}
