package net.ivanvega.miholamundo

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.ivanvega.miholamundo.ui.theme.MiHolaMundoTheme


class MiOtraActivity : ComponentActivity(){


}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiHolaMundoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //HolaMundo()
                    Column() {
                        var t = remember { mutableStateOf("Hola") }
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        HolaMundo()
                        HolaMundo()
                        TextField(value = t.value, onValueChange = { x: String -> t.value = x})
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MiLogCat", " paso por onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MiLogCat", " paso por OnResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("MiLogCat", " paso por OnRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MiLogCat", " paso por OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("MiLogCat", " paso por OnDestroy")
    }

}

@Composable
fun HolaMundo(){
    Text(text = "Hola Mundo", modifier = Modifier.padding(48.dp))
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiHolaMundoTheme {
        Greeting("Android")
    }
}