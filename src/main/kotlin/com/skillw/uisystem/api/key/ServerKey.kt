package com.skillw.uisystem.api.key

import com.daxton.unrealcore.been.common.type.KeyboardKeyType
import com.skillw.pouvoir.api.plugin.map.component.Registrable
import com.skillw.uisystem.UISystem

abstract class ServerKey: IKey, Registrable<String>{

    abstract override val key: String

    abstract val keyBoard: KeyboardKeyType?


    override fun register() {
        UISystem.serverKeyManager.register(this)
    }


}