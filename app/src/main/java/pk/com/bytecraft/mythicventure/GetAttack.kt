package pk.com.bytecraft.mythicventure

import kotlin.random.Random

class GetAttack(){
    fun lvl1():Int {
        var minAttack:Int = 0
        var maxAttack:Int = 0

        when (characters) {
            "Warrior" -> {
                minAttack = 1
                maxAttack = 15
            }
            "Mage" -> {
                minAttack = 15
                maxAttack = 20
            }
            else -> {
                minAttack = 20
                maxAttack = 30
            }
        }

        return Random.nextInt(minAttack, maxAttack)
    }


    fun enemylvl1():Int {
        var max:Int = 0
        var min: Int = 0
        when(enemy){
            "Baby Dragon" -> {
                min = 1
                max = 10
            }
            "Dragon" -> {
                min = 10
                max = 15
            }
            "Giant Dragon" ->{
                min = 15
                max = 20
            }
        }
        return Random.nextInt(min, max)
    }
}