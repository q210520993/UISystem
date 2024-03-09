package com.skillw.uisystem.api.key

import com.daxton.unrealcore.been.common.type.KeyboardKeyType
import com.skillw.pouvoir.api.plugin.map.component.Registrable
import com.skillw.uisystem.UISystem


abstract class ClientKey(): Registrable<String>, IKey {

    abstract override val key: String

    abstract val uKey: String

    abstract val category: String

    abstract val name: String

    abstract val keyboardKeyType: KeyboardKeyType

    abstract val isAutoSendToPlayer: Boolean

    override fun toString(): String {
        return "KeyMappingBeen(key=${uKey}, category=${category}, name=${name}, keyboardKeyType=${keyboardKeyType})"
    }

    override fun register() {
        UISystem.clientKeyManager.register(this)
    }

}