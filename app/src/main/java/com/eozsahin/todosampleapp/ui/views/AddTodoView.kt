package com.eozsahin.todosampleapp.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.eozsahin.todosampleapp.ui.viewmodels.AddTodoViewModel

@Composable
fun AddTodoView(
    navController: NavController = rememberNavController(),
    viewModel: AddTodoViewModel
) {
    var textValue by remember { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            value = textValue,
            shape = RectangleShape,
            placeholder = { Text("Clean the dishes...") },
            onValueChange = {
                textValue = it
            }
        )
        Button(
            onClick = {
                viewModel.addTodo(textValue)
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            enabled = textValue.isNotEmpty()
        ) {
            Text("Save")
        }
    }
}