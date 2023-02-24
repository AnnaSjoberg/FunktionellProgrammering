package KotlinPackage

import java.util.*

fun main() {
    val name: String = "Hitesh"
    when {
        name.equals(name.uppercase(Locale.getDefault()), true) -> {     //kan vara också name.lowercase....
            println("$name: ${name.uppercase()} / ${name.lowercase()}")
            // DO SOMETHING
        }
    }

    val s: String = "TOMTE"
    while (true) {
        println("Write tomte")
        val input = readln()
        if (s.equals(input, ignoreCase = true)) {
            println(s)
        }
    }
}
