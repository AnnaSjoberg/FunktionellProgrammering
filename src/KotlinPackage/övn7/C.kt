package KotlinPackage.övn7

fun main(){

    fun findMax(ints: List<Int>):Int{

        tailrec fun findInnerMax (max: Int, counter: Int):Int{
            if (counter == ints.size) return max

            return findInnerMax(if(ints[counter]>max)ints[counter] else max, counter+1)
        }

        return findInnerMax(ints[0],0)
    }
    val ints = mutableListOf((-10..10).random())
    println(ints[0])
    var num=1
    while(num <6){
        ints.add((-10..10).random())
        println(ints[num])
        num++
    }
    println(findMax(ints))
}
//titta på två värden, konstatera det högsta, jämföra detta med ytterligare ett, tills alla gåtts igenom