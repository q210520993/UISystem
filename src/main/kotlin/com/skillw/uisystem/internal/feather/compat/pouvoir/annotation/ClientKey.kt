package com.skillw.uisystem.internal.feather.compat.pouvoir.annotation

import com.daxton.unrealcore.been.common.type.KeyboardKeyType
import com.skillw.pouvoir.Pouvoir
import com.skillw.pouvoir.api.plugin.annotation.AutoRegister
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotation
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotationData
import com.skillw.pouvoir.util.toArgs
import com.skillw.uisystem.api.key.ClientKey
import com.skillw.uisystem.api.key.Trigger
import com.skillw.uisystem.util.findEnumValue
import org.bukkit.entity.Player
import javax.script.ScriptContext

@AutoRegister
internal object ClientKey: ScriptAnnotation("ClientKeyRegister") {
    override fun handle(data: ScriptAnnotationData) {
        val script = data.script
        val args = data.args.toArgs()
        val vars = script.script.engine.getBindings(ScriptContext.ENGINE_SCOPE)
        val function = data.function
        val key = if (args.isEmpty() || args[0] == "") function else args[0]
        val category = if (args[1] == "") "UnrealCore" else args[1]
        val name = args[2]
        val keyboardKeyType = args[3]
        val isAuto = args[4] == "true" && args.isNotEmpty()
        object : ClientKey() {
            override val key: String = key

            override val uKey: String = key

            override val category: String = category

            override val name: String = name

            override val isAutoSendToPlayer: Boolean = isAuto

            override val keyboardKeyType: KeyboardKeyType = findEnumValue<KeyboardKeyType>(keyboardKeyType) ?: KeyboardKeyType.None

            override fun exec(player: Player) {
                return Pouvoir.scriptManager.invoke(
                    script,
                    function,
                    parameters = arrayOf(player)
                )!!
            }

        }.register()
    }
}