package com.carevic.djir.data

import com.carevic.djir.R
import com.google.android.gms.maps.model.LatLng

data class Location(
    val title: String,
    val coordinates: LatLng,
    val description: String,
    val imageResId: Int
)

object LocationRepository {
    val locations = listOf(
        Location(
            title = "Ban Jelačić Square",
            coordinates = LatLng(45.8132, 15.978),
            description = "Ban Jelačić Square is the main square in Zagreb, Croatia, known for its historical significance.",
            imageResId = R.drawable.ban_jelacic
        ),
        Location(
            title = "Zagreb Cathedral",
            coordinates = LatLng(45.8136, 15.9784),
            description = "The Zagreb Cathedral is one of the tallest cathedrals in the world, a symbol of the city.",
            imageResId = R.drawable.katedrala
        ),
        Location(
            title = "Maksimir Park",
            coordinates = LatLng(45.8111, 16.0175),
            description = "Maksimir Park is a large public park in Zagreb, known for its natural beauty and wildlife.",
            imageResId = R.drawable.maksimir
        ),
        Location(
            title = "LEGENDA PUB",
            coordinates = LatLng(45.810293, 15.9645665),
            description = "Legenda Pub slovi za prvi pub u Hrvatskoj. Popularno je mjesto za okupljanje mladih zbog toga što se u blizini puba nalazi nekoliko škola i fakulteta, ali i zbog same ponude u pubu poput stola za biljar, pikada te široke ponude pivi, koktela i ostalih pića.",
            imageResId = R.drawable.legenda
        )
    )
}
