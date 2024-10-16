package u.caldas.tallerparcialmovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorApp()
        }
    }
}

@Composable
fun CalculatorApp() {
    var input by remember { mutableStateOf("") }
    var result by remember { mutableDoubleStateOf(0.0) }
    var operation by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DisplayScreen(input.ifEmpty { result.toString() })

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton("7") { input += "7" }
                CalculatorButton("8") { input += "8" }
                CalculatorButton("9") { input += "9" }
                CalculatorButton("/") { selectOperation("/", input, result, onSelectOperation = { op, res ->
                    operation = op
                    result = res
                    input = ""
                }) }
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton("4") { input += "4" }
                CalculatorButton("5") { input += "5" }
                CalculatorButton("6") { input += "6" }
                CalculatorButton("*") { selectOperation("*", input, result, onSelectOperation = { op, res ->
                    operation = op
                    result = res
                    input = ""
                }) }
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton("1") { input += "1" }
                CalculatorButton("2") { input += "2" }
                CalculatorButton("3") { input += "3" }
                CalculatorButton("-") { selectOperation("-", input, result, onSelectOperation = { op, res ->
                    operation = op
                    result = res
                    input = ""
                }) }
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton("0") { input += "0" }
                CalculatorButton(".") { input += "." }
                CalculatorButton("=") {
                    result = calculate(result, input, operation)
                    input = result.toString()
                    operation = null
                }
                CalculatorButton("+") { selectOperation("+", input, result, onSelectOperation = { op, res ->
                    operation = op
                    result = res
                    input = ""
                }) }
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton("C") {
                    input = ""
                    result = 0.0
                    operation = null
                }
            }
        }
    }
}

@Composable
fun DisplayScreen(value: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(text = value, fontSize = 48.sp)
    }
}

@Composable
fun CalculatorButton(symbol: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(80.dp)
            .padding(4.dp),
        colors = ButtonDefaults.buttonColors()
    ) {
        Text(text = symbol, fontSize = 24.sp)
    }
}

// Función para seleccionar operación
fun selectOperation(
    op: String,
    input: String,
    currentResult: Double,
    onSelectOperation: (String, Double) -> Unit
) {
    val inputValue = input.toDoubleOrNull() ?: currentResult
    onSelectOperation(op, inputValue)
}

// Función para realizar cálculos
fun calculate(result: Double, input: String, operation: String?): Double {
    val inputValue = input.toDoubleOrNull() ?: return result
    return when (operation) {
        "+" -> result + inputValue
        "-" -> result - inputValue
        "*" -> result * inputValue
        "/" -> if (inputValue != 0.0) result / inputValue else result
        else -> inputValue
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorApp()
}