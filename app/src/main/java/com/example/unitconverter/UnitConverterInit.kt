package com.example.unitconverter

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun UnitConverterViews.StartComposable() {

    val inputValue = rememberSaveable { mutableStateOf("") }
    val outputValue = rememberSaveable { mutableStateOf("") }

    val inputUnit = rememberSaveable { mutableStateOf("Meters") }
    val outputUnit = rememberSaveable { mutableStateOf("Meters") }

    val iExpanded = rememberSaveable { mutableStateOf(false) }
    val oExpanded = rememberSaveable { mutableStateOf(false) }

    val inputFactor = rememberSaveable { mutableStateOf(1.00) }
    val outputFactor = rememberSaveable { mutableStateOf(1.00) }

    val iMetricsString = rememberSaveable { mutableStateOf("Input Unit") }
    val oMetricsString = rememberSaveable { mutableStateOf("Output Unit") }

    val unitOptions = listOf(
        "Centimeters" to 0.01,
        "Meters" to 1.0,
        "Feet" to 0.3048,
        "Millimeters" to 0.001
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Here all the UI elements will be stacked below each other

        Title()
        Spacer(modifier = Modifier.height(16.dp))
        UnitsTextField(inputValue)

        val context = LocalContext.current
        if (inputValue.value.toDoubleOrNull() == null && inputValue.value.isNotBlank()) {
            Toast.makeText(context, "Invalid value", Toast.LENGTH_SHORT).show()
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            InputBox(iMetricsString, iExpanded, inputUnit, inputFactor, unitOptions)
            Spacer(modifier = Modifier.width(16.dp))
            OutputBox(oMetricsString, oExpanded, outputUnit, outputFactor, unitOptions)
        }

        Spacer(modifier = Modifier.height(20.dp))

        ConvertButton(inputValue, outputValue, inputFactor, outputFactor)

        Spacer(modifier = Modifier.height(16.dp))

        ResultText(outputValue, oMetricsString)
    }
}