package com.skillw.uisystem.internal.feather.resource

import com.daxton.unrealcore.communication.event.PlayerConnectionSuccessfulEvent
import com.daxton.unrealcore.resource.been.ResourceStatus
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.UIApi.sendRes
import com.skillw.uisystem.api.event.FinishLoading
import com.skillw.uisystem.internal.manager.UIConfig
import com.skillw.uisystem.internal.manager.UIConfig.debug
import org.bukkit.entity.Player
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent

object Listener {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    internal fun playerConnectionSuccessfulEvent(event: PlayerConnectionSuccessfulEvent){
        if (UIConfig.resourcesEnable){
            event.player.sendRes()
        }
        debug(debug = {
            println("加载材质包...${event.player}")
            println("${UIConfig.resources},${UIConfig.resourcesPassword}")
        })
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    internal fun playerResourcePackEvent(event: com.daxton.unrealcore.resource.event.PlayerResourcePackEvent){
        UISystem.resourceStateManager.setPlayer(event.player,event.resourceStatus)
        if (event.resourceStatus == ResourceStatus.Finish_Load_Resource_Pack) FinishLoading(event.player).call()
        debug{
            println("加载材质包事件${event.player},状态${event.resourceStatus}")
            println(UISystem.resourceStateManager.toString())
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    internal fun playerQuitEvent(event: org.bukkit.event.player.PlayerQuitEvent) {
        UISystem.resourceStateManager.removePlayer(event.player)
        debug{
            println("退出${event.player}")
        }
    }

    @SubscribeEvent
    internal fun playerKickEvent(event: org.bukkit.event.player.PlayerKickEvent){
        UISystem.resourceStateManager.removePlayer(event.player)
    }

    @SubscribeEvent
    internal fun playerMoveEvent(event: org.bukkit.event.player.PlayerMoveEvent){
        if (UISystem.resourceStateManager[event.player.uniqueId] == ResourceStatus.Start_Load_Resource_Pack) event.isCancelled = true
    }

    @SubscribeEvent
    internal fun playerInteractEvent(event: org.bukkit.event.player.PlayerInteractEvent){
        if (UISystem.resourceStateManager[event.player.uniqueId] == ResourceStatus.Start_Load_Resource_Pack) event.isCancelled = true
    }

    @SubscribeEvent
    internal fun playerInteractEntityEvent(event: org.bukkit.event.player.PlayerInteractEntityEvent){
        if (UISystem.resourceStateManager[event.player.uniqueId] == ResourceStatus.Start_Load_Resource_Pack) event.isCancelled = true
    }

    @SubscribeEvent
    internal fun entityDamageEvent(event: org.bukkit.event.entity.EntityDamageEvent) {
        if (event.entity is Player){
            if(UISystem.resourceStateManager[event.entity.uniqueId] == ResourceStatus.Start_Load_Resource_Pack) event.isCancelled = true
        }
    }

}