package com.skillw.uisystem.internal.core.Gui

import com.skillw.uisystem.api.gui.Gui
import taboolib.library.configuration.ConfigurationSection

//不想写了，不如写js，麻烦的Yaml
class YGui(val config: ConfigurationSection): Gui() {

    override val key: String = config.name

    override val chest: Boolean = config.getBoolean("Chest")

}