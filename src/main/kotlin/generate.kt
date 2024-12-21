package com.vipous.task1

import com.vipous.task1.state.Direction
import com.vipous.task1.state.Point
import com.vipous.task1.state.UnitState
import com.vipous.task1.units.Protos
import com.vipous.task1.units.StarUnit
import com.vipous.task1.units.Terran
import com.vipous.task1.units.Zerg
import kotlin.random.Random

fun generateUnits(num: Int): List<StarUnit> =
    (1..num).map {
        when (Random.nextInt(1, 4)) {
            1 -> Protos.random()
            2 -> Terran.random()
            else -> Zerg.random()
        }.apply {
            state = randomState()
        }
    }

inline fun <reified T : StarUnit> generateRaiseUnits(num: Int) = (1..num).map {
    when (T::class) {
        Protos::class -> Protos.random()
        Terran::class -> Protos.random()
        Zerg::class -> Protos.random()
        else -> null
    }
}

fun randomState(): UnitState =
    when (Random.nextInt(1, 8)) {
        1 -> UnitState.Stop
        2 -> UnitState.Guard
        3 -> UnitState.Attack
        4 -> UnitState.Hold(Direction.entries.random())
        5 -> UnitState.Move(Point.random)
        6 -> UnitState.Patrol(Point.random to Point.random)
        else -> UnitState.Undefined
    }

private val randomNameChars = ('a'..'z')

val randomName get() = (1..10).map { randomNameChars.random() }.joinToString("")