package com.explore.setuphilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.explore.setuphilt.presentation.UserListScreen
import com.explore.setuphilt.presentation.viewmodels.UserViewModel
import com.explore.setuphilt.ui.theme.SetUpHiltTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetUpHiltTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "User List")
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.Blue,
                                titleContentColor = Color.White
                            ),
                        )
                    }
                ) { internalPadding ->
                    Surface(modifier = Modifier.padding(internalPadding)) {
                        UserList()
                    }
                }
            }
        }
    }
}

@Composable
fun UserList() {
    val userViewModel: UserViewModel = viewModel()
    val users by userViewModel.users.observeAsState(listOf())

    UserListScreen(users)
}