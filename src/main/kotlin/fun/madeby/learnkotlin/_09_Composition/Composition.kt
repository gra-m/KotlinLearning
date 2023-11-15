//Created by Graham Duthie on 15/11/2023 09:43 -1h
package `fun`.madeby.learnkotlin._09_Composition
// write class armor similar to health, create prop in Soldier.
// print armor val in toString
// Add armor to pikeman and archer
// create swordsman and print to console
class Health(var amount: Int)
class Armour(var amount: Int)
class Weapon(var name: String)

class Soldier(var name: String, var health: Health, var armour: Armour, var weapon: Weapon) {

    override fun toString(): String {
        return "Soldier: name = '$name', health = ${health.amount}, armour = ${armour.amount},  weapon = ${weapon.name}"
    }
}

fun main() {
    val pikemanHealth = Health(100)
    val pikemanArmour = Armour(amount = 40)
    val pike = Weapon("pike")
    val pikeman = Soldier("pikeman", pikemanHealth, pikemanArmour, pike)

    val bowmanHealth = Health(100)
    val bowmanArmour = Armour(amount = 15)
    val bow = Weapon("bow")
    val bowman = Soldier("archer", bowmanHealth, bowmanArmour, bow)

    val swordsmanHealth = Health(100)
    val swordsmanArmour = Armour(amount = 50)
    val sword = Weapon("sword")
    val swordsman = Soldier("swordsman", swordsmanHealth, swordsmanArmour, sword)

    println("This is pikeman $pikeman \nThis is bowman $bowman\nThis is swordsman $swordsman")

}
