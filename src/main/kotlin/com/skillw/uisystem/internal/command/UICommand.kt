package com.skillw.uisystem.internal.command

import com.skillw.pouvoir.util.soundClick
import com.skillw.pouvoir.util.soundFail
import com.skillw.pouvoir.util.soundSuccess
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.UIApi.openGui
import com.skillw.uisystem.api.UIApi.removeHud
import com.skillw.uisystem.api.UIApi.sendHud
import com.skillw.uisystem.internal.manager.UIConfig.isDebug
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.*
import taboolib.common.platform.function.console
import taboolib.module.chat.colored
import taboolib.module.lang.sendLang
import taboolib.platform.util.bukkitPlugin
import taboolib.platform.util.sendLang

@CommandHeader(name = "ui", permission = "ui.command")
object UICommand {

    internal fun ProxyCommandSender.soundSuccess() {
        (this.origin as? Player?)?.soundSuccess()
    }

    internal fun ProxyCommandSender.soundFail() {
        (this.origin as? Player?)?.soundFail()
    }

    @CommandBody
    val main = mainCommand {
        execute<ProxyCommandSender> { sender, _, _ ->
            sender.sendLang("command-info")
            sender.soundSuccess()
        }
        incorrectCommand { sender, _, _, _ ->
            sender.sendLang("wrong-command")
            sender.soundFail()
        }
        incorrectSender { sender, _ ->
            sender.sendLang("wrong-sender")
            sender.soundFail()
        }
    }

    @CommandBody(permission = "ui.command.help")
    val help = subCommand {
        execute<ProxyCommandSender> { sender, _, _ ->
            sender.soundSuccess()
            sender.sendLang("command-info")
        }
    }

    @CommandBody(permission = "ui.command.debug")
    val debug = subCommand {
        execute<ProxyCommandSender> { sender, _, _ ->
            sender.soundSuccess()
            isDebug = if (!isDebug) {
                sender.sendMessage("&aDebug on!".colored())
                true
            } else {
                sender.sendMessage("&aDebug off!".colored())
                false
            }
        }
    }
    @CommandBody(permission = "ui.command.open")
    val open = subCommand {
        dynamic("guiID"){
            suggestion<ProxyCommandSender> {zxy, _->
                zxy.soundSuccess()
                UISystem.guiManager.keys.toList()
            }
            execute<ProxyCommandSender> {zxy,context,_->
                (zxy.origin as Player).openGui(context["guiID"])
            }
        }
    }

    @CommandBody(permission = "ui.command.sendHUD")
    val sendHUD = subCommand {
        dynamic("hudID"){
            suggestion<ProxyCommandSender> {zxy, _->
                zxy.soundSuccess()
                UISystem.hudManager.keys.toList()
            }
            execute<ProxyCommandSender> {zxy,context,_->
                (zxy.origin as Player).sendHud(context["hudID"])
            }
        }
    }

    @CommandBody(permission = "ui.command.removeHUD")
    val removeHUD = subCommand {
        dynamic("hudID"){
            suggestion<ProxyCommandSender> {zxy, _->
                zxy.soundSuccess()
                UISystem.hudManager.keys.toList()
            }
            execute<ProxyCommandSender> {zxy,context,_->
                (zxy.origin as Player).removeHud(context["hudID"])
            }
        }
    }

    @CommandBody(permission = "ui.command.reload")
    val reload = subCommand {
        execute<ProxyCommandSender> { sender, _, _ ->
            sender.soundSuccess()
            UISystem.reload()
            sender.sendLang("command-reload")
        }
    }

}