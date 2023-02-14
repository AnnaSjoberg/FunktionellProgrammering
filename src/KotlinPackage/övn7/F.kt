package KotlinPackage.övn7

fun main(){

    fun fibAtIndex(index:Int): Int{
        val numbers = mutableListOf<Int>(1,2)

        tailrec fun fib2(first: Int, second: Int): Int {
            val next = first + second
            numbers.add(next)
            if (index+1 == numbers.size) return numbers.get(numbers.size-1)
            return fib2(second, next)
        }
        if (index<2) return numbers.get(index)
        return fib2(numbers.get(0),numbers.get(1))
    }

    println(fibAtIndex(1))

}