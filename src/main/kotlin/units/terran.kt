package com.vipous.task1.units

import com.vipous.task1.randomName
import kotlin.random.Random

abstract class Terran(name: String) : StarUnit(name) {
    companion object {
        fun random(): Terran =
            when (val index = Random.nextInt(1, 6)) {
                1 -> SCV(randomName)
                2 -> Marine(randomName)
                3 -> Firebat(randomName)
                4 -> Medic(randomName)
                5 -> Ghost(randomName)
                else -> throw RuntimeException("Ups unit index($index) not defined")
            }
    }
}

class SCV(name: String) : Terran(name)
class Marine(name: String) : Terran(name)
class Firebat(name: String) : Terran(name)
class Medic(name: String) : Terran(name)
class Ghost(name: String) : Terran(name)