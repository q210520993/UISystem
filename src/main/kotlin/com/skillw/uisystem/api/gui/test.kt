package com.skillw.uisystem.api.gui

import com.daxton.unrealcore.common.type.MouseActionType
import com.daxton.unrealcore.common.type.MouseButtonType
import com.daxton.unrealcore.display.been.module.control.ButtonModuleData
import com.daxton.unrealcore.display.content.module.control.ButtonModule
import com.skillw.pouvoir.api.plugin.annotation.AutoRegister

@AutoRegister
object test: Gui() {
    override val key: String = "test"
    init {
        print(mainGUIData.moduleID)
        val button = ButtonModuleData()
        button.moduleID = "buttonexample"
        button.x = "-3"
        button.y = "3"
        button.image = "gui/icon/x.png"
        button.color = "#FFFFFF"
        button.hoverColor = "#1e90ff"
        button.clickColor = "#1e90ff"
        button.transparent = "255"
        button.width = "20"
        button.height = "20"
        button.textColor = "#00CACA"
        button.textSize = "1"
        button.use = "true"
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
        data.addModule("buttonexample", button)
    }
    override fun opening() {
    }

    override fun close() {
    }

    override fun buttonClick(buttonModule: ButtonModule?, button: MouseButtonType?, action: MouseActionType?) {
        println(123)
    }
}