package com.skillw.uisystem.internal.manager

import com.daxton.unrealcore.been.common.type.KeyboardKeyType
import com.skillw.pouvoir.api.plugin.SubPouvoir
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.event.SCKeyEvent
import com.skillw.uisystem.api.key.ClientKey
import com.skillw.uisystem.api.key.ServerKey
import com.skillw.uisystem.api.manager.ClientKeyManager
import com.skillw.uisystem.api.manager.ServerKeyManager
import com.skillw.uisystem.util.findEnumValue

object ServerKeyManagerImpl: ServerKeyManager() {
    override val key: String = "ServerKeyManager"
    override val priority: Int = 11
    override val subPouvoir: SubPouvoir = UISystem


    override fun register(key: String, value: ServerKey): ServerKey? {
        val event = SCKeyEvent.ServerKeyRegister(key,value)
        event.call()
        if (event.isCancelled) return null
        UIConfig.debug {
            println("ClientKeyManagerRegitser: Key:${key}, value: $value")
        }
        println("${key}注册成功键: ${value.keyBoard}")
        println("${key}注册成功键S: $value")
        println(findEnumValue<KeyboardKeyType>("F"))
        return put(key, value)
    }
}