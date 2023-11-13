//Created by Graham Duthie on 10/11/2023 16:58 -1h
package `fun`.madeby.learnkotlin


class PlayerA {
    private var health = 150
        set(value) {
            println("setter block")
            var newHealth = value
            if (value <= 0) {
                newHealth = 0
            }
            field = newHealth // field keyword translates to health field
        }

    // Properties are data oriented, and do not apply side effects, I have never found a definition before!
    val alive get() = health > 0

    fun reduceHealth(amount: Int) {
       health -= amount
    }


    fun respawn() {
        if (!alive) {
            health = 150
            return
        }
        println("Player is not dead!")
    }

    fun status() = println("Player has $health health and isAlive == $alive")
}

fun main() {

    var player = PlayerA()
    player.respawn()
    player.status()
    player.reduceHealth(175)
    player.status()
    player.respawn()
    player.status()
    println(player.alive)
    



}