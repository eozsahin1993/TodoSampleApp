package com.eozsahin.todosampleapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eozsahin.todosampleapp.api.Todo
import com.eozsahin.todosampleapp.ui.viewmodels.TodoListViewModel
import com.eozsahin.todosampleapp.ui.views.TodosView

private object Routes {
    const val TodoList = "todo-list"
    const val AddTodo = "todo-add"
}

sealed class Screens(val route: String, val topBarTitle: String) {
    object TodoList : Screens(Routes.TodoList, "Todo List")
    object AddTodo : Screens(Routes.AddTodo, "Add Todo")

    companion object {
        fun getFromNav(navBackStackEntry: NavBackStackEntry?): Screens {
            return when (navBackStackEntry?.destination?.route ?: "") {
                Routes.TodoList -> TodoList
                Routes.AddTodo -> AddTodo
                else -> TodoList
            }
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.TodoList.route
    ) {
        composable(Screens.TodoList.route) {
            val viewModel: TodoListViewModel = hiltViewModel()
            TodosView(navController, viewModel)
        }

        composable(Screens.AddTodo.route) {
            //val viewModel = CreatePostViewModel()
            //CreatePostScreen(viewModel, navController)
        }
    }
}