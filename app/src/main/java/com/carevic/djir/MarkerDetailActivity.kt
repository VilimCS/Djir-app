package com.carevic.djir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import com.carevic.djir.ui.theme.DjirTheme

class MarkerDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DjirTheme {
                Surface(modifier = Modifier.padding(16.dp), color = MaterialTheme.colorScheme.background) {
                    // Retrieve data passed from the marker click
                    val title = intent.getStringExtra("title") ?: "Unknown Title"
                    val description = intent.getStringExtra("description") ?: "No description available"
                    val imageResId = intent.getIntExtra("image_res_id", 0)

                    Column {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = description,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        // Display the image from resources
                        if (imageResId != 0) {
                            Image(
                                painter = painterResource(id = imageResId),
                                contentDescription = "Location Image"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MarkerDetailPreview() {
    DjirTheme {
        MarkerDetailActivity()
    }
}