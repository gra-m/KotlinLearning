//Created by Graham Duthie on 10/11/2023 13:59 -1h
package `fun`.madeby.learnkotlin

var person: String? = null


fun main() {
    //person.uppercase() // compilation error
    //person!!.uppercase() // allow null pointer and get a definitive address of where it happened == nice.
    person = person?.uppercase()// only call if not null == null safe operator

   println("person when nullable action called on it: $person ")

    person = "John, person is no longer null"
    person = person?.uppercase()
    println("Now it is no longer null $person")

}