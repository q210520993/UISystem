package com.skillw.uisystem.util

import com.daxton.unrealcore.been.common.type.KeyboardKeyType
import com.daxton.unrealcore.display.type.HUDType

inline fun <reified T: Enum<T>> findEnumValue(input: String): T? {
    val formattedInput = input.uppercase()
    return enumValues<T>().find { it.name.uppercase() == formattedInput }
}

fun anyToBoolean(value: Any): Boolean {
    return when (value) {
        is Boolean -> value
        is String -> value.toBoolean()
        else -> false
    }
}