//Created by Graham Duthie on 10/11/2023 18:00 -1h
package `fun`.madeby.learnkotlin

class Ship {
    private val bullets = arrayOf("laser", "fire")

    var hitpoints = 100
        private set

    fun takeDamage(amount: Int) {
        hitpoints -= amount

        if (hitpoints < 0)
            hitpoints = 0
    }

    fun fire() {
        var bullet = bullets[0]

        if (hitpoints > 50) {
            bullet = bullets[1]
        }

        println("Firing $bullet bullet at target")
    }
}



fun main() {

    val ship = Ship()
    ship.fire()
    ship.takeDamage(51)
    ship.fire()



}