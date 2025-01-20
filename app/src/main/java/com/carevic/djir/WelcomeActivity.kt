package com.carevic.djir

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carevic.djir.ui.theme.DjirTheme


class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DjirTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    WelcomeScreen()
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen() {
    Log.d("Debug", "Background Color: ${MaterialTheme.colorScheme.background}")
    Log.d("Debug", "Primary Color: ${MaterialTheme.colorScheme.primary}")
    Log.d("Debug", "On Primary Color: ${MaterialTheme.colorScheme.onPrimary}")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // App Icon
        Image(
            painter = painterResource(id = R.drawable.ic_shortcut_beer),
            contentDescription = "App Icon",
            modifier = Modifier.size(120.dp)
        )

        // Welcome Text
        Spacer(modifier = Modifier.height(24.dp))
        BasicText(
            text = stringResource(id = R.string.welcome_message),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        val context = LocalContext.current
        // Continue Button
        Button(
            onClick = {
                // Navigate to MainActivity when button is clicked
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
                // Close the current activity
                if (context is ComponentActivity) {
                    context.finish()
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = stringResource(id = R.string.continue_button))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    DjirTheme {
        WelcomeScreen()
    }
}
