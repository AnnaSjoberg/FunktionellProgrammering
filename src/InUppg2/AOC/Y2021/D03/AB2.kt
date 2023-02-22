package InUppg2.AOC.Y2021.D03

import java.io.File

fun main() {
    val binaryStrings: List<String> = File("src/InUppg2/AOC/Y2021/D03/sample").readLines()
    val gammaRate = getGammaRate(binaryStrings)
    println(gammaRate)
    val epsilonRate = getEpsilonRate(gammaRate)
    println(epsilonRate)
    val answer = convertToDecimalAndCalculate(gammaRate, epsilonRate)
    println(answer)

    val allInOne =
        convertToDecimalAndCalculate(getGammaRate(binaryStrings), getEpsilonRate(getGammaRate(binaryStrings)))
    println(allInOne)

    val oxy = getRatingAsString(binaryStrings, Gas.OXYGEN)
    println(oxy)
    val co2 = getRatingAsString(binaryStrings, Gas.CO2)
    println(co2)
    val answerB = convertToDecimalAndCalculate(oxy, co2)
    println(answerB)
}

fun convertToDecimalAndCalculate(gammaRate: String, epsilonRate: String) = gammaRate.toInt(2) * epsilonRate.toInt(2)

//----------A-------------
fun getGammaRate(input: List<String>): String {
    val columns = input[0].indices  //skapar en intRange över alla index per rad (=antalet bits i binären)
    val gammaRate = buildString {//skapar en StringBuilder
        columns.forEach({
            val (zeroes, ones) = input.countBitsInColumn(it)
            val mostCommonBit = if (zeroes > ones) '0' else '1'
            append(mostCommonBit)   //appendar till gammaRate
        })
    }
    return gammaRate
}

fun getEpsilonRate(gammaRate: String) = gammaRate.asIterable().joinToString("") { if (it == '0') "1" else "0" }
//epsilonRate är motsatsen till gammaRate, så jag bygger en ny String som går igenom varje char och ersätter med motsatsen

private fun List<String>.countBitsInColumn(column: Int): BitCount {    //extensionfunktion för att räkna 1:or och 0:or
    var zeroes = 0
    var ones = 0
    for (line in this) {
        if (line[column] == '0') zeroes++ else ones++
    }
    return BitCount(zeroes, ones)   //returnerar resultat för båda siffrorna
}

private data class BitCount(val zeroes: Int, val ones: Int) //dataklass för att få koden lättläst

//----------B-------------
private fun getRatingAsString(input: List<String>, gas: Gas): String {
    val columns = input[0].indices
    var candidates = input
    for (column in columns) {
        val (zeroes, ones) = candidates.countBitsInColumn(column)
        val mostCommonBit = if (zeroes > ones) '0' else '1'
        candidates = candidates.filter { cand ->
            when (gas) {
                Gas.OXYGEN -> cand[column] == mostCommonBit
                Gas.CO2 -> cand[column] != mostCommonBit
            }
        }
        if (candidates.size == 1) break
    }
    return candidates.single()
}

private enum class Gas {
    OXYGEN,
    CO2
}
