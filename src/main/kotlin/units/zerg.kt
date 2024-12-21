package com.vipous.task1.units

import com.vipous.task1.randomName
import kotlin.random.Random

abstract class Zerg(name: String) : StarUnit(name) {
    companion object {
        fun random(): Zerg =
            when (val index = Random.nextInt(1, 6)) {
                1 -> Drone(randomName)
                2 -> Zergling(randomName)
                3 -> Hydralisk(randomName)
                4 -> Lurker(randomName)
                5 -> Ultralisk(randomName)
                else -> throw RuntimeException("Ups unit index($index) not defined")
            }
    }
}

class Drone(name: String) : Zerg(name)
class Zergling(name: String) : Zerg(name)
class Hydralisk(name: String) : Zerg(name)
class Lurker(name: String) : Zerg(name)
class Ultralisk(name: String) : Zerg(name)