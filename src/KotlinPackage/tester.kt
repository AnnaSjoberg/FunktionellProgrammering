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
}