package com.example.auth_ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth_domain.models.models.ErrorEntity
import com.example.auth_domain.models.models.loginState
import com.example.auth_domain.models.models.userDomain
import com.example.auth_domain.models.usecases.getUser
import com.example.auth_domain.models.usecases.login
import com.example.auth_domain.models.usecases.registrate
import kotlinx.coroutines.launch

class authViewModel(private val loginUser: login, private val registrateUser: registrate, private val getUser: getUser) : ViewModel() {
    private val curUser = MutableLiveData<loginState<userDomain>> ()
    val _curUser: LiveData<loginState<userDomain>>
        get() = curUser

    fun login(user: userDomain) {
        if (user.passwors.length < 8) curUser.postValue(loginState.Error(ErrorEntity.WrongCredentialsUsername()))
        else if (user.username.length < 4) curUser.postValue(loginState.Error(ErrorEntity.WrongCredentialsPassword()))
        else {
            viewModelScope.launch {
                val regRes = loginUser.execute(user)
                if (regRes) {
                    val cUser = getUser.execute(user.username)
                    curUser.postValue(loginState.Success(cUser))
                } else curUser.postValue(loginState.Error(ErrorEntity.WrongLoginOrPass()))
            }
        }
    }

    fun registrate(user: userDomain) {
        Log.i("Registrate", "going to execute")

        if (user.username.length < 4) curUser.postValue(loginState.Error(ErrorEntity.WrongCredentialsUsername()))
        if (isValidPassword(user.passwors)) {
            viewModelScope.launch {
                Log.i("Registrate", "going to execute")
                val cUser = registrateUser.execute(user)
                if (cUser) curUser.postValue(loginState.Success(user))
                else curUser.postValue(loginState.Error(ErrorEntity.DataBaceError()))
            }
        } else curUser.postValue(loginState.Error(ErrorEntity.WrongCredentialsPassword()))
    }

    private fun isValidPassword(password: String): Boolean {
        if (password.length < 8) return false
        if (password.filter { it.isDigit() }.firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null) return false
        if (password.filter { !it.isLetterOrDigit() }.firstOrNull() == null) return false

        return true
    }
}
