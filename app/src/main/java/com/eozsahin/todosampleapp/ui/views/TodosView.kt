package com.eozsahin.todosampleapp.ui.views

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.eozsahin.todosampleapp.api.Todo
import com.eozsahin.todosampleapp.ui.components.TodoListRow
import com.eozsahin.todosampleapp.ui.models.TodoModel
import com.eozsahin.todosampleapp.ui.models.toTodoListRowModel
import com.eozsahin.todosampleapp.ui.viewmodels.TodoListViewModel

@Composable
fun TodosView(
    navController: NavController = rememberNavController(),
    viewModel: TodoListViewModel
) {
    val todos = viewModel.todos
    TodoList(Modifier.fillMaxSize(), todos)
}

@Composable
fun TodoList(
    modifier: Modifier = Modifier,
    todos: SnapshotStateList<TodoModel>
) {
    val listState = rememberLazyListState()

    LazyColumn(modifier, listState) {
        items(todos) { todo ->
            TodoListRow(
                modifier = Modifier.fillMaxWidth(),
                model = todo.toTodoListRowModel()
            )
        }
    }
}
