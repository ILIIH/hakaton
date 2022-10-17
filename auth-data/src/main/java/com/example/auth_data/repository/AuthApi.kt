package com.example.auth_data.repository

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.auth_domain.models.models.userDomain
import com.example.auth_domain.models.repository.authRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class authApi(private val context: Context) : authRepository {

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
    override suspend fun getUserByLogin(username: String): userDomain? {
        val json = sharedPreferences.getString(username, null) ?: return null
        return Gson().fromJson(json, userDomain::class.java)
    }

    override suspend fun registrate(user: userDomain): Boolean {
        return withContext(Dispatchers.IO) {
            val privUser = getUserByLogin(user.username)
            Log.i("Registrate", "Priv use = $privUser")
            return@withContext if (privUser != null) false
            else {
                val json = Gson().toJson(user)
                editor.putString(user.username, json).apply()
                true
            }
        }
    }
}
