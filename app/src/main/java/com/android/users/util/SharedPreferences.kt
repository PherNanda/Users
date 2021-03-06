package com.android.users.util

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.StringRes

@Suppress("ReturnCount")
inline fun <reified T> SharedPreferences.get(appContext: Context, @StringRes stringRes: Int, defaultValue: T): T {
    val key = appContext.getString(stringRes)
    when (T::class) {
        Boolean::class -> return this.getBoolean(key, defaultValue as Boolean) as T
        Float::class -> return this.getFloat(key, defaultValue as Float) as T
        Int::class -> return this.getInt(key, defaultValue as Int) as T
        Long::class -> return this.getLong(key, defaultValue as Long) as T
        String::class -> return this.getString(key, defaultValue as String) as T
        else -> {
            if (defaultValue is Set<*>) {
                return this.getStringSet(key, defaultValue as Set<String>) as T
            }
        }
    }

    return defaultValue
}