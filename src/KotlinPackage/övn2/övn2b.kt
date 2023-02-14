package KotlinPackage

fun main() {

    fun partOfTable(table: Int, start: Int, end: Int) {
        for (i in start..end) println(i * table)
    }

    partOfTable(10,11,17)
}