package com.example.unitconverter

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import kotlin.math.roundToInt

class UnitConverterViews {


    @Composable
    fun Title() {
        Text (
            text = "Unit Converter",
            style = MaterialTheme.typography.headlineLarge
        )
    }

    @Composable
    fun UnitsTextField(
        inputValue: MutableState<String>
    ) {
        val bordeaux = Color(0xFF800020)
        val black = Color(0xFF000000)

        OutlinedTextField (
            value = inputValue.value,
            onValueChange = { inputValue.value = it },
            label = { Text(text = "Enter Value") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = bordeaux,
                unfocusedBorderColor = bordeaux,
                focusedLabelColor = bordeaux,
                unfocusedLabelColor = black,
                cursorColor = bordeaux
            )
        )
    }

    @Composable
    fun ResultText(
        outputValue: MutableState<String>,
        oMetricsString: MutableState<String>
    ) {
        Text(
            text = "Result: ${outputValue.value} ${
                if (oMetricsString.value == "Output Unit") ""
                else oMetricsString.value}",
            style = MaterialTheme.typography.headlineMedium
        )
    }

    @Composable
    fun ConvertButton(
        inputValue: MutableState<String>,
        outputValue: MutableState<String>,
        inputFactor: MutableState<Double>,
        outputFactor: MutableState<Double>
    ) {
        Button(
            onClick = { convertUnits(inputValue, outputValue, inputFactor, outputFactor) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF800020), // Bordeaux
                contentColor = Color.White          // Text/Icon color
            )
        ) {
            Text(text = "Convert")
        }

    }

    @Composable
    fun InputBox (
        iMetricsString: MutableState<String>,
        iExpanded: MutableState<Boolean>,
        inputUnit: MutableState<String>,
        inputFactor: MutableState<Double>,
        unitOptions: List<Pair<String, Double>>
    ) {
        Box {
            // Input button
            UnitDropDownButton(iMetricsString.value) { iExpanded.value = true }
            DropdownMenuUnitConverter(
                isExpanded = iExpanded.value,
                onClick = { _, unit, factor ->
                    inputUnit.value = unit
                    inputFactor.value = factor
                    iExpanded.value = false
                    iMetricsString.value = unit
                },
                onDismissRequest = { iExpanded.value = false },
                unitOptions,
            )
        }
    }
    
    @Composable
    fun OutputBox (
        oMetricsString: MutableState<String>,
        oExpanded: MutableState<Boolean>,
        outputUnit: MutableState<String>,
        outputFactor: MutableState<Double>,
        unitOptions: List<Pair<String, Double>>
    ) {
        Box {
            // Output button
            UnitDropDownButton(oMetricsString.value) { oExpanded.value = true }
            DropdownMenuUnitConverter(
                isExpanded = oExpanded.value,
                onClick = { _, unit, factor ->
                    outputUnit.value = unit
                    outputFactor.value = factor
                    oExpanded.value = false
                    oMetricsString.value = unit
                },
                onDismissRequest = { oExpanded.value = false },
                unitOptions,
            )
        }
    }
    @Composable
    fun DropdownMenuUnitConverter (
        isExpanded: Boolean,
        onClick: (Boolean, String, Double) -> Unit,
        onDismissRequest: () -> Unit,
        options: List<Pair<String, Double>>
    ) {
        DropdownMenu(expanded = isExpanded, onDismissRequest = onDismissRequest) {
            for ((label, factor) in options) {
                DropdownMenuItem(
                    text = { Text(text = label) },
                    onClick = {
                        onClick(false, label, factor)
                    }
                )
            }
        }
    }

    @Composable
    fun UnitDropDownButton (text: String, onClick: () -> Unit) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF800020), // Bordeaux
                contentColor = Color.White          // Text/Icon color
            )
        ) {
            Text(text = text)
            Icon(
                Icons.Default.ArrowDropDown,
                contentDescription = "Arrow Down"
            )

        }
    }

    // Auxiliary function
    private fun convertUnits (
        inputValue: MutableState<String>,
        outputValue: MutableState<String>,
        inputFactor: MutableState<Double>,
        outputFactor: MutableState<Double>
    ) {
        val inputValueDouble = inputValue.value.toDoubleOrNull() ?: 0.0
        val result =
            (inputValueDouble * inputFactor.value / outputFactor.value * 100.0).roundToInt() / 100.0
        outputValue.value = result.toString()
    }

}