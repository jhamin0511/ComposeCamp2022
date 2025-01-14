package com.codelabs.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelabs.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        if (count > 0) {
            Text(text = "You've had $count glasses.")
        }
        Button(
            onClick = onIncrement,
            shape = CircleShape,
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text("Add one")
        }
    }
}

@Preview
@Composable
fun StatelessCounterPreview() {
    BasicStateCodelabTheme {
        var count by remember { mutableStateOf(0) }
        StatelessCounter(count = count, onIncrement = { count++ })
    }
}

@Composable
fun StatefulCounter(
    modifier: Modifier = Modifier
) {
    var count by remember { mutableStateOf(0) }
    Column(modifier = modifier) {
        StatelessCounter(count, { count++ })
    }
}

@Preview
@Composable
fun StatefulCounterPreview() {
    BasicStateCodelabTheme {
        StatefulCounter()
    }
}
