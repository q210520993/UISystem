package com.skillw.uisystem.internal.manager

import com.daxton.unrealcore.application.UnrealCoreAPI
import com.skillw.pouvoir.api.plugin.SubPouvoir
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.manager.ChestManager
import org.bukkit.entity.Player

object ChestManagerImpl: ChestManager() {

    override val key: String = "ChestManager"
    override val priority: Int = 2
    override val subPouvoir: SubPouvoir = UISystem

    override fun removePlayer(player: Player, key: String) {
        UnrealCoreAPI.removeChest(player,key)
    }
    override fun setPlayer(player: Player, key: String) {
        UnrealCoreAPI.setChest(player,key)
    }

}