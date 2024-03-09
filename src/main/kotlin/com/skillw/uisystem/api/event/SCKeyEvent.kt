package com.skillw.uisystem.api.event

import com.daxton.unrealcore.common.event.PlayerKeyBoardEvent
import com.daxton.unrealcore.common.event.PlayerKeyMappingEvent
import com.skillw.uisystem.api.key.ClientKey
import com.skillw.uisystem.api.key.ServerKey
import org.bukkit.event.HandlerList
import taboolib.platform.type.BukkitProxyEvent

class SCKeyEvent {
    class ClientKeyRegister(val key: String, value: ClientKey) : BukkitProxyEvent() {
        override val allowCancelled = true
    }

    class ClientKeyOn(val key: String, value: ClientKey, event: PlayerKeyMappingEvent) : BukkitProxyEvent() {
        override val allowCancelled = true
    }


    class ServerKeyRegister(val key: String, value: ServerKey) : BukkitProxyEvent() {
        override val allowCancelled = true
    }

    class ServerKeyOn(val key: String, value: ServerKey, event: PlayerKeyBoardEvent) : BukkitProxyEvent() {
        override val allowCancelled = true
    }

}