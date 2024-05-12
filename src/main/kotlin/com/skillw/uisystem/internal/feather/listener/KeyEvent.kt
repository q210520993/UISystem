package com.skillw.uisystem.internal.feather.listener

import com.daxton.unrealcore.common.event.PlayerKeyBoardEvent
import com.daxton.unrealcore.common.event.PlayerKeyMappingEvent
import com.daxton.unrealcore.communication.event.PlayerConnectionSuccessfulEvent
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.UIApi.sendKeyMapping
import com.skillw.uisystem.api.event.SCKeyEvent
import com.skillw.uisystem.internal.manager.UIConfig.debug
import org.bukkit.entity.Player
import taboolib.common.platform.event.SubscribeEvent

object KeyEvent {
    @SubscribeEvent
    fun playerKeyBoardEvent(event: PlayerKeyBoardEvent) {
        debug {
            println("KeyName: ${event.keyName}")
            println("KeyID: ${event.keyID}")
            println("KeyAction: ${event.keyAction}")
        }
        if (!event.isInputNow && event.keyAction == 1) {
            UISystem.serverKeyManager[event.keyName]?.exec(event.player) ?: return
        }
    }

    @SubscribeEvent
    fun playerKeyMappingEvent(event: PlayerKeyMappingEvent) {
        UISystem.clientKeyManager[event.keyMapKey]?.let {
            it.exec(player = event.player)
            SCKeyEvent.ClientKeyOn(event.keyMapKey, it, event).call()
        } ?: return
    }

    @SubscribeEvent
    internal fun playerConnectionSuccessfulEvent(event: PlayerConnectionSuccessfulEvent){
//        val list = ArrayList<String>()
//        val uuid = event.player.uniqueId.toString()
//        val listU: List<String>? = UiContainer[uuid, "ClientKey"]?.let {
//            val itemType = object : TypeToken<List<String>>() {}.type
//            val list: List<String> = gson.fromJson(it, itemType)
//            return@let list
//        }

        event.player.let let1@{ player: Player ->

            UISystem.clientKeyManager.forEach{ key ->
//                println("1")
//                if(!key.value.isAutoSendToPlayer) return@forEach
//                //看表中是否存在玩家
//                listU ?: run {
//                    debug {
//                        println("runner")
//                    }
//                    list.add(key.key)
//                    player.sendKeyMapping(key.key)
//                    return@forEach
//                }
//                //看表中的玩家是否有对应的key
//                if(listU.contains(key.key)){
//                    println("runners")
//                    return@forEach
//                }
//                println("HelloSending")
//                //符合就直接发送
//                list.add(key.key)
                player.sendKeyMapping(key.key)
            }
//            val apply = kotlin.run {
//                println("run")
//                if (listU == null)
//                    return@run list
//                return@run list + listU
//            }
//            val json = Gson.toJson(apply)
//            UiContainer[uuid, "ClientKey"] = json
        }
    }

}