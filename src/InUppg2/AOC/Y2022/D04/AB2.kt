package InUppg2.AOC.Y2022.D04

import java.io.File
//Källa: https://todd.ginsberg.com/post/advent-of-code/2022/day4/
//Hade själv redan från början tänkt att jag ville använda Pair<IntRange, IntRange> men kunde inte räkna ut exakt hur jag skulle göra
//Hade också löst denna i Java i december
fun main() {
    val input: List<String> = File("src/InUppg2/AOC/Y2022/D04/input").readLines()

    val ranges = input.map { it.asRanges() }

    val answerA = ranges.count { it.first totalOverlap it.second || it.second totalOverlap it.first }
    println(answerA)

    val answerB = ranges.count{it.first partialOverlap it.second}
    println(answerB)
}

private fun String.asIntRange(): IntRange =
    substringBefore('-').toInt()..substringAfter('-').toInt()

private fun String.asRanges(): Pair<IntRange,IntRange> =
    substringBefore(',').asIntRange() to substringAfter(',').asIntRange()

private infix fun IntRange.totalOverlap(other:IntRange): Boolean =  //infix - gör så jag kan slippa sätta den andra rangen i () vid anropet
    this.first <= other.first && this.last >= other.last  //this behövs inte, men la dit för tydlighet.

private infix fun IntRange.partialOverlap (other: IntRange): Boolean =
    this.first <= other.last && other.first <= this.last