//Created by Graham Duthie on 10/11/2023 15:01 -1h
package `fun`.madeby.learnkotlin

fun main() {
        // specify default parameters and call them by name in any order you want:

    fun showLevelAndXp(level: Int = 0, xp: Int = 0) = println("level = $level, xp = $xp")

    showLevelAndXp()
    showLevelAndXp(100, 100)
    showLevelAndXp(xp = 1000, level = 2)
}