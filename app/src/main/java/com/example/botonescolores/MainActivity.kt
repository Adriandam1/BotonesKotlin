package com.example.botonescolores

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Botones()
        }
    }
}

//enum class para usar en los botones, TODO : aplicar a todos los componentes
enum class ColoresNumerados(val colorNumero: Int, val nombre: String = "blanco") {
    AZUL(1, "Azulito"),Rojo(2, "Rojojito"),Amarillo(3, "Amarillo"),Verde(4 ,"Verde")
}
// Data class para almacenar los colores seleccionados
data class ColorSeleccionado(val auxiliar: String){
    var color: String = auxiliar
}

/*
data class ColorSeleccionado(val nombre: String, val color: Color){
}*/


@Composable
fun Botones() {
    // Estado para el color y el nombre del color
    var colorName by remember { mutableStateOf("") }
    var colorValue by remember { mutableStateOf(Color.White) }
    var colorNumber by remember { mutableIntStateOf(0)  }

    val listaColores: MutableList<String> = mutableListOf()



    //var listaColores = remember {mutableStateListOf<String>()}



    Column(modifier = Modifier.padding(vertical = 200.dp)) {
        Button(
            onClick = {
                colorName = ColoresNumerados.AZUL.nombre
                colorValue = Color.Blue
                colorNumber = ColoresNumerados.AZUL.colorNumero
                Log.d("Boton pulsado", "se ha pulsado el boton $colorName, y su nomero es $colorNumber")

                listaColores.add(colorName)
                Log.d("La lista de colores actualizada es: ", "ListaColores: $listaColores")


                val ColorSeleccionado1 = ColorSeleccionado("Azul")
                Log.d("prubeas", "${ColorSeleccionado1}")
                Log.d ("pruebnas2", ColorSeleccionado1.auxiliar)



                /*val ColorSeleccionado1 = ColorSeleccionado("$listaColores")
                Log.d("prubeas", "${ColorSeleccionado1}")*/


            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text("AZUL", fontSize = 24.sp, color = Color.White)
        }

        Button(
            onClick = {
                colorName = ColoresNumerados.Rojo.nombre
                colorValue = Color.Red
                colorNumber = ColoresNumerados.Rojo.colorNumero
                Log.d("Boton pulsado", "se ha pulsado el boton $colorName, y su nomero es $colorNumber")

                listaColores.add(colorName)
                Log.d("La lista de colores actualizada es: ", "ListaColores: $listaColores")

                val ColorSeleccionado1 = ColorSeleccionado("$listaColores")
                Log.d("prubeas", "${ColorSeleccionado1}")

            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text("ROJO", fontSize = 24.sp, color = Color.White)
        }

        Button(
            onClick = {
                colorName = ColoresNumerados.Amarillo.nombre
                colorValue = Color.Yellow
                colorNumber = ColoresNumerados.Amarillo.colorNumero
                Log.d("Boton pulsado", "se ha pulsado el boton $colorName, y su nomero es $colorNumber")

                listaColores.add(colorName)
                Log.d("La lista de colores actualizada es: ", "ListaColores: $listaColores")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
        ) {
            Text("AMARILLO", fontSize = 24.sp, color = Color.Black)
        }

        Button(
            onClick = {
                colorName = ColoresNumerados.Verde.nombre
                colorValue = Color.Green
                colorNumber = ColoresNumerados.Verde.colorNumero
                Log.d("Boton pulsado", "se ha pulsado el boton $colorName, y su nomero es $colorNumber")

                listaColores.add(colorName)
                Log.d("La lista de colores actualizada es: ", "ListaColores: $listaColores")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
        ) {
            Text("VERDE", fontSize = 24.sp, color = Color.White)
        }

        // Campo de texto que muestra el nombre del color
        TextField(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxSize(), //rellena el maximo posible
                //.fillMaxWidth(), //rellena horizontalmente
            value = colorName, // Muestra el nombre del color
            onValueChange = {},
            label = { Text(text = "Color: ", fontSize = 24.sp) }, //Texto del titulo del textflied
            textStyle = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold), // Texto del TextField
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorValue,
                unfocusedContainerColor = colorValue,
                disabledContainerColor = colorValue
            )
        )
    }
}

