package com.carevic.djir

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.carevic.djir.data.LocationRepository
import com.carevic.djir.data.LocationRepository.locations
import com.carevic.djir.ui.theme.DjirTheme
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState

class MarkerDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DjirTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // Retrieve data passed from the marker click
                    val title = intent.getStringExtra("title") ?: "Unknown Title"
                    val description = intent.getStringExtra("description") ?: "No description available"
                    val imageResId = intent.getIntExtra("image_res_id", 0)
                    val nearbyLocations = intent.getStringArrayListExtra("nearbyLocations") ?: arrayListOf()

                    MarkerDetailScreen(
                        title = title,
                        description = description,
                        imageResId = imageResId,
                        nearbyLocations = nearbyLocations,
                        onLocationClick = { locationName ->
                            // Find the clicked location in the repository
                            val location = LocationRepository.locations.find { it.title == locationName }
                            if (location != null) {
                                // Start a new MarkerDetailActivity for the clicked location
                                val intent = Intent(this, MarkerDetailActivity::class.java).apply {
                                    putExtra("title", location.title)
                                    putExtra("description", location.description)
                                    putExtra("image_res_id", location.imageResId)
                                    putStringArrayListExtra("nearbyLocations", ArrayList(location.nearbyLocations))
                                }
                                startActivity(intent)
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MarkerDetailScreen(
    title: String,
    description: String,
    imageResId: Int,
    nearbyLocations: List<String>,
    onLocationClick: (String) -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        // Title
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Description
        Text(
            text = description,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Image
        if (imageResId != 0) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Location Image",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        // Nearby Locations
        if (nearbyLocations.isNotEmpty()) {
            Text(
                text = "Znamenitosti u blizini:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Column {
                nearbyLocations.forEach { locationName ->
                    Text(
                        text = locationName,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .clickable { onLocationClick(locationName) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MarkerDetailPreview() {
    DjirTheme {
        MarkerDetailScreen(
            title = "LEGENDA PUB",
            description = "Legenda Pub slovi za prvi pub u Hrvatskoj...",
            imageResId = R.drawable.legenda,
            nearbyLocations = listOf("HNK", "Etnografski muzej", "AKC ATTACK!"),
            onLocationClick = { locationName ->
                // Simulate a click in the preview by logging or printing the location name
                println("Clicked on nearby location: $locationName")
            }
        )
    }
}
