package com.eozsahin.todosampleapp.ui.views

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.eozsahin.todosampleapp.ui.components.TopNavBar
import androidx.compose.material.FabPosition
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import com.eozsahin.todosampleapp.ui.components.TodoFAB
import com.eozsahin.todosampleapp.ui.navigation.AppNavHost
import com.eozsahin.todosampleapp.ui.navigation.Screens

@Composable
fun RootView() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screens.getFromNav(navBackStackEntry)

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopNavBar(navController) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            if (currentScreen == Screens.TodoList) {
                TodoFAB {
                    navController.navigate(Screens.AddTodo.route)
                }
            }
        }
    ) {
        AppNavHost(navController)
    }
}