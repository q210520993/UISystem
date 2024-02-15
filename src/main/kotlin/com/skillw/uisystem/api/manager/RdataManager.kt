package com.skillw.uisystem.api.manager

import com.daxton.unrealcore.resource.been.ResourceStatus
import com.skillw.pouvoir.api.manager.Manager
import com.skillw.pouvoir.api.plugin.map.BaseMap
import com.skillw.uisystem.UISystem
import org.bukkit.entity.Player
import java.util.UUID

abstract class RdataManager: Manager, BaseMap<UUID, ResourceStatus>() {

    abstract fun setPlayer(player: Player,boolean: ResourceStatus)

    abstract fun removePlayer(player: Player)

    abstract fun hasPlayer(player: Player): Boolean

    abstract fun PlayerIsFinish(player: Player): Boolean?

    companion object {

        fun Player.addPlayer(r: ResourceStatus){
            UISystem.rdataManager.setPlayer(this,r)
        }

        fun Player.removePlayer(){
            UISystem.rdataManager.removePlayer(this)
        }

        fun Player.hasPlayer(){
            UISystem.rdataManager.hasPlayer(this)
        }

    }

}