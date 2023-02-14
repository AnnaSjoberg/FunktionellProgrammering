package KotlinPackage


fun main() {

    println("Guess my number")
    var randomInt = (1..10).random()
    while (true) {
        try {
            var wrong = true
            while (wrong) {
                val guess = readLine()!!.toInt()
                if (guess < randomInt) println("Higher")
                else if (guess > randomInt) println("Lower")
                else if (guess == randomInt) {
                    wrong = false
                    println("You were correct!")
                }

            }
            println("Play again?")
            if (readLine() == "no") break
            else {
                randomInt = (1..10).random()
                println("Guess my number")
            }
        } catch (e: NumberFormatException) {
            println("You must write a number")
        }
    }
}