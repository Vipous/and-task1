package com.vipous.task1.units

import com.vipous.task1.state.UnitState
import java.util.*
import kotlin.properties.Delegates

abstract class StarUnit(
    val name: String
) {
    val id: UUID by lazy { UUID.randomUUID() }
    var state: UnitState by Delegates.observable(UnitState.Undefined) { _, oldValue, newValue ->
        println("Unit: $name change state $oldValue->$newValue")
    }
}

fun StarUnit.describe(): String {
    val state = this.state
    return "${this::class.simpleName}($name) " +
            when (state) {
                UnitState.Attack -> "is attacking"
                UnitState.Guard -> "is guarding"
                is UnitState.Hold -> "is hold position at ${state.direction}"
                is UnitState.Move -> "is moving to ${state.point}"
                is UnitState.Patrol ->
                    "is patrolling between ${state.points.first} and ${state.points.second} of dis ${state.distance}"

                UnitState.Stop -> "is stopped"
                UnitState.Undefined -> "is unknown state"
            }
}


fun List<StarUnit>.describe() = this.forEach { println("  ${it.describe()}") }

inline fun <reified T : StarUnit> List<StarUnit>.filterByType(): List<T> =
    this.filterIsInstance<T>()

fun List<StarUnit>.filterByState(stateCheck: (UnitState) -> Boolean) =
    this.filter {
        runCatching {
            stateCheck(it.state)
        }
            .onFailure {
                println("Error: ${it.message}")
            }
            .getOrElse { false }
    }

fun List<StarUnit>.groupByState(throwIfUndefined: Boolean = false): Map<String, List<StarUnit>> {
    return this.groupBy { unit ->
        when (unit.state) {
            UnitState.Attack -> "Attack"
            UnitState.Guard -> "Guard"
            is UnitState.Hold -> "Hold"
            is UnitState.Move -> "Move"
            is UnitState.Patrol -> "Patrol"
            UnitState.Stop -> "Stop"
            UnitState.Undefined -> when {
                throwIfUndefined -> throw RuntimeException("Unit ${unit::class.simpleName} with id=${unit.id}, name=${unit.name} in Undefined state")
                else -> "Undefined"
            }
        }
    }
}