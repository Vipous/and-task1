package com.vipous.task1.state

import kotlin.math.sqrt

sealed interface UnitState {
    data object Undefined : UnitState
    data object Stop : UnitState
    data object Guard : UnitState
    data object Attack : UnitState
    data class Hold(val direction: Direction) : UnitState
    data class Move(val point: Point) : UnitState
    data class Patrol(val points: Line) : UnitState {
        val distance: Int by lazy { points.distance }
    }

    val Line.distance get() = ((first.x - second.x).sqr + (first.y - second.y).sqr).sqrt
    private val Int.sqr get(): Long = this.toLong() * this.toLong()
    private val Long.sqrt get(): Int = sqrt(this.toDouble()).toInt()
}

typealias Line = Pair<Point, Point>