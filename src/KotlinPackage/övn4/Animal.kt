package KotlinPackage.övn4

import java.util.*

class Animal(var species: String, var numberOfLegs: Int) {

    fun printSpecies() = println(species)

    fun printLegs() = println(numberOfLegs)

    fun printAllInfo() = println("$species and has $numberOfLegs legs")
}

fun Animal.CallSound(){
    when (this.species) {
        "dog" -> println("Wroof")
        "cat" -> println("Mjaou")
        "anaconda" -> println("Sssss")
        "millipede" -> println("Pitter patter")
        "emu" -> println("Screeech")
    }
}

fun main() {
    val dog = Animal("dog", 4)
    val anconda = Animal("anaconda", 0)
    val millipede = Animal("millipede", 250)
    val emu = Animal("emu", 2)
    val cat = Animal("cat",4)

    //4B
    val animalList = mutableListOf(dog, anconda, millipede, emu)
    for (a in animalList) a.printAllInfo()
    println()
    //4C
    val set1 = setOf(anconda, dog, emu, millipede, dog, anconda, millipede, emu, dog)
    val set2 = setOf(millipede, emu, dog, anconda)
    for (a in set1) a.printAllInfo()
    println()
    for (a in set2) a.printAllInfo()
    println(set1.equals(set2))
    //4D
    val myMap = mapOf("Doug" to dog, "Anna" to anconda, "Millie" to millipede, "Emy" to emu)
    for ((k,v) in myMap) println("$k is a/an ${v.species}")
    println()
    //4E
    animalList.add(cat)
    for (a in animalList) a.CallSound()
    println()

    for (a in animalList.sortedBy { a->a.numberOfLegs }) a.CallSound()

}