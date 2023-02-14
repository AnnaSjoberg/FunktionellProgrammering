package InUppg2.AOC.Y2021.D02

import java.io.File
import java.util.*


fun main() {
    val scanner = Scanner(File("src/InUppg2/AOC/Y2021/D02/input"))

    var aim = 0
    var horizontal = 0
    var depth = 0

    while (scanner.hasNext()) {
        val temp = scanner.nextLine().split(' ')
        val dir = temp.first()
        val num = temp.last().toInt()
        when (dir){
            "forward"-> {
                horizontal += num
                depth += (aim * num)
            }
            "up"-> aim-=num
            "down"->aim+=num
        }


    }
    println("$depth * $horizontal = ${depth*horizontal}")

}