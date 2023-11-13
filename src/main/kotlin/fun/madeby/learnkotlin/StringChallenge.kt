//Created by Graham Duthie on 10/11/2023 13:50 -1h
package `fun`.madeby.learnkotlin

import java.util.*

var names = arrayOf(
    "Timmy", "Trix", "Tinkerbell", "Henry", "Void", "Incantation"
)

fun main() {

    for (n in names) {
        if (n[0] == 'T')
            println(n.uppercase(Locale.getDefault()))
        if(n.startsWith("V"))
            println(n.lowercase())
            
    }

}