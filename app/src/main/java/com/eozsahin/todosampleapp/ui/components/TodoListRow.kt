package com.eozsahin.todosampleapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class TodoListRowModel(
    val title: String = "This is a to do list item",
    val completed: Boolean = true
)

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun TodoListRow(
    modifier: Modifier = Modifier,
    model: TodoListRowModel = TodoListRowModel()
) {
    var isChecked by remember { mutableStateOf(model.completed)}

    Row(
        modifier = modifier
            .clickable { isChecked = !isChecked }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(model.title, modifier = Modifier.weight(1f))
        Checkbox(
            modifier = Modifier.padding(start = 8.dp),
            checked = isChecked,
            onCheckedChange = { isChecked = !isChecked }
        )
    }
}
