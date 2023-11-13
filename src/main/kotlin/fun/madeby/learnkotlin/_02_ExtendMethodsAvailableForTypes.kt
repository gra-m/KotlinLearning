//Created by Graham Duthie on 13/11/2023 10:02 -1h
package `fun`.madeby.learnkotlin
import `fun`.madeby.learnkotlin.StringUtils.startsWithUpperCaseLaboured
import `fun`.madeby.learnkotlin.StringUtils.startsWithUppercase

/**
 * You can add new methods to types within your program using extension methods:
 */
object StringUtils2 {
    // ? == is nullable, allow calls with null
    fun startsWithUpperCaseLaboured(value: String?) : Boolean {
        if (value.isNullOrBlank())
            return false
        return value[0].isUpperCase() // !! is not needed as have tested for null
    }

    fun startsWithUppercase(value: String?) = !(value.isNullOrBlank()) && value[0].isUpperCase()
}

// this refers to the type being extended with an extension method:
fun String?.startsWithUpperCase() : Boolean = !(this.isNullOrBlank()) && this[0].isUpperCase()
fun Int.multiplyBy(multiplier: Int) = this * multiplier
infix fun Float.multiplyBy(multiplier: Float) = this * multiplier


fun main() {

    var word = "Word"
    var integer = 5
    var float = 5.0

    // showing extension methods added by you to an existing type

    println("Now calling an extension method that has been added to type String: ${word.startsWithUpperCase()}")
    println("Now calling an extension method that has been added to type Int: ${integer.multiplyBy(5)}")
    println("Now calling an extension method that has been added to type Float.. \n..and annotated with \"infix\" : ${5.0f multiplyBy 5.0f}")


    // showing object methods == like static methods
    println("The word is ${word.lowercase()} only in the instance displayed here when first letter converted to lower-case")
    println("Word is still $word")

    println("blank is ${startsWithUppercase("")}")
    println("blank is ${startsWithUpperCaseLaboured("")}")
    println("\"kotlin\" is ${startsWithUppercase("kotlin")}")
    println("\"Kotlin\" is ${startsWithUpperCaseLaboured("Kotlin")}")
    println("word is ${startsWithUppercase(word)}")
    println("\"word\" is ${startsWithUppercase("word")}")


    



}