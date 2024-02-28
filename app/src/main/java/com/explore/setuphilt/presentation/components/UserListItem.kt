package com.explore.setuphilt.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.explore.setuphilt.domain.model.User

@Composable
fun UserListItem(user: User, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row {
            AsyncImage(
                model = user.avatar,
                contentDescription = null,
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = "${user.first_name} ${user.last_name}")
                user.email?.let { Text(text = it) }
            }
        }
    }
}
