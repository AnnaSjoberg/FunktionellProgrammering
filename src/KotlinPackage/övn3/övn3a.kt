package KotlinPackage

fun main() {

    while (true) {
        val randomInt = (1..10).random()
        var wrong = true
        println("Guess the number")
        while (wrong) {
            val guess =readLine()!!.toInt()
            if ( guess < randomInt) println("Higher")
            else if (guess > randomInt) println("Lower")
            else if (guess == randomInt) {
                wrong = false
                println("You were correct!")
            }

        }
        println("Play again?")
        if (readLine()=="no") break
    }
}