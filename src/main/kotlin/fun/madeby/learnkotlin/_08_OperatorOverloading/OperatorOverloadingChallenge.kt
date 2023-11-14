//Created by Graham Duthie on 14/11/2023 15:16 -1h
package `fun`.madeby.learnkotlin._08_OperatorOverloading


class ComplexNumber(val real: Float, val imaginary: Float) {

    operator fun plus(other: ComplexNumber) :ComplexNumber {
        return ComplexNumber(real + other.real, imaginary + other.imaginary)
    }

    operator fun minus(otherComplexNumber: ComplexNumber) : ComplexNumber {
        return ComplexNumber(real - otherComplexNumber.real, imaginary - otherComplexNumber.imaginary)
    }

    operator fun times(otherComplexNumber: ComplexNumber) : ComplexNumber {
        // why wiki? Just watch
        val realResult = real * otherComplexNumber.real - imaginary * otherComplexNumber.imaginary
        val imaginaryResult =  imaginary * otherComplexNumber.real + real * otherComplexNumber.imaginary
        return ComplexNumber(realResult, imaginaryResult)
    }


    override fun toString(): String {
        return "ComplexNumber(real=$real, imaginary=$imaginary)"
    }
}

fun main() {
    val first = ComplexNumber(2f, 2f)
    val second = ComplexNumber(3f, -5f)

    val sum = first + second
    val minus = first - second
    val times = first * second

    println("Sum = ${sum}")
    println("Minus = ${minus}")
    println("Multiply = ${times}")
}

