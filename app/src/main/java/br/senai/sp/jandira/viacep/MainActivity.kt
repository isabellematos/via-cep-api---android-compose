package br.senai.sp.jandira.viacep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.viacep.service.buscarCep
import br.senai.sp.jandira.viacep.ui.theme.ViaCepTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViaCepTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var cepState by remember {
        mutableStateOf("")
    }

    var resultState by remember {
        mutableStateOf("Resultado aqui")
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        OutlinedTextField(
            value = cepState,
            onValueChange = {result ->
                cepState = result
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Digite o CEP")
            }
        )
        Button(onClick = {
             buscarCep(cepState) { result ->
                 resultState = result
            }.toString()

        }) {
            Text(text = "Buscar")
        }
        Text(text = resultState)

        
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ViaCepTheme {
        Greeting("Android")
    }
}