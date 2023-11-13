//Created by Graham Duthie on 10/11/2023 18:22 -1h
package `fun`.madeby.learnkotlin

class Person (private var firstName: String, private var lastName: String, age: Int) {

    private var fullName = "$firstName $lastName"

    private var age = 0
        set(value) {
            println("setting age block")
            var newAge = value
            if(value > 100)
                newAge = 99
            if(value < 0 )
                newAge = 1
            field = newAge
        }
    
    init {
        this.age = age
    }

    fun printInfo() = println("$firstName, $lastName, $age, $fullName")

}


fun main() {
    var person = Person("Honry", "Singer", 199)

   person.printInfo()

}
