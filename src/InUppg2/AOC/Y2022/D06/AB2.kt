package InUppg2.AOC.Y2022.D06

import java.io.File

fun main() {
    val input: List<String> = File("src/InUppg2/AOC/Y2022/D06/input").readLines()

    println(input[0].findMarker(4))
}

private fun String.findMarker(markerSize: Int): Int =
    this.withIndex().windowed(markerSize, 1).first { window ->
        window.map { it.value }.toSet().size == markerSize
    }.last().index + 1
//storlek på window = markerSize, flyttar fram en char i taget,
// first = första fönstret som kunde skapas
//mappa chars toSet så det bara är unika char. jfr med markerSize (om inte settets längd = markerSize är de inte lika)
//last = sista indexet är index för startpositionen. uppgiften vill dock börja räkna från 1 och inte från 0 (därför +1)