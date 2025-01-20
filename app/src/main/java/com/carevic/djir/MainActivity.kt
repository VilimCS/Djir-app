package com.carevic.djir

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carevic.djir.ui.theme.DjirTheme
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.MarkerState
import com.google.android.gms.maps.model.CameraPosition
import androidx.compose.ui.platform.LocalContext
import com.carevic.djir.data.Location
import com.carevic.djir.data.LocationRepository
import com.google.android.gms.maps.model.BitmapDescriptorFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DjirTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    GoogleMapScreen()
                }
            }
        }
    }
}

@Composable
fun GoogleMapScreen() {
    val context = LocalContext.current
    val zagrebCoordinates = LocationRepository.locations

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(zagrebCoordinates[0].coordinates, 12f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        // Add markers for each location
        zagrebCoordinates.forEach { location ->
            val markerColor = when (location.color) {
                "yellow" -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                "black" -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
                else -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED) // Default color
            }

            Marker(
                state = MarkerState(position = location.coordinates),
                title = location.title,
                icon = markerColor,
                onClick = {
                    // Create an intent and pass the data to MarkerDetailActivity
                    val intent = Intent(context, MarkerDetailActivity::class.java).apply {
                        putExtra("title", location.title)
                        putExtra("description", location.description)
                        putExtra("image_res_id", location.imageResId)
                        putStringArrayListExtra(
                            "nearbyLocations",
                            ArrayList(location.nearbyLocations)
                        )
                    }
                    context.startActivity(intent)
                    true // Return true to indicate the marker click has been handled
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DjirTheme {
        GoogleMapScreen()
    }
}