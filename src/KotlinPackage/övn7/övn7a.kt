package KotlinPackage

fun main(){

   tailrec fun interest(capital: Double, years: Int, interestRate: Double) : Double {
        if (years==1) return capital*interestRate

        return interest(capital*interestRate, years-1, interestRate)
    }


    println(interest(205000.0,15,1.007))
}

//ränta på ränta