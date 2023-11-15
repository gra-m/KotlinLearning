//Created by Graham Duthie on 15/11/2023 09:43 -1h
package `fun`.madeby.learnkotlin._10_ComponentPatternOverridingOperators

// Major issue here is the ability to add components under invalid keys.
// MarkerInterface
interface BasicComponent

class Speed(var amount: Int) : BasicComponent {
    override fun toString(): String {
        return "Speed(amount=$amount)"
    }
}

class Health(var amount: Int) : BasicComponent {
    override fun toString(): String {
        return "Health(amount=$amount)"
    }
}

class Armour(var amount: Int) : BasicComponent {
    override fun toString(): String {
        return "Armour(amount=$amount)"
    }
}

class Weapon(var name: String) : BasicComponent {
    override fun toString(): String {
        return "Weapon(name='$name')"
    }
}

class MilUnit(var name: String) {
    private val componentsByName = hashMapOf<String, BasicComponent>()


    fun removeComponent(name: String) = componentsByName.remove(name)

    fun addComponent(name: String, component: BasicComponent) = componentsByName.put(name, component)
    operator fun set(name: String, component: BasicComponent)  = componentsByName.put(name, component)

    //fun getComponent(name: String) : BasicComponent? = componentsByName[name]
    // overridden operator 'get' allows for compact calls to get components = medic["Speed"]
    operator fun get(name: String) : BasicComponent? = componentsByName[name]

    override fun toString(): String {
        return "MilUnit $name with components: $componentsByName"
    }


}

fun main() {
    // issue, they can be added with
    val pikemanHealth = Health(100)
    val pikemanSpeed = Speed(6)
    val pikemanArmour = Armour(amount = 40)
    val pike = Weapon("pike")
    val pikeman = MilUnit("pikeman")
    pikeman[pikemanHealth.javaClass.simpleName] = pikemanHealth
    pikeman[pikemanSpeed.javaClass.simpleName] = pikemanSpeed
    pikeman.addComponent(pikemanArmour.javaClass.simpleName, pikemanArmour)
    pikeman.addComponent(pike.javaClass.simpleName, pike)


    val bowmanHealth = Health(100)
    val bowmanArmour = Armour(amount = 15)
    val bow = Weapon("bow")
    val bowman = MilUnit("archer")
    bowman.addComponent(bowmanHealth.javaClass.simpleName, bowmanHealth)
    bowman.addComponent(bowmanArmour.javaClass.simpleName, bowmanArmour)
    bowman.addComponent(bow.javaClass.simpleName, bow)

    val swordsmanHealth = Health(100)
    val swordsmanArmour = Armour(amount = 50)
    val sword = Weapon("sword")
    val swordsman = MilUnit("swordsman")
    swordsman.addComponent(swordsmanHealth.javaClass.simpleName, swordsmanHealth)
    swordsman.addComponent(swordsmanArmour.javaClass.simpleName, swordsmanArmour)
    swordsman.addComponent(sword.javaClass.simpleName, sword)

    val medicHealth = Health(50)
    val medicSpeed = Speed(10)
    val medic = MilUnit("medic")
    medic.addComponent(medicHealth.javaClass.simpleName, medicHealth)
    medic.addComponent(medicSpeed.javaClass.simpleName, medicSpeed)


    println("$pikeman\n$bowman\n$swordsman\n$medic")

    //
    val medicWeapon = medic["Weapon"]
    println("medic has weapon = ${medicWeapon != null}")

    val pikemanWeapon = pikeman["Weapon"]
    println("pikeman has weapon = ${pikemanWeapon != null} and as it has an overridden toString its name is $pikemanWeapon")

}
