package InUppg2.AOC.Y2021.D03

import java.io.File
// Källa: https://todd.ginsberg.com/post/advent-of-code/2021/day3/
fun main() {
    val binaryStrings: List<String> = File("src/InUppg2/AOC/Y2021/D03/sample").readLines()

    val answerA = calculator(getRates(binaryStrings))
    println(answerA)

    val pairB = binaryStrings.bitwiseFilter(GasType.OXYGEN) to binaryStrings.bitwiseFilter(GasType.CO2)
    val answerB = calculator(pairB)
    println(answerB)

}

fun getRates(input: List<String>): Pair<String, String> {
    val gamma = input[0].indices.map { column ->    //går igenom varje rad och tittar på biten på rätt index (=column)
        if (input.count { it[column] == '1' } > input.size / 2) '1' else '0'    //räknar alla 1:or, kollar om de utgör mer än hälften
    }.joinToString("")//bygger en string av resultatet (=gamma)

    val epsilon = gamma.map { if (it == '1') '0' else '1' }.joinToString("")    //epsilon är "motsatsen" till gamma

    return (gamma to epsilon)
}

fun calculator(pair: Pair<String, String>) = pair.first.toInt(2) * pair.second.toInt(2)
//omvandlar de binära strängarna i paret till bas-2 tal och multiplicerar dem

//------------------B------------------

private enum class GasType {        //Källa för att använda enums: https://blog.jetbrains.com/kotlin/2021/12/advent-of-code-2021-in-kotlin-day-3/
    OXYGEN,
    CO2
}
private fun List<String>.bitwiseFilter(gasType: GasType): String =
    this[0].indices.fold(this){binaryStrings, column ->    //återigen columns utifrån index på första strängen i listan
        if (binaryStrings.size == 1) binaryStrings else {         //bryter när det bara är en string var i listan
            val split = binaryStrings.partition { it[column] == '1' }   //delar på ifall tecknet är 1 eller inte
            when (gasType){
                GasType.OXYGEN -> split.mostCommon()//delar på vanligaste siffran
                GasType.CO2 -> split.leastCommon()// delar på ovanligaste siffran
            }
        }
    }.single()  //skickar tillbaks den återstående strängen


private fun <T> Pair<List<T>, List<T>>.mostCommon(): List<T> =     //extension. om första listan är lika eller längre än andra (returnerar längsta
    if (first.size >= second.size) first else second

private fun <T> Pair<List<T>, List<T>>.leastCommon(): List<T> =    //extension. om andra listan är lika eller längre än första (returnerar kortaste)
    if (first.size < second.size) first else second