package com.explore.setuphilt.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.explore.setuphilt.domain.model.User

@Composable
fun UserListItem(user: User, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = "${user.firstName} ${user.lastName}")
        user.email?.let { Text(text = it) }
        // Add more details or UI components as needed
    }
}
