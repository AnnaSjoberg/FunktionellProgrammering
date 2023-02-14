package KotlinPackage.övn5

fun String.DoubleUp() = repeat(2)
fun String.PrintRepeat(i:Int)= println(repeat(i))



fun main() {
    val s = "hi"

    println(s.DoubleUp())

    s.PrintRepeat(5)
}