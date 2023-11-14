//Created by Graham Duthie on 14/11/2023 13:56 -1h
package `fun`.madeby.learnkotlin._07_Enum

import kotlin.math.ceil

enum class EnemyClassType() {
    HEAVY,
    LIGHT;
    open fun isLight() = this == LIGHT
    open fun isHeavy() = this == HEAVY
}
interface Healable {
    fun heal (amount: Int)
}
// Can heal themselves to an extent dependent on skill
interface SelfHealable {
    fun selfHeal (factor: Int)
}
// Can heal other to an extent dependent on this skill
interface Healer {
    fun healOther(other : SuperEnemy1, factor: Int)
}

abstract class SuperEnemy1(health: Int, var damage: Int, var weapon: String, attacks: Int, ammo: Int, enemyClassType: EnemyClassType) {
    var attacks = 0
    // ammo is a limit to the number of attacks before a reload is required set to -15 for non ammo using
    // characters to provide flexibility for possible specials.
    var ammo = 0
    var health = 0
        set(value) {
            field = value // as in health field
            if (field < 0)
                field = 0
            if (field > 100)
                field = 100
        }
    var alive get() = health > 0
    var isRanged get() = ammo > -1
    var enemyClassType =  EnemyClassType.LIGHT


    init{
        println("SuperEnemy init()")
        this.health = health
        this.alive = true
        this.ammo = ammo
        this.isRanged = ammo > -1
        this.attacks = attacks
        this.enemyClassType = enemyClassType
    }

    fun attack(enemy : SuperEnemy1): Int {
        println("Attacking $attacks times with $weapon")
        var remainingAttackActions = attacks
        var attacksThisRound = remainingAttackActions

        for(i in 1.. attacksThisRound) {
            println("attacking, remaining attacks = $remainingAttackActions")
            if (enemy.alive && ammo > 0) {
                var modifiedDamage = modifyDamage(damage, enemy.enemyClassType)
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

    // This is created with floats in mind, so percentages are rounded to nearest int for now
    private fun modifyDamage(damage: Int, enemyClassType: EnemyClassType): Int {
        val adjustment = damage * 0.1
        val intAdjustment  =  ceil(adjustment).toInt()
        println("intAdjustment on damage is: $intAdjustment")

        if (enemyClassType.isHeavy() && this.enemyClassType.isLight())
            return damage - intAdjustment
        if (enemyClassType.isLight() && this.enemyClassType.isHeavy())
            return damage + intAdjustment

        return damage
    }

    open fun takeDamage(damageToTake: Int) {
        println("they took $damageToTake damage")
        health -= damageToTake
    }

    abstract fun activateSpecial()
}

class SubPikeman1(health: Int, armor: Int) : SuperEnemy1(health, 15, "pike", 1, -15, EnemyClassType.HEAVY), Healable {
    var armor = 10

    init {
        println("SubPikeman1 init()")
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

    override fun activateSpecial() {
        TODO("Not yet implemented")
    }

    override fun heal(amount: Int) {
        TODO("Not yet implemented")
    }
}

class MonkFighter(health: Int, armor: Int, baseHealAbility: Int) : SuperEnemy1(health, 15, "cudgel",
    1, -15, EnemyClassType.HEAVY), Healer, Healable, SelfHealable{
    var armor = 10
    var baseHealAbility = 0

    init {
        println("MonkFighter init()")
        this.armor = armor
        this.baseHealAbility = baseHealAbility
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

    override fun activateSpecial() {
        TODO("Not yet implemented")
    }

    override fun heal(amount: Int) {
        TODO("Not yet implemented")
    }

    override fun healOther(other : SuperEnemy1, factor: Int) {
        if (other is Healable) {
            println("healing other ${other.javaClass.simpleName} current health = ${other.health}")
            other.heal(baseHealAbility * factor)
            println("after healing ${other.javaClass.simpleName} current health = ${other.health}")
        }
    }

    override fun selfHeal(factor: Int) {
        health += baseHealAbility * factor
    }
}

class SubBowman1(health: Int) : SuperEnemy1(health, 5, "bow", 5, 5, EnemyClassType.LIGHT) {

    init {
        println("SubBowman init()")
    }

    override fun activateSpecial() {
        TODO("Not yet implemented")
    }

}
class Pistolero1(health: Int, baseHealAbility: Int) : SuperEnemy1(health, 6, "pistol", 6, 6
, EnemyClassType.LIGHT), SelfHealable, Healable {
    var baseHealAbility = 0

    init {
        println("Pistolero init()")
        this.baseHealAbility = baseHealAbility
    }

    override fun activateSpecial() {
        TODO("Not yet implemented")
    }

    override fun heal(amount: Int) {
        if (amount > 0)
            this.health += amount
    }

    override fun selfHeal(factor: Int) {
        this.health += factor * baseHealAbility
    }

}

fun main() {
    var pikeman: SuperEnemy1 = SubPikeman1(25, 25)
    var pistolero1: SuperEnemy1 = Pistolero1(25, 2)
    var bowman: SuperEnemy1 = SubBowman1(25)
    var monkFighter: SuperEnemy1 = MonkFighter(15, 30, 3)

    println(pistolero1.alive)

    var count = 1
    while (pikeman.alive) {
        println("REPORT: Remaining attacks after attack $count by Pistolero on Pikeman: ${pistolero1.attack(pikeman)}")
        println(pikeman.health)
        count++
    }

    // Manual casting of Pistolero1 so heal:
    if (pistolero1 is Healable) {
        // smart casting
        pistolero1.heal(20)
        // manual casting
        val healable = pistolero1 as Healable
        healable.heal(10)
        println("pistolero1 health = ${pistolero1.health}")
    }

    if (pistolero1 is SelfHealable) {
        println("pistolero health before self heal: ${pistolero1.health}")
        pistolero1.selfHeal(2)

        println("pistolero health after self heal: ${pistolero1.health}")
    }

    if (monkFighter is Healer) {
        monkFighter.healOther(pistolero1, 2)
    }


}