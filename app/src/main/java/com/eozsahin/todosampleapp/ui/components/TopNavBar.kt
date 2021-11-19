package com.eozsahin.todosampleapp.ui.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.eozsahin.todosampleapp.ui.navigation.Screens

@Preview
@Composable
fun TopNavBar(
    navController: NavController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val title = Screens.getFromNav(navBackStackEntry).topBarTitle

    TopAppBar(
        title = { Text(title) },
    )
}