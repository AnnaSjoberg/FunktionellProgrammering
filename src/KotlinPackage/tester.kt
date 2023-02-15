package KotlinPackage

fun showAnd(first: Boolean, second: Boolean) {
    if (first == second) println("$first && $second == $first")
    else println("$first && $second == false")
}

fun showOr(first: Boolean, second: Boolean) {
    if (first || second) println("$first || $second == true")
    else println("$first || $second == false")
}

fun showTruthTable() {
    (showAnd(true, true))
    (showAnd(true, false))
    (showAnd(false, true))
    (showAnd(false, false))
    (showOr(true, true))
    (showOr(true, false))
    (showOr(false, true))
    (showOr(false, false))
}

fun main() {
    showTruthTable()
    val list = listOf<String>("vJrwpWtwJgWr", "hcsFMMfFFhFp")
    println(test(list))
}

fun test(list:List<String>):Char{
    var a: String = list[0]
    var b: String = list[1]
    var counter: Int = 0
    var temp: Char

    for (c in a) {
        if (c == b[counter])
            return c
        else counter++
    }
    return 'X'
}