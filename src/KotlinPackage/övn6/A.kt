package KotlinPackage.övn6

import KotlinPackage.övn4.Animal

fun main() {
    val dog = Animal("dog", 4)
    val anconda = Animal("anaconda", 0)
    val millipede = Animal("millipede", 250)
    val emu = Animal("emu", 2)
    val cat = Animal("cat", 4)
    val dog2 = Animal("dog", 4)
    val anconda2 = Animal("anaconda", 0)
    val millipede2 = Animal("millipede", 250)
    val emu2 = Animal("emu", 2)
    val cat2 = Animal("cat", 4)

    //A
    val animalList = listOf(dog, anconda, millipede, emu, cat)
    animalList.forEach { it.printSpecies() }
    animalList.forEach({ a -> println("${a.numberOfLegs}") })
    animalList.map({ it.printAllInfo() })
    println()
    //B
    val bList = mutableListOf(dog2, anconda2, millipede2, emu2, cat2)
    bList.map(transform = { it.species = "frog"; it.numberOfLegs = 4 })
    println(bList.mapIndexed { index, animal -> "$index ${animal.species}" })
    println()
    //C
    animalList.forEach({ it.printAllInfo() })
    val result = removeEmus(animalList)
    result.forEach({ it.printAllInfo() })
    println()
    //D
    println(animalList.any({it.species.equals("cat")}))
    println(animalList.any({it.species.equals("spider")}))
    println()
    //E
    animalList.maxBy { it.numberOfLegs }.printSpecies()
    println(animalList.maxOf { it.numberOfLegs })
    println(animalList.maxOfOrNull { it.numberOfLegs })
    println()
    //F
    println(animalList.sumOf { it.numberOfLegs })
    println()
    //G
    println(animalList.count({it.numberOfLegs !=4}))
    println()
    //H
    //val bigList = doubleUpAnimals(animalList)
    val bigList = animalList + animalList
    println(bigList.size)
    bigList.sortedBy { it.species }.forEach({it.printSpecies()})
}

fun removeEmus(list: List<Animal>) = list.filter { it.species != "emu" }   //C

fun doubleUpAnimals (list: List<Animal>) : List<Animal>{
    var result = mutableListOf<Animal>()
    for (animal in list) {
        result.add(animal)
        result.add(Animal(animal.species,animal.numberOfLegs))
    }
    return result
}


