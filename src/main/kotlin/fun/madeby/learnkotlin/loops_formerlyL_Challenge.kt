//Created by Graham Duthie on 10/11/2023 13:17 -1h
package `fun`.madeby.learnkotlin

class Brick(x: Float, y: Float) {

}

fun main() {
    var sum = 0
    for(i in 1..100) {
        sum+= i
        print(i)
    }

    println("\n" + sum);


    fun createWall(): Array<Brick> {
        val bricks = arrayOf<Brick>()
        val startX = 5f
        val startY = 985f
        val rowSpacing = 5f
        val colSpacing = 10f
        val brickHeight = 10f
        val brickWidth = 50f
        var brickCount = 0

        // behind the scenes this is a trad for(Int i = 0; i < 5; i++)
        repeat(5) { row ->
            val brickY =  startY - row * ( rowSpacing + brickHeight)
            repeat(10) { col ->
                val brickX = startX + col * (colSpacing + brickWidth)
                bricks.set(brickCount, Brick(brickX, brickY))
                brickCount++
            }
        }
        return bricks
    }

    fun loopNotIterableWithIndex() {

        // why? without index i counts down from 3
        for ((index, i) in (0..3).withIndex()) {
            if (lives <= index) {
                // do something
            }
            // do something
            }
        }
    }

}


