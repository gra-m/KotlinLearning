//Created by Graham Duthie on 13/11/2023 12:26 -1h
package `fun`.madeby.learnkotlin

open class SuperEnemy(health: Int, var damage: Int, var weapon: String, var reloadable: Boolean, attacks: Int) {
    var attacks = 0;
    var health = 0
        set(value) {
            field = value // as in health field
            if (field < 0)
                field = 0
        }
    var alive get() = health > 0


    init{
        println("SuperEnemy init()")
        this.health = health
        this.alive = true
        this.attacks = attacks
    }

    fun attack(enemy : SuperEnemy) {
        println("Attacking $attacks times")

        for(i in 1.. attacks) {
            println("attacking")
            if (enemy.alive) {
                enemy.takeDamage(this.damage)
                println("Enemy taking ${this.damage}")
            }
        }
        if (!enemy.alive)
            println("You killed the enemy")
    }

    open fun takeDamage(damageToTake: Int) {
        println("they took $damageToTake damage")
        health -= damageToTake
    }
}

class SubPikeman(health: Int, armor: Int) : SuperEnemy(health, 15, "pike", false, 1) {
    var armor = 10

    init {
        println("SubPikeman init()")
        this.armor = armor
    }

    override fun takeDamage(damageToTake: Int) {
        var activeHealth = this.armor + this.health
        var origHealth = this.health
        var origArmor = this.armor
        var adjustedHealth = activeHealth - damageToTake

        println("pre ${this.health}, ${this.armor}")
        // if armor took damage
        if (adjustedHealth >= origHealth) {
            this.armor -= damageToTake
            println("armour existed post ${this.health}, ${this.armor}")
            return
        } else {
            this.armor = 0
            this.health -= damageToTake - origArmor
        }
        println("armour depleted post ${this.health}, ${this.armor}")


    }
}

    class SubBowman(health: Int) : SuperEnemy(health, 5, "bow", true, 5) {

        init {
            println("SubBowman init()")
        }

    }
    class Pistolero(health: Int) : SuperEnemy(health, 6, "pistol", true, 6) {

        init {
            println("Pistolero init()")
        }

    }

fun main() {
    var pikeman: SuperEnemy = SubPikeman(25, 10)
    var pistolero: SuperEnemy = Pistolero(25)
    var bowman : SuperEnemy = SubBowman(25)

    println(pistolero.alive)

/*    while (pistolero.alive) {
        pikeman.attack(pistolero)
        println(pistolero.health)
    }*/
    while (pikeman.alive) {
       pistolero.attack(pikeman)
       println(pikeman.health)
    }

    //pikeman.attack(bowman)

}