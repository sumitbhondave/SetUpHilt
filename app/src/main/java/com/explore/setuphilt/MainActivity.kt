package com.explore.setuphilt

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
                        UserList2(this)
                    }
                }
            }
        }
    }
}

@Composable
fun UserList() {
    val userViewModel: UserViewModel = viewModel()
    val uiState by userViewModel.viewState.collectAsStateWithLifecycle()

    if (uiState.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                modifier = Modifier.width(48.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }
    } else if (uiState.isError) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = "Error at Api Level", style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Red
                )
            )
        }
    } else {
        UserListScreen(uiState.data)
    }
}

@Composable
fun UserList2(context: MainActivity) {
    val userViewModel: UserViewModel = viewModel()
    val uiState by userViewModel.items.observeAsState()
    Log.d("sumit", "new_way of uiState: $uiState")
}