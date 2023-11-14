//Created by Graham Duthie on 14/11/2023 15:16 -1h
package `fun`.madeby.learnkotlin._08_OperatorOverloading

class ComplexNumber(val real: Float, val imaginary: Float) {}

fun main() {
    val first = ComplexNumber(2f, 2f)
    val second = ComplexNumber(3f, -5f)

    val sum = first + second
    
}