package com.skillw.uisystem.api.manager

import com.skillw.pouvoir.api.manager.Manager
import com.skillw.pouvoir.api.plugin.map.KeyMap
import com.skillw.uisystem.api.gui.Hud
import org.bukkit.entity.Player

abstract class HudManager: KeyMap<String,Hud>(), Manager {
    abstract fun sendHud(player: Player, key: String)

    abstract fun removeHud(player: Player,key: String)

}