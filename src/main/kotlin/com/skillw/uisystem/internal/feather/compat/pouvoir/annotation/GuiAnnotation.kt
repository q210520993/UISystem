package com.skillw.uisystem.internal.feather.compat.pouvoir.annotation

import com.daxton.unrealcore.common.type.MouseActionType
import com.daxton.unrealcore.common.type.MouseButtonType
import com.daxton.unrealcore.display.been.gui.MainGUIData
import com.daxton.unrealcore.display.been.module.ModuleData
import com.daxton.unrealcore.display.content.module.ModuleComponents
import com.daxton.unrealcore.display.content.module.control.*
import com.daxton.unrealcore.display.content.module.input.AreaInputModule
import com.daxton.unrealcore.display.content.module.input.ChatInputModule
import com.daxton.unrealcore.display.content.module.input.InputModule
import com.daxton.unrealcore.display.type.SlotType
import com.skillw.pouvoir.Pouvoir
import com.skillw.pouvoir.api.plugin.annotation.AutoRegister
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotation
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotationData
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.gui.Gui
import com.skillw.uisystem.util.anyToBoolean
import javax.script.ScriptContext


//向Manager注册Script
@AutoRegister
internal object GuiAnnotation: ScriptAnnotation("GuiCreate",fileAnnotation = true){
    override fun handle(data: ScriptAnnotationData) {
        val script = data.script
        val vars = script.script.engine.getBindings(ScriptContext.ENGINE_SCOPE)
        val key = vars["key"]?.toString() ?: error("无法找到${script.key}的变量key")
        UISystem.guiManager.register(key, data)
    }
}