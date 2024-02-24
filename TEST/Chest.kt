package com.skillw.uisystem.api.gui

import com.skillw.uisystem.UISystem

abstract class Chest: Gui() {
    abstract override val key: String

    abstract val title: String
    override fun register() {
        UISystem.chestManager.register(this)
        //注册进Gui里
        super.register()
    }

}