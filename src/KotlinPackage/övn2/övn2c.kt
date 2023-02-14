package KotlinPackage

fun main() {

    fun isPrimeNumber(testVal: Int): Boolean {
        for (i in 2 until testVal)
            if (testVal%i==0) return false

        return true
    }

    println(isPrimeNumber(17))


}