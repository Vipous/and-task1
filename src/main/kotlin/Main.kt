package com.vipous.task1

import com.vipous.task1.state.UnitState
import com.vipous.task1.units.*

fun main() {
    // 1. Генерация объектов
    println("1. Генерация объектов")
    val randomUnits = generateUnits(20)
    randomUnits.forEach { println(it.describe()) }
    println()

    // 2. Фильтрация и преобразование
    println("2. Фильтрация и преобразование")
    val protoses = randomUnits.filterByType<Protos>()
    val terrans = randomUnits.filterByType<Terran>()
    val zergs = randomUnits.filterByType<Zerg>()
    println("Protos")
    protoses.describe()
    println()

    println("Terran")
    terrans.describe()
    println()

    println("Zergs")
    zergs.describe()
    println()

    //Все юниты в состоянии Stop
    val patrolUnits = randomUnits.filterByState { it is UnitState.Stop }
    println("Stopped units")
    patrolUnits.describe()
    println()

    //Map по состоянию
    println("Units by state")
    val unitsByState = randomUnits.groupByState()
    unitsByState.forEach { (state, units) ->
        println(state)
        units.describe()
    }
    println()

    //4. Работа с ошибками; Если у животного отсутствует состояние, выбрасывать исключение
    try {
        randomUnits.groupByState(true)
    } catch (ignore: Exception) {
        ignore.printStackTrace()
    }
    println()

    //5. Использование Kotlin-функциональности
    val squad = Squad<Terran>()
    squad.add(Terran.random())
    squad.add(Terran.random())
    squad.add(Terran.random())

    println("Terran Squad")
    squad.list().describe()
}
