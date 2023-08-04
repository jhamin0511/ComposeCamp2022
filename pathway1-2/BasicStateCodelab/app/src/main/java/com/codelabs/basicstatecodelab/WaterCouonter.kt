package com.codelabs.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelabs.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }

        if (count > 0) {
            var showTask by rememberSaveable { mutableStateOf(true) }

            if (showTask) {
                WellnessTaskItem(taskName = "Have you taken your 15 minute walk today?")
            }

            Text(text = "You've had $count glasses.")
        }
        Row(Modifier.padding(top = 8.dp)) {
            Button(
                onClick = { count++ },
                shape = CircleShape,
                enabled = count < 10
            ) {
                Text("Add one")
            }
            Button(
                onClick = { count = 0 },
                Modifier.padding(start = 8.dp)
            ) {
                Text("Clear water count")
            }
        }
    }
}


@Preview
@Composable
fun WaterCounterPreview() {
    BasicStateCodelabTheme {
        WaterCounter()
    }
}

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
