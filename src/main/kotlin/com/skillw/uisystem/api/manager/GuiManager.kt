package com.skillw.uisystem.api.manager

import com.skillw.pouvoir.api.manager.Manager
import com.skillw.pouvoir.api.plugin.map.BaseMap
import com.skillw.pouvoir.api.plugin.map.KeyMap
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotationData
import com.skillw.uisystem.api.gui.Gui
import org.bukkit.entity.Player

abstract class GuiManager: BaseMap<String, ScriptAnnotationData>(), Manager{
    abstract fun OpenGui(player: Player, key: String)

    abstract fun close(player: Player)

}