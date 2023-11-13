//Created by Graham Duthie on 10/11/2023 11:08 -1h
package `fun`.madeby.learnkotlin

var lives = 3
var playerName: String = "Jimbo"
var gameOver: Boolean = false
var score = 0
var coinCount = 90


val iAmAConstant: String = "I am immutable!"
val itemCount = 24
val itemsPerPage = 25
var array = arrayOf("his", "her", "hat")
var table = arrayOf(
     intArrayOf(1, 2, 3),
     intArrayOf(4, 5, 6),
     intArrayOf(7, 8, 9)
)

fun main() {
// Arrays
     for(i in array.indices)
          println(array[i])

     for (whatever in array)
          println("whatever $whatever")
// Ranges
     for(value in 1..10)
          println(value)

     for(value in 1..10 step 2)
          println(value)
// Table access with ranges:
     for(row in 0..table.size-1)
          for(col in 0 until table[row].size) {
               print("in row $row col $col ")
          }
     

     println("\nplayer $playerName has $lives lives left")

     //iAmAConstant = "asdfas"
     println("Score = $score")
     score +=10
     println("Score now = $score")

     if (iAmAConstant.equals("I am immutable!"))
          println("It was equal")

     // If can be used as an expression:

     val max = if(itemsPerPage > itemCount) itemsPerPage else itemCount

     println("max is $max")


}