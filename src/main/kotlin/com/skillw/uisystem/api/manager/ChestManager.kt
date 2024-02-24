package com.skillw.uisystem.api.manager

import com.skillw.pouvoir.api.manager.Manager
import com.skillw.pouvoir.api.plugin.map.KeyMap
import com.skillw.uisystem.api.gui.Gui
import org.bukkit.entity.Player

abstract class ChestManager: KeyMap<String,Gui>(), Manager {
    abstract fun setPlayer(player: Player, key: String)

    abstract fun removePlayer(player: Player, key: String)
}