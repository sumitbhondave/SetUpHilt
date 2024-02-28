package com.explore.setuphilt.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.explore.setuphilt.domain.model.User
import com.explore.setuphilt.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(ViewState())
    var viewState = _uiState.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    init {
        viewModelScope.launch(Dispatchers.Default + coroutineExceptionHandler) {
            _uiState.value = _uiState.value.copy(isLoading = true)
            val users = userRepository.getUsers(page = 1)
            if (users.isNotEmpty()) {
                _uiState.value = _uiState.value.copy(isLoading = false, data = users)
            } else {
                _uiState.value = _uiState.value.copy(isLoading = false, isError = true)
            }
        }
    }
}

data class ViewState(
    val isLoading: Boolean = false,
    val data: List<User> = emptyList(),
    val isError: Boolean = false
)
