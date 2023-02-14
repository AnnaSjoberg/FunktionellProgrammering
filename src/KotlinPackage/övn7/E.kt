package KotlinPackage.övn7

fun main(){


    fun parenthesisCounter(word: String, counter: Int): Int{
        if (word.length==0)return counter

        return when(word.first()){
            '('->parenthesisCounter(word.takeLast(word.count()-1),counter+1)
            ')'->parenthesisCounter(word.takeLast(word.count()-1),counter-1)
            else->parenthesisCounter(word.takeLast(word.count()-1),counter)
        }
    }
    fun isBalanced(word:String)= if(parenthesisCounter(word,0)==0) true else false

    println(isBalanced("((:-))"))
    println(isBalanced("()((()))(())("))
}