package com.example.ziririt.presentation.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
//    context: Context,
) : ViewModel() {

    companion object {
        const val TAG = "LoginViewModel"
    }

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> get() = _loginSuccess

    var username = mutableStateOf("")
        private set

    var password = mutableStateOf("")
        private set

    var passwordVisible = mutableStateOf(false)
        private set

    fun onUsernameChange(newUsername: String) {
        username.value = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
    }

    fun onPasswordVisibilityToggle() {
        passwordVisible.value = !passwordVisible.value
    }

    fun login() {
        viewModelScope.launch {
            // 로그인 로직을 여기에 추가
            val isSuccess = authenticateUser(username.value, password.value)
            _loginSuccess.value = isSuccess
        }
    }

    private suspend fun authenticateUser(username: String, password: String): Boolean {
        // 실제 로그인 검증 로직을 여기에 추가합니다.
        // 예를 들어, 서버와 통신하여 로그인 정보를 확인하는 코드
        return username == "test" && password == "test" // Test
    }
}
