package com.skillw.uisystem.internal.feather.compat.pouvoir.annotation

import com.daxton.unrealcore.display.been.gui.MainGUIData
import com.skillw.pouvoir.Pouvoir
import com.skillw.pouvoir.api.plugin.annotation.AutoRegister
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotation
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotationData
import com.skillw.uisystem.api.gui.Gui
import javax.script.ScriptContext

@AutoRegister
internal object GuiAnnotation: ScriptAnnotation("GuiCreate",fileAnnotation = true){
    override fun handle(data: ScriptAnnotationData) {
        val script = data.script
        val vars = script.script.engine.getBindings(ScriptContext.ENGINE_SCOPE)
        val key = vars["key"]?.toString() ?: error("无法找到${script.key}变量key")
        val setting = vars["setting"] as MainGUIData
        object : Gui(){
            override val key: String = key
            init {
                this.mainGUIData = setting
            }
            override fun opening() {
                Pouvoir.scriptManager.invoke<Any>(script, "opening", parameters = arrayOf(this))
            }
            override fun close() {
                Pouvoir.scriptManager.invoke<Any>(script, "close", parameters = arrayOf(this))
            }
        }.register()
    }
}