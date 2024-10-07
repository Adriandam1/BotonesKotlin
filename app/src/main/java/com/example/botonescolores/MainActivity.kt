package com.example.botonescolores

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.botonescolores.ui.theme.BotonesColoresTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Botones()
        }
    }
}


@Composable
fun Botones(){

    var color = remember { mutableStateOf("") }

    Column (
        modifier = Modifier.padding(vertical = 200.dp)

    )
    {

        Button(onClick = {color.value = "Azul"}) {
            Text("AZUL", fontSize = 24.sp)
        }
        Button(onClick = {color.value = "Rojo" }) {
            Text("ROJO", fontSize = 24.sp)
        }
        Button(onClick = {color.value = "Amarillo" }) {
            Text("AMARILLO", fontSize = 24.sp)
        }
        Button(onClick = {color.value = "Verde" }) {
            Text("VERDE", fontSize = 24.sp)
        }

        // campo de texto para rellenar
        // cuando el valor de name cambia, le asigna el valor de it(el nuevo que cambia)
        TextField(modifier = Modifier,
            value = color.value,
            // onValueChange sería el listener del textfield
            onValueChange = {
                color.value = it
            },
            label = { Text(text = "Color: ", fontSize = 24.sp) }
        )
        //modifier = Modifier.
    }
}