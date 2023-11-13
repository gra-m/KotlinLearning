//Created by Graham Duthie on 10/11/2023 14:34 -1h
package `fun`.madeby.learnkotlin

var a = 34;
var b = 34;

fun main() {

    fun increment(number: Int)  = number + 1
    fun aGreaterThanB(a: Int, b: Int) =  a > b
    a = increment(a)
    println("T/F $a is greater than $b == ${aGreaterThanB(a, b)}")


    fun getInt() = 10

    fun getIntWithBody(): Int {
        return 10 + 11 - 4
    }


    fun sum (a: Int, b: Int) = a + b

    fun printSum(a: Int, b: Int) = println("$a + $b = ${a + b}")

    // Overloading

    fun sum (a: Int, b: Int, c: Int) = a + b + c

    fun sum (a: Int, b: Int, c: Int, d: Int) = a + b + c + d

    println("sum 12 = ${sum(1,2)}, and 123 = ${sum(1, 2, 3)} and sum 1234 = ${sum(1,2,3,4)}")
}