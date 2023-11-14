//Created by Graham Duthie on 13/11/2023 12:26 -1h
package `fun`.madeby.learnkotlin

open class SuperEnemy(health: Int, var damage: Int, var weapon: String, attacks: Int, ammo: Int) {
    var attacks = 0
    // ammo is a limit to the number of attacks before a reload is required set to -15 for non ammo using
    // characters to provide flexibility for specials.
    var ammo = 0
    var health = 0
        set(value) {
            field = value // as in health field
            if (field < 0)
                field = 0
        }
    var alive get() = health > 0
    var isRanged get() = ammo > -1


    init{
        println("SuperEnemy init()")
        this.health = health
        this.alive = true
        this.ammo = ammo
        this.isRanged = ammo > -1
        this.attacks = attacks
    }

    fun attack(enemy : SuperEnemy): Int {
        println("Attacking $attacks times with $weapon")
        var remainingAttackActions = attacks
        var attacksThisRound = remainingAttackActions

        for(i in 1.. attacksThisRound) {
            println("attacking, remaining attacks = $remainingAttackActions")
            if (enemy.alive && ammo > 0) {
                enemy.takeDamage(this.damage)
                println("Enemy taking ${this.damage}")
                ammo--
                remainingAttackActions--
            } else if (ammo == 0) {
                if (remainingAttackActions < 2) {
                    return remainingAttackActions
                } else {
                    remainingAttackActions -= 2
                    ammo = attacks
                    println("Reloading $weapon at cost of two attack actions")
                    if (remainingAttackActions == 0)
                        return remainingAttackActions
                }
            }
            if (!enemy.alive) {
                println("You killed the enemy")
                return remainingAttackActions
            }
        }
        return 0
    }

    open fun takeDamage(damageToTake: Int) {
        println("they took $damageToTake damage")
        health -= damageToTake
    }
}

class SubPikeman(health: Int, armor: Int) : SuperEnemy(health, 15, "pike", 1, -15) {
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

    class SubBowman(health: Int) : SuperEnemy(health, 5, "bow", 5, 5, ) {

        init {
            println("SubBowman init()")
        }

    }
    class Pistolero(health: Int) : SuperEnemy(health, 6, "pistol", 6, 6) {

        init {
            println("Pistolero init()")
        }

    }

fun main() {
    var pikeman: SuperEnemy = SubPikeman(25, 25)
    var pistolero1: SuperEnemy = Pistolero(25)
    var bowman : SuperEnemy = SubBowman(25)

    println(pistolero1.alive)

/*    while (pistolero.alive) {
        pikeman.attack(pistolero)
        println(pistolero.health)
    }*/

    var count = 1
    while (pikeman.alive) {
       println("REPORT: Remaining attacks after attack $count by Pistolero on Pikeman: ${pistolero1.attack(pikeman)}")
       println(pikeman.health)
       count++
    }

    //pikeman.attack(bowman)

}