package KotlinPackage.övn9

fun <T> List<T>.filter(predicate: (T) ->Boolean): List<T>{
    val result = mutableListOf<T>()

    for (t in this) {
        if (predicate(t))
            result.add(t)
    }
    return result
}

fun <T> List<T>.map(function: (T)->(T)): List<T>{
    var res = mutableListOf<T>()

    for (t in this) {
        res.add(function(t))
    }
    return res
}

fun main() {

    val l1 = listOf(5,4,3,85,1,-5,8,-78,0,-4)
    val l2 = listOf("hej", "på", "dig", "du")
    val l3 = "Hej jag heter Anna, Vad heter du?"

    l1.filter { it < 0 }.forEach({ println(it) })
    println()
    l2.filter { it.length > 2 }.forEach({ println(it) })
    println()
    l3.filter { it > 100.toChar() }.forEach({ print(it) })

    val intfunc: (i: Int) -> Int = {it*10}
    val stringfunc: (s: String) -> String = {it.uppercase()}
    val charfunc: (c: Char)-> Char = {it+1}
    println()
    //println(l1.map(intfunc).toString())
    println(l1.map(intfunc).joinToString(" , ", "start ", " stop"))
    println(l2.map(stringfunc).joinToString(" ", "start ", " stop"))
    println(l3.map(charfunc).joinToString(" ", "start ", " stop"))
}