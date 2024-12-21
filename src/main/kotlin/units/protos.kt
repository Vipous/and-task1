package com.vipous.task1.units

import com.vipous.task1.randomName
import kotlin.random.Random

abstract class Protos(name: String) : StarUnit(name) {
    companion object {
        fun random(): Protos =
            when (val index = Random.nextInt(1, 6)) {
                1 -> Probe(randomName)
                2 -> Zealot(randomName)
                3 -> Dragoon(randomName)
                4 -> HighTemplar(randomName)
                5 -> DarkTemplar(randomName)
                else -> throw RuntimeException("Ups unit index($index) not defined")
            }
    }
}

class Probe(name: String) : Protos(name)
class Zealot(name: String) : Protos(name)
class Dragoon(name: String) : Protos(name)
class HighTemplar(name: String) : Protos(name)
class DarkTemplar(name: String) : Protos(name)