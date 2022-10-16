package com.example.auth_data.sourses

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.auth_domain.models.models.userDomain
import com.google.gson.Gson

class authApi(private val context: Context) {

    @RequiresApi(Build.VERSION_CODES.M)
    val masterKeyAlias: String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    @RequiresApi(Build.VERSION_CODES.M)
    val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
        "secret_shared_prefs",
        masterKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    @RequiresApi(Build.VERSION_CODES.M)
    val editor = sharedPreferences.edit()

    @RequiresApi(Build.VERSION_CODES.M)
    fun registrateUser(user: userDomain): Boolean {
        val privUser = getUserByLogin(user.username)
        return if (privUser == null) false
        else {
            val json = Gson().toJson(user)
            editor.putString(user.username, json).apply()
            true
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun getUserByLogin(username: String): userDomain? {
        val json = sharedPreferences.getString(username, null) ?: return null
        return Gson().fromJson(json, userDomain::class.java)
    }
}
