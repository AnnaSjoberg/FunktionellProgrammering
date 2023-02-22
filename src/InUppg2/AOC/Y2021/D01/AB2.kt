package InUppg2.AOC.Y2021.D01


fun countIncreasesWindowed(depths: List<Int>, window: Int=2) = depths.windowed(window).count { it[0] < it[window-1] }
//parar ihop värden två och två och räknar de instanser där djupet ökar
//för B-uppgiften kan man jämföra direkt A-D istället för ABC-BCD
//källa https://kotlinlang.org/docs/advent-of-code.html#day-1-sonar-sweep
//eget tillägg till funktionen att skicka in window så att samma funktion kan användas för båda delarna.


fun main() {
    val depths = fromFileToList("src/InUppg2/AOC/Y2021/D01/input")

    val a = countIncreasesWindowed(depths)
    println(a)

    val b = countIncreasesWindowed(depths,4)
    println(b)


}
