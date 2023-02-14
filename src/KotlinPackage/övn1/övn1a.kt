package KotlinPackage

fun main() {

    val fullLength: Int = 300
    val usedLength: Int = 55
    val startHours: Int = 16
    val startMinutes: Int = 30
    val stopHours: Int = 20
    val stopMinutes: Int = 50
    val minutesPerHour = 60

    fun availableSpace(fullLength: Int, usedLength: Int) = fullLength - usedLength

    fun programLength(startHours: Int, startMinutes: Int, stopHours: Int, stopMinutes: Int): Int {
        fun hoursToMinutes(startHours: Int, stopHours: Int) = (stopHours - startHours) * minutesPerHour

        return hoursToMinutes(startHours, stopHours) + (stopMinutes - startMinutes)
    }

    fun doesItFit(space: Int, time: Int) = (space>=time)

    val available = availableSpace(fullLength, usedLength)
    val length = programLength(startHours, startMinutes, stopHours, stopMinutes)

    if (doesItFit(available,length)) println("Woohoo") else println("Bummer")



}
/*
    val result = doesItFit(availableSpace(fullLength, usedLength),programLength(startHours, startMinutes, stopHours, stopMinutes))
    println(result)

    val available = availableSpace(fullLength, usedLength)
    val length = programLength(startHours, startMinutes, stopHours, stopMinutes)

    val result = doesItFit(available,length)
    println(result)
 */