package com.skillw.uisystem.internal.manager

import com.daxton.unrealcore.resource.been.ResourceStatus
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.manager.ResourceStateManager
import org.bukkit.entity.Player

object ResourceStateManagerImpl: ResourceStateManager() {
    override val key: String = "RdataManager"
    override val priority = 4
    override val subPouvoir = UISystem

    override fun setPlayer(player: Player,boolean: ResourceStatus) {
        UISystem.resourceStateManager[player.uniqueId] = boolean
    }

    override fun hasPlayer(player: Player): Boolean {
        return UISystem.resourceStateManager[player.uniqueId] != null
    }

    override fun removePlayer(player: Player) {
        if (UISystem.resourceStateManager.hasPlayer(player)) remove(player.uniqueId)
    }

    override fun PlayerIsFinish(player: Player): Boolean {
        return UISystem.resourceStateManager[player.uniqueId] == ResourceStatus.Finish_Load_Resource_Pack
    }

}