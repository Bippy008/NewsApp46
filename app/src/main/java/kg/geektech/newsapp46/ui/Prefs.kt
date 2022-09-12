package kg.geektech.newsapp46.ui

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri

class Prefs(context: Context) {
    private var preferences = context.
    getSharedPreferences("settings", Context.MODE_PRIVATE)

    fun saveState() {
        preferences.edit().putBoolean("isShown", true).apply()
    }

    fun isShown() : Boolean {
        return preferences.getBoolean("isShown", false)
    }

    fun saveAvatar(avatarUri : String?) {
        avatarUri?.let {
            preferences.edit().putString("avatarUri", avatarUri.toString()).apply()
        }
    }

    fun getAvatar() : String? {
        return preferences.getString("avatarUri", "")
    }

    fun saveName(name : String?) {
        preferences.edit().putString("profileName", name)
    }

    fun getName() : String? {
        return preferences.getString("profileName", "")
    }
}