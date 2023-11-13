//Created by Graham Duthie on 13/11/2023 11:44 -1h
package `fun`.madeby.learnkotlin

open class Enemy(var health: Int, var weapon: String) {
    init {
        println("Enemy init called")
    }

    fun attack() {
        println("attacking with $weapon")
    }
}

class Archer(health: Int, var arrowCount: Int) : Enemy(health, "bow") {
    init {
        println("Archer init called")
    }
}

class Pikeman(health: Int, var armour: Int) : Enemy(health, "pike") {
    init {
        println("Pikeman init called")
    }
}



fun main() {
    var pikeman = Pikeman(100, 100)
    var archer = Archer(100, 5)

    pikeman.attack()
    archer.attack()
    

}