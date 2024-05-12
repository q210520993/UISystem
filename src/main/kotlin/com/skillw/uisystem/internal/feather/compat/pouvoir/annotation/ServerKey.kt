package com.skillw.uisystem.internal.feather.compat.pouvoir.annotation

import com.daxton.unrealcore.been.common.type.KeyboardKeyType
import com.skillw.pouvoir.Pouvoir
import com.skillw.pouvoir.api.plugin.annotation.AutoRegister
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotation
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotationData
import com.skillw.pouvoir.util.toArgs
import com.skillw.uisystem.api.key.ServerKey
import com.skillw.uisystem.util.findEnumValue
import org.bukkit.entity.Player
import javax.script.ScriptContext

@AutoRegister
internal object ServerKey: ScriptAnnotation("ServerKeyRegister"){
    override fun handle(data: ScriptAnnotationData) {
        val script = data.script
        val vars = script.script.engine.getBindings(ScriptContext.ENGINE_SCOPE)
        val args = data.args.toArgs()
        val function = data.function
        val key = if (args.isEmpty() || args[0] == "") function else args[0]
        val type = args[1]
        object : ServerKey() {
            override val key: String = key

            override val keyBoard: KeyboardKeyType? = findEnumValue<KeyboardKeyType>(type)

            override fun exec(player: Player) {
                return Pouvoir.scriptManager.invoke(
                    script,
                    function,
                    parameters = arrayOf(player)
                )?: return
            }

        }.register()
    }
}