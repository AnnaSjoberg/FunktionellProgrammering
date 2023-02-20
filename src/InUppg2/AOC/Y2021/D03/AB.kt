package InUppg2.AOC.Y2021.D03

import KotlinPackage.övn9.filter
import java.io.File

fun main() {
    val binaryStrings: List<String> = File("src/InUppg2/AOC/Y2021/D03/sample").readLines()


    val aList = getBothValuesAsStringList(binaryStrings)
    val aGamma = aList[0].substringAfter(':')
    val aEpsilon = aList[1].substringAfter(':')

    println(aList.toString())
    println("A: ${calculate(aGamma,aEpsilon)}")

    val bGamma = getOneValueAsString(binaryStrings,"oxygen")
    val bEpsilon = getOneValueAsString(binaryStrings, "co2")

    println(bGamma+" "+bEpsilon)
    println("B: ${calculate(bGamma,bEpsilon)}")
}


fun fromFileToList(path: String) = File(path).readLines()

fun getBothValuesAsStringList(binaryStrings: List<String>): List<String> {
    var charcounter = 0
    var zeros = 0
    var ones = 0
    var gamma = "gamma:"
    var epsilon = "epsilon:"
    while (charcounter < binaryStrings[0].length) {
        for (s in binaryStrings) {
            if (s[charcounter] == '1') ones++ else zeros++
        }
        if (ones > zeros) {
            gamma += '1'
            epsilon += '0'
        } else {
            gamma += '0'
            epsilon += '1'
        }
        charcounter++
        zeros = 0
        ones = 0
    }
    return listOf(gamma, epsilon)
}

fun getOneValueAsString(binaryStrings: List<String>, gas: String): String {
    var charcounter = 0
    var zeros = 0
    var ones = 0
    var tempList = binaryStrings.toMutableList()
    while (charcounter < tempList[0].length && tempList.size > 1) {

        for (s in tempList) {
            if (s[charcounter] == '1') ones++ else zeros++
        }
        if (gas.equals("oxygen")) {
            if (ones >= zeros) {
                tempList = tempList.filter { s -> s[charcounter] == '1' } as MutableList<String>

            } else {
                tempList = tempList.filter { s -> s[charcounter] == '0' } as MutableList<String>

            }
        } else if (gas.equals("co2")){
            if (zeros <= ones) {
                tempList = tempList.filter { s -> s[charcounter] == '0' } as MutableList<String>

            } else {
                tempList = tempList.filter { s -> s[charcounter] == '1' } as MutableList<String>

            }
        }
        charcounter++
        zeros = 0
        ones = 0

    }
     return tempList[0]
}

fun calculate(gamma:String, epsilon:String) = gamma.toInt(2)*epsilon.toInt(2)