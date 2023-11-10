//Created by Graham Duthie on 10/11/2023 16:58 -1h
package `fun`.madeby.learnkotlin


class Player {
    private var health = 150
    private var alive = true

    fun reduceHealth(amount: Int) {
        setHealth(health - amount)
    }

    private fun setHealth(amount: Int) {
        if (amount < 0) {
            health = 0
            alive = false
        } else
            health = amount
    }

    fun respawn() {
        if (!alive) {
            alive = true
            setHealth(150)
            return
        }
        println("Player is not dead!")
    }

    fun status() = println("Player has $health health and isAlive == $alive")
}

fun main() {

    var player = Player()
    player.respawn()
    player.status()
    player.reduceHealth(175)
    player.status()
    player.respawn()
    player.status()
    



}