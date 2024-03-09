package com.skillw.uisystem.api.manager

import com.daxton.unrealcore.common.CommonController
import com.skillw.pouvoir.api.manager.Manager
import com.skillw.pouvoir.api.plugin.map.KeyMap
import com.skillw.uisystem.api.key.ClientKey
import org.bukkit.entity.Player

abstract class ClientKeyManager: Manager, KeyMap<String, ClientKey>() {
    abstract fun keyMappingSet(player: Player,key: String)

    abstract fun keyMappingRemove(player: Player,uKey: String)

    abstract fun keyMappingClear(player: Player)

}