package com.skillw.uisystem.api.gui

import com.skillw.pouvoir.api.plugin.annotation.AutoRegister

@AutoRegister
object test: Gui() {
    override val key: String = "test"
    init {
        print(mainGUIData.moduleID)
        val data = mainGUIData
        data.image = "xxx.png"
        data.x = "10"
        data.y = "10"
        data.position = "0"
        data.width = "10"
        data.height = "10"
        data.mask = "true"
        data.color = "ffffff"
        data.transparent = "255"
    }
    override fun opening() {
    }

    override fun close() {
    }
}