package u.caldas.tallerparcialmovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import u.caldas.tallerparcialmovil.ui.theme.TallerParcialMovilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCalculadora()
        }
    }
}

@Composable
fun AppCalculadora() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DisplayScreen("0")

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculadoraButton("C")
                CalculadoraButton("()")
                CalculadoraButton("%")
                CalculadoraButton("!")
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculadoraButton("1")
                CalculadoraButton("2")
                CalculadoraButton("3")
                CalculadoraButton("/")
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculadoraButton("4")
                CalculadoraButton("5")
                CalculadoraButton("6")
                CalculadoraButton("*")
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculadoraButton("7")
                CalculadoraButton("8")
                CalculadoraButton("9")
                CalculadoraButton("-")
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculadoraButton("0")
                CalculadoraButton(".")
                CalculadoraButton("=")
                CalculadoraButton("+")
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
fun CalculadoraButton(symbol: String) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .size(80.dp)
            .padding(4.dp)
    ) {
        Text(text = symbol, fontSize = 24.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppCalculadora()
}