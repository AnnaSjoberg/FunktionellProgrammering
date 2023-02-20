package KotlinPackage.övn8

import java.util.*

fun textDistortion(input: String, action: (String) -> String) {
    println(action(input))

}

fun toUpperCase(string: String) = string.uppercase()

fun removeAllDigits(string: String) = string.filterNot { it.isDigit() }


fun main() {
    while (true) {
        println("säg nånting")

        val input = readln()

        if (input.count { it.isDigit()  } > 0)
            textDistortion(input, { removeAllDigits(input) })
        else
            textDistortion(input, { toUpperCase(input) })

    }

}