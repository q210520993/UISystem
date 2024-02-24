package com.skillw.uisystem.util

import com.daxton.unrealcore.display.type.HUDType

fun findHUDType(input: String): HUDType? {
    val formattedInput = input.uppercase()
    return HUDType.values().find { it.name.uppercase() == formattedInput }
}
fun anyToBoolean(value: Any): Boolean {
    return when (value) {
        is Boolean -> value
        is String -> value.toBoolean()
        else -> false
    }
}