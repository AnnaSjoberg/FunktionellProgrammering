package KotlinPackage

fun main() {
    while (true) {
        println("Spelare 1, skriv in ditt val: ")
        var choicePlayer1 = readLine()
        when (choicePlayer1) {
            "Rock" -> {
                print("Spelare 1: rock")
                break;
            }
            "Paper" -> print("Spelare 1: paper")
            "Scissors" -> print("Spelare 1: scissors")
            else -> println("Fel inmatning, försök igen:")
        }

    }

    while (true) {
        println("Spelare 2, skriv in ditt val: ")
        var choicePlayer2 = readLine()
        when (choicePlayer2) {
            "Rock" -> println("Spelare 2: rock")
            "Paper" -> println("Spelare 2: paper")
            "Scissors" -> println("Spelare 2: scissors")
            else -> println("Fel inmatning, försök igen:")
        }
        break;
    }
}
