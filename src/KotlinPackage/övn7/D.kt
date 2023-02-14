package KotlinPackage.övn7

fun main(){

    fun reverseString(ch: List<Char>){
        if (ch.size==0)return
        reverseString(ch.takeLast(ch.count()-1))
        println(ch.first())
    }

    val string = "hejsan"
    val asChars = string.toList()
    reverseString(asChars)

}
