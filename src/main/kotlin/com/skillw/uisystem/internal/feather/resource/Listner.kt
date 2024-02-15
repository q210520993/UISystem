package com.skillw.uisystem.internal.feather.resource

import com.daxton.unrealcore.communication.event.PlayerConnectionSuccessfulEvent
import com.daxton.unrealcore.resource.been.ResourceStatus
import com.daxton.unrealcore.resource.event.PlayerResourcePackEvent
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.UIApi.sendRes
import com.skillw.uisystem.internal.manager.UIConfig
import com.skillw.uisystem.internal.manager.UIConfig.debug
import org.bukkit.entity.Player
import org.checkerframework.checker.guieffect.qual.UI
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent

object Listner {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    internal fun ee(event: PlayerConnectionSuccessfulEvent){
        if (UIConfig.resourcesEnable){
            event.player.sendRes()
        }
        debug(debug = {
            println("加载材质包...${event.player}")
            println("${UIConfig.resources},${UIConfig.resourcesPassword}")
        })
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    internal fun qwq(event: PlayerResourcePackEvent){
        UISystem.rdataManager.setPlayer(event.player,event.resourceStatus)
        debug{
            println("加载材质包事件${event.player},状态${event.resourceStatus}")
            println(UISystem.rdataManager.toString())
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    internal fun awa(event: org.bukkit.event.player.PlayerQuitEvent) {
        UISystem.rdataManager.removePlayer(event.player)
        debug{
            println("退出${event.player}")
        }
    }

    @SubscribeEvent
    internal fun pwp(event: org.bukkit.event.player.PlayerKickEvent){
        UISystem.rdataManager.removePlayer(event.player)
    }

    @SubscribeEvent
    internal fun xcx(event: org.bukkit.event.player.PlayerMoveEvent){
        if (UISystem.rdataManager[event.player.uniqueId] == ResourceStatus.Start_Load_Resource_Pack) event.isCancelled = true
    }

    @SubscribeEvent
    internal fun pvp(event: org.bukkit.event.player.PlayerInteractEvent){
        if (UISystem.rdataManager[event.player.uniqueId] == ResourceStatus.Start_Load_Resource_Pack) event.isCancelled = true
    }

    @SubscribeEvent
    internal fun rpg(event: org.bukkit.event.player.PlayerInteractEntityEvent){
        if (UISystem.rdataManager[event.player.uniqueId] == ResourceStatus.Start_Load_Resource_Pack) event.isCancelled = true
    }

    @SubscribeEvent
    internal fun xxx(event: org.bukkit.event.entity.EntityDamageEvent) {
        if (event.entity is Player){
            if(UISystem.rdataManager[event.entity.uniqueId] == ResourceStatus.Start_Load_Resource_Pack) event.isCancelled = true
        }
    }

}