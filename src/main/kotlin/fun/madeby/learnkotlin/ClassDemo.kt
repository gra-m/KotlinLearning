//Created by Graham Duthie on 10/11/2023 15:10 -1h
package `fun`.madeby.learnkotlin

class Dog constructor(private val color: String = "black") {
    init {
        println("dog initialized with color value = $color")
    }

    fun printColor() = println("color = $color")
}

class Cat(private val name: String = "Tom", private val age: Int = 5) {
    //private val age = 5

/*    constructor(name: String = "Tom", age: Int = 5): this(name) {
        this.age = age
    }*/

    fun printCatDetails() = println("Cat is $age years old and is named $name")
}

fun main() {
    val dog = Dog()
    val dog2 = Dog("grey")
    dog.printColor()

    val cat = Cat()
    val cat2 = Cat("Wiggle")
    val cat3 = Cat("Xaggle", 6)

    cat.printCatDetails()
    cat2.printCatDetails()
    cat3.printCatDetails()

}