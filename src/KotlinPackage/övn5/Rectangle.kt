package KotlinPackage.övn5

open class Rectangle(val height: Int, val width: Int)

fun Rectangle.AreaCalc() = height * width

fun Rectangle.CircCalc() = (height + width) * 2

fun main() {
    val r1 = Rectangle(5,8)

    println("r1 has a circumference of ${r1.CircCalc()} and an area of ${r1.AreaCalc()}")

    val r2 = Rectangle(r1.AreaCalc(),r1.CircCalc())

    println("r2 has a circumference of ${r2.CircCalc()} and an area of ${r2.AreaCalc()}")


}