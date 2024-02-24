package com.skillw.uisystem.internal.feather.compat.pouvoir.annotation

import com.daxton.unrealcore.common.type.MouseActionType
import com.daxton.unrealcore.common.type.MouseButtonType
import com.daxton.unrealcore.display.been.gui.MainGUIData
import com.daxton.unrealcore.display.content.module.control.*
import com.daxton.unrealcore.display.content.module.input.AreaInputModule
import com.daxton.unrealcore.display.content.module.input.ChatInputModule
import com.daxton.unrealcore.display.content.module.input.InputModule
import com.daxton.unrealcore.display.type.SlotType
import com.skillw.pouvoir.Pouvoir
import com.skillw.pouvoir.api.plugin.annotation.AutoRegister
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotation
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotationData
import com.skillw.uisystem.api.gui.Gui
import com.skillw.uisystem.util.anyToBoolean
import javax.script.ScriptContext

@AutoRegister
internal object GuiAnnotation: ScriptAnnotation("GuiCreate",fileAnnotation = true){
    override fun handle(data: ScriptAnnotationData) {
        val script = data.script
        val vars = script.script.engine.getBindings(ScriptContext.ENGINE_SCOPE)
        val key = vars["key"]?.toString() ?: error("无法找到${script.key}的变量key")
        val chest = vars["chest"]?.let { anyToBoolean(it) } ?: false
        object : Gui() {
            override val key: String = key

            override val chest: Boolean = chest

            init {
                this.mainGUIData = Pouvoir.scriptManager.invoke<MainGUIData>(script, "setting", parameters = arrayOf(this))
                this.mainGUIData.moduleID = key
            }
            override fun opening() {
                Pouvoir.scriptManager.invoke<Any>(script, "opening", parameters = arrayOf(this))
            }
            override fun close() {
                Pouvoir.scriptManager.invoke<Any>(script, "close", parameters = arrayOf(this))
            }

            override fun buttonClick(buttonModule: ButtonModule?, button: MouseButtonType?, action: MouseActionType?) {
                Pouvoir.scriptManager.invoke<Any>(script, "buttonClick", parameters = arrayOf(this,buttonModule,button,action))
            }

            override fun checkClick(checkModule: CheckModule?, button: MouseButtonType?, action: MouseActionType?) {
                Pouvoir.scriptManager.invoke<Any>(script, "checkClick", parameters = arrayOf(this,checkModule,button,action))
                super.checkClick(checkModule, button, action)
            }

            override fun rangeClick(rangeModule: RangeModule?, button: MouseButtonType?, action: MouseActionType?) {
                Pouvoir.scriptManager.invoke<Any>(script, "rangeClick", parameters = arrayOf(this,rangeModule,button,action))
                super.rangeClick(rangeModule, button, action)
            }

            override fun selectClick(selectModule: SelectModule?, button: MouseButtonType?, action: MouseActionType?) {
                Pouvoir.scriptManager.invoke<Any>(script, "selectClick", parameters = arrayOf(this,selectModule,button,action))
                super.selectClick(selectModule, button, action)
            }

            override fun slotClick(
                slotModule: SlotModule?,
                button: MouseButtonType?,
                action: MouseActionType?,
                slotType: SlotType?
            ) {
                Pouvoir.scriptManager.invoke<Any>(script, "slotClick", parameters = arrayOf(this,slotModule,button,action))
                super.slotClick(slotModule, button, action, slotType)
            }

            override fun input(inputModule: InputModule?) {
                Pouvoir.scriptManager.invoke<Any>(script, "input", parameters = arrayOf(this,inputModule))
                super.input(inputModule)
            }

            override fun chatInput(inputModule: ChatInputModule?) {
                Pouvoir.scriptManager.invoke<Any>(script, "chatInput", parameters = arrayOf(this,inputModule))
                super.chatInput(inputModule)
            }

            override fun arealInput(areaInputModule: AreaInputModule?) {
                Pouvoir.scriptManager.invoke<Any>(script, "arealInput", parameters = arrayOf(this,areaInputModule))
                super.arealInput(areaInputModule)
            }

            override fun keyOn(keyID: Int, keyName: String?) {
                Pouvoir.scriptManager.invoke<Any>(script, "keyOn", parameters = arrayOf(this,keyID,keyName))
                super.keyOn(keyID, keyName)
            }

            override fun keyPress(keyID: Int, keyName: String?) {
                Pouvoir.scriptManager.invoke<Any>(script, "keyPress", parameters = arrayOf(this,keyID,keyName))
                super.keyPress(keyID, keyName)
            }

            override fun keyOff(keyID: Int, keyName: String?) {
                Pouvoir.scriptManager.invoke<Any>(script, "keyOff", parameters = arrayOf(this,keyID,keyName))
                super.keyOff(keyID, keyName)
            }

            override fun enterText(inputChar: Char) {
                Pouvoir.scriptManager.invoke<Any>(script, "enterText", parameters = arrayOf(this,inputChar))
                super.enterText(inputChar)
            }

        }.register()
    }
}