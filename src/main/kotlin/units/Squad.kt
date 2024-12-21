package com.vipous.task1.units

class Squad<T: StarUnit> {
    private val holder = mutableListOf<T>()

    fun add(unit: T) {
        if (holder.size < MAX_SIZE) {
            holder += unit
        } else {
            throw RuntimeException("Squad full")
        }
    }

    fun drop() {
        holder.removeLast()
    }

    fun list(): List<T> = holder.toList()

    companion object {
        const val MAX_SIZE = 12
    }
}