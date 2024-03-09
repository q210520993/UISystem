package com.skillw.uisystem.internal.manager

import com.daxton.unrealcore.common.CommonController
import com.skillw.pouvoir.api.plugin.SubPouvoir
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.event.SCKeyEvent
import com.skillw.uisystem.api.key.ClientKey
import com.skillw.uisystem.api.manager.ClientKeyManager
import com.skillw.uisystem.internal.manager.UIConfig.debug
import com.skillw.uisystem.util.Gson
import com.skillw.uisystem.util.Gson.toJson
import org.bukkit.entity.Player

object ClientKeyManagerImpl: ClientKeyManager() {
    override val key: String = "ClientKeyManager"
    override val priority: Int = 10
    override val subPouvoir: SubPouvoir = UISystem

    override fun keyMappingSet(player: Player, key: String) {
        this[key]?.let {
//            CommonController(player).keyMappingSet(it.uKey,it.category,it.name,it.keyboardKeyType)
            CommonController.sendPack(player,"KeyMappingSet", Gson.toJson(it))
        }
    }

    override fun keyMappingRemove(player: Player, uKey: String) {
        CommonController.sendPack(player,"KeyMappingRemove", uKey)
    }

    override fun keyMappingClear(player: Player) {
        CommonController.sendPack(player,"KeyMappingClear")
    }

    override fun register(key: String, value: ClientKey): ClientKey? {
        val event = SCKeyEvent.ClientKeyRegister(key,value)
        event.call()
        if (event.isCancelled) return null
        debug {
            println("ClientKeyManagerRegitser: Key:${key}, value: $value")
        }
        println("ClientKeyManagerRegitser: Key:${key}, value: $value")
        return put(key, value)
    }

}