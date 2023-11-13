//Created by Graham Duthie on 13/11/2023 10:02 -1h
package `fun`.madeby.learnkotlin

import `fun`.madeby.learnkotlin.StringUtils.startsWithUpperCaseLaboured
import `fun`.madeby.learnkotlin.StringUtils.startsWithUppercase

object StringUtils {
    // ? == is nullable, allow calls with null
    fun startsWithUpperCaseLaboured(value: String?) : Boolean {
        if (value.isNullOrBlank())
            return false
        return value[0].isUpperCase() // !! is not needed as have tested for null
    }

    fun startsWithUppercase(value: String?) = !(value.isNullOrBlank()) && value[0].isUpperCase()
}
fun main() {

    var word = "Word"

    println("The word is ${word.lowercase()} only in the instance displayed here when first letter converted to lower-case")
    println("Word is still $word")

    println("blank is ${startsWithUppercase("")}")
    println("blank is ${startsWithUpperCaseLaboured("")}")
    println("\"kotlin\" is ${startsWithUppercase("kotlin")}")
    println("\"Kotlin\" is ${startsWithUpperCaseLaboured("Kotlin")}")
    println("word is ${startsWithUppercase(word)}")
    println("\"word\" is ${startsWithUppercase("word")}")
    



}