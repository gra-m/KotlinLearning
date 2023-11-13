//Created by Graham Duthie on 13/11/2023 11:44 -1h
package `fun`.madeby.learnkotlin

open class Enemy1(var health: Int, var weapon: String) {
    init {
        println("Enemy init called")
    }

    open fun attack() {
        println("attacking with $weapon")
    }
}

class Archer1(health: Int, var arrowCount: Int) : Enemy1(health, "bow") {
    init {
        println("Archer init called, archer has $arrowCount arrows")
    }

    override fun attack() {
        if (arrowCount <= 0) {
            println("No arrows to attack with!")
        } else {
            super.attack()
            println("Archer attacks with 5 arrows")
            arrowCount -= 5
        }

    }
}

class Pikeman1(health: Int, var armour: Int) : Enemy1(health, "pike") {
    init {
        println("Pikeman init called")
    }
}



fun main() {
    var pikeman = Pikeman1(100, 100)
    var archer = Archer1(100, 5)

    pikeman.attack()
    archer.attack()
    archer.attack()
    

}