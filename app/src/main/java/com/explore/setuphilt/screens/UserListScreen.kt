package com.explore.setuphilt.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.explore.setuphilt.domain.model.User
import com.explore.setuphilt.screens.components.UserListItem

@Composable
fun UserListScreen(userList: List<User>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(userList) { user ->
            UserListItem(user = user)
            Divider()
        }
    }
}
