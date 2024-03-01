package com.explore.setuphilt.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.explore.setuphilt.domain.model.UserEntity
import com.explore.setuphilt.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(ViewState())
    var viewState = _uiState.asStateFlow()

    val users: LiveData<List<UserEntity>> = userRepository.getLiveUsers()
}

data class ViewState(
    val isLoading: Boolean = false,
    val data: List<UserEntity> = emptyList(),
    val isError: Boolean = false
)

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val userData: List<UserEntity>) : MainActivityUiState
}

