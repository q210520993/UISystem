package com.skillw.uisystem.internal.manager

import com.daxton.unrealcore.resource.been.ResourceStatus
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.manager.RdataManager
import org.bukkit.entity.Player
import org.checkerframework.checker.guieffect.qual.UI

object RdataManagerImpl: RdataManager() {
    override val key: String = "RdataManager"
    override val priority = 2
    override val subPouvoir = UISystem

    override fun setPlayer(player: Player,boolean: ResourceStatus) {
        UISystem.rdataManager[player.uniqueId] = boolean
    }

    override fun hasPlayer(player: Player): Boolean {
        return UISystem.rdataManager[player.uniqueId] != null
    }

    override fun removePlayer(player: Player) {
        if (UISystem.rdataManager.hasPlayer(player)) remove(player.uniqueId)
    }

    override fun PlayerIsFinish(player: Player): Boolean {
        return UISystem.rdataManager[player.uniqueId] == ResourceStatus.Finish_Load_Resource_Pack
    }



}