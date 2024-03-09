package com.skillw.uisystem.internal.feather.compat.pouvoir.database

import com.skillw.pouvoir.Pouvoir
import com.skillw.pouvoir.api.feature.database.UserBased
import com.skillw.pouvoir.api.plugin.annotation.AutoRegister
import com.skillw.uisystem.internal.manager.UIConfig

@AutoRegister
object UiContainer: UserBased {
    val holder by lazy {
        Pouvoir.databaseManager.containerHolder(UIConfig.databaseConfig)!!
    }
    val container: UserBased by lazy {
        holder.container("ui_data", true) as UserBased
    }

    override fun get(user: String, key: String): String? {
        return container[user, key]
    }

    override fun delete(user: String, key: String) {
        return container.delete(user, key)
    }

    override fun set(user: String, key: String, value: String?) {
        container[user, key] = value
    }

    override fun contains(user: String, key: String): Boolean {
        return container.contains(user, key)
    }

}