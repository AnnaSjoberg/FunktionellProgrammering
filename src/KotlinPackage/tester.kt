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
    val list = listOf(1,2,3,4,5,6,7,8,9,10,11,12)
    println(list.slice(0..3).sum())
    println(list.subList(0,3).sum())
}


