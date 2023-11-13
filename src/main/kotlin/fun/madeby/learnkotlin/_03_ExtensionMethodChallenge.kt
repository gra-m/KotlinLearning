//Created by Graham Duthie on 13/11/2023 10:46 -1h
package `fun`.madeby.learnkotlin

/**
 * Write extension method for:
 * String even chars == true/false
 * test with inputs
 * create StringUtils object and add fun that calculates sum of two string lengths
 *
 */

object StringUtils3 {
    fun returnSumOfChars(val1: String?, val2: String?): Int {
        if (val1.isNullOrEmpty() && val2.isNullOrEmpty())
            return 0
        else if (val1.isNullOrEmpty())
           return val2!!.length
        else if (val2.isNullOrEmpty())
            return val1.length
        

        return val1.length + val2.length
    }
}

fun String?.evenStringChars() = !(this.isNullOrEmpty()) && this.length % 2 == 0


fun main() {
    var myStr1 = "hollow"
    var myStr2 = "world"

    println(myStr1.evenStringChars())
    println(myStr2.evenStringChars())
    println("Sum of chars = ${StringUtils3.returnSumOfChars(myStr1, myStr2)}")
    println("Sum of chars = ${StringUtils3.returnSumOfChars("", myStr2)}")
    println("Sum of chars = ${StringUtils3.returnSumOfChars(null, myStr2)}")
    println("Sum of chars = ${StringUtils3.returnSumOfChars(myStr1, "")}")
    println("Sum of chars = ${StringUtils3.returnSumOfChars(myStr1, null)}")
}