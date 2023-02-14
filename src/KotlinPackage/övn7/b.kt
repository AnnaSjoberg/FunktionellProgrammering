package KotlinPackage.övn7

fun main(){

    fun calcSum(values : List<Int>):Int{

        tailrec fun calcSumAcc(sum: Int, i: Int) : Int{
            if (i<0) return  sum
            return calcSumAcc(sum+values[i],i-1)
        }
        return calcSumAcc(0,values.size-1)
    }

//    println(calcSum(listOf(1,2,3,4,5)))
var ints = mutableListOf((-10..10).random())
    println(ints[0])
    var num=1
    while(num <6){
        ints.add((-3..3).random())
        println(ints[num])
        num++
    }
println(calcSum(ints))
}