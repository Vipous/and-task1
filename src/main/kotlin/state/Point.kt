package com.vipous.task1.state

import kotlin.random.Random

data class Point(
    val x: Int,
    val y: Int,
) {
    companion object {
        val random
            get() = Point(
                x = Random.nextInt(0, 100),
                y = Random.nextInt(0, 100)
            )
    }
}