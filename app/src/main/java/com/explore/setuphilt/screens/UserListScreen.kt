package com.explore.setuphilt.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.explore.setuphilt.screens.components.UserListItem
import com.explore.setuphilt.screens.viewmodels.UserViewModel

@Composable
fun UserListScreen(userViewModel: UserViewModel = viewModel()) {
    val users by userViewModel.userList.observeAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(users) { user ->
            UserListItem(user = user)
            Divider()
        }
    }
}
