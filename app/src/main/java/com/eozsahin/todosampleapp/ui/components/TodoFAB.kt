package com.eozsahin.todosampleapp.ui.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable

@Composable
fun TodoFAB(
    onTapped: () -> Unit = {}
) {
    FloatingActionButton(
        onClick = {
            onTapped()
        }
    ) {
        Icon(Icons.Filled.Create, "")
    }
}