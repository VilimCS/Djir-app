package com.carevic.djir.data

import androidx.compose.ui.graphics.Color
import com.carevic.djir.R
import com.google.android.gms.maps.model.LatLng

data class Location(
    val title: String,
    val coordinates: LatLng,
    val description: String,
    val imageResId: Int,
    val nearbyLocations: List<String> = emptyList(),
    val color: String
)

object LocationRepository {
    val locations = listOf(
        Location(
            title = "Zagrebačka katedrala",
            coordinates = LatLng(45.8136, 15.9784),
            description = "Neogotička bazilika u Zagrebu, smještena na Kaptolu. Najveća je hrvatska sakralna građevina, duga 77 m, široka 48,2 m, visoka 108 m, a u njezinu unutrašnjost površine od 1617 m² može stati 5000 ljudi.",
            imageResId = R.drawable.katedrala,
            color = "black"
        ),
        Location(
            title = "LEGENDA PUB",
            coordinates = LatLng(45.810293, 15.9645665),
            description = "Legenda Pub slovi za prvi pub u Hrvatskoj. Popularno je mjesto za okupljanje mladih zbog toga što se u blizini puba nalazi nekoliko škola i fakulteta, ali i zbog same ponude u pubu poput stola za biljar, pikada te široke ponude pivi, koktela i ostalih pića.",
            imageResId = R.drawable.legenda,
            nearbyLocations = listOf("HNK", "AKC ATTACK!", "Etnografski muzej"),
            color = "yellow"
        ),
        Location(
            title = "HNK",
            coordinates = LatLng(45.8093999,15.9689585),
            description = "Hrvatsko narodno kazalište u Zagrebu najstarija je hrvatska kazališna ustanova u kojoj djeluju tri ansambla – operni, dramski i baletni. Zgrada HNK u Zagrebu građena je u neobaroknom stilu te s pravom nosi kolokvijalni naziv „hrama kulture“.",
            imageResId = R.drawable.hnk,
            color = "black"
        ),
        Location(
            title = "AKC ATTACK!",
            coordinates = LatLng(45.8064011,15.9618326),
            description = "Nalazi se u prostoru stare tvornice lijekova Medika (zbog toga poznat i kao AKC Medika). U prostoru kulturnog centra organiziraju se umjetnički festivali, alternativna koncertna događanja, filmske i kazališne produkcije te razni besplatni edukativni sadržaji. Također postoji i galerijski program kao i knjižnica. Dvorište centra obiluje grafitima i ostalim street artom.",
            imageResId = R.drawable.medika,
            color = "black"
        ),
        Location(
            title = "Etnografski muzej",
            coordinates = LatLng(45.8083565,15.9665386),
            description = "Etnografski muzej u Zgrebu najveći je muzej specijaliziran za etnologiju i kulturnu antropologiju u Hrvatskoj. Njegov fundus broji više od 85 000 predmeta iz svih dijelova Hrvatske, Europe i svijeta. Dio predmeta koji se nalaze u muzeju prikupili su poznati hrvatski istraživači poput Dragutina Lermana i braće Seljan.",
            imageResId = R.drawable.etnografski,
            color = "black"
        ),
        Location(
            title = "Sheridan's Irish pub",
            coordinates = LatLng(45.8012955,15.9606807),
            description = "Nudi bogati izbor piva, live irsku glazbu četvrtkom i pub kviz srijedom",
            imageResId = R.drawable.sheridans,
            nearbyLocations = listOf("Tehnički muzej Nikola Tesla"),
            color = "yellow"
        ),
        Location(
            title = "Tehnički muzej Nikola Tesla",
            coordinates = LatLng(45.8041803,15.9614131),
            description = "Mjesto koje nadmašuje običan muzejski doživljaj – to je prostor u kojem možete doživjeti inspiraciju, razumjeti povijest tehnologije i dublje se povezati s naslijeđem jednog od najvažnijih izumitelja svih vremena.",
            imageResId = R.drawable.tehnicki,
            color = "black"
        ),
        Location(
            title = "Krivi put",
            coordinates = LatLng(45.8047967,15.9629741),
            description = "Jedno od omiljenih okupljališta za mlade,  s velikim dvorištem koje je idealno za druženje uz pristupačne cijene.",
            imageResId = R.drawable.kriviput,
            nearbyLocations = listOf("Galerija SC","Teatar &TD"),
            color = "yellow"
        ),
        Location(
            title = "Galerija SC",
            coordinates = LatLng(45.8037505,15.9641715),
            description = "Galerija je poznata je po izložbama suvremene umjetnosti, pružajući platformu mladim umjetnicima i eksperimentalnim projektima.",
            imageResId = R.drawable.scgalerija,
            color = "black"
        ),
        Location(
            title = "Teatar &TD",
            coordinates = LatLng(45.8032583,15.9649813),
            description = "Nudi jedinstvenu kazališnu scenu. Ovo je mjesto gdje umjetnost razbija granice, a atmosfera je uvijek opuštena i inkluzivna.",
            imageResId = R.drawable.tdteatar,
            color = "black"
        ),
        Location(
            title = "Harat's pub",
            coordinates = LatLng(45.8148286,15.97511),
            description = "Nudi bogati izbor piva, live irsku glazbu četvrtkom i pub kviz srijedom",
            imageResId = R.drawable.harats,
            nearbyLocations = listOf("Zagrebačka katedrala","Muzej prekinutih veza","Galerija Klovićevi dvori"),
            color = "yellow"
        ),
        Location(
            title = "Muzej prekinutih veza",
            coordinates = LatLng(45.8150119,15.9710301),
            description = "Muzej posvećen prekinutim vezama, bilo ljubavnim, obiteljskim ili prijateljskim. U njemu su izloženi osobni predmeti koji simboliziraju prekinute veze, i popraćeni su kratkim opisima.",
            imageResId = R.drawable.prekinuteveze,
            color = "black"
        ),
        Location(
            title = "Galerija Klovićevi dvori",
            coordinates = LatLng(45.8150881,15.9720439),
            description = "Muzejska ustanova (umjetnički muzej) s državnim djelokrugom. Galerija je tematski vezana uz područje likovnih umjetnosti. Primarna djelatnost Galerije je organiziranje i promidžba velikih kulturoloških izložbi te tiskanje kataloga i ostalih promidžbenih materijala tematski vezanih uz sadržaj izložbi.",
            imageResId = R.drawable.klovicevi,
            color = "black"
        ),
        Location(
            title = "The Beertija",
            coordinates = LatLng(45.8073943,15.9788498),
            description = "The Beertija je popularni pub smješten u središtu Zagreba. Poznata je po širokoj ponudi craft piva i ugodnoj atmosferi koja privlači ljubitelje piva i one koji žele uživati u laganim obrocima i grickalicama. Pub nudi udoban interijer i vanjski prostor za sjedenje, a često organizira tematske večeri i degustacije piva.",
            imageResId = R.drawable.beertija,
            nearbyLocations = listOf("Umjetnički paviljon","Kip kralja Tomislava"),
            color = "yellow"
        ),
        Location(
            title = "Umjetnički paviljon",
            coordinates = LatLng(45.8071296,15.9760444),
            description = "Impresivna galerija koja se ističe prekrasnom secesijskom arhitekturom i bogatom poviješću. Ovaj povijesni izložbeni prostor idealno je mjesto za ljubitelje umjetnosti i kulture.",
            imageResId = R.drawable.umjetnicki,
            color = "black"
        ),
        Location(
            title = "Kip kralja Tomislava",
            coordinates = LatLng(45.805674,15.9761201),
            description = "Smješten u središtu parka na trgu, spomenik prvom hrvatskom kralju Tomislavu predstavlja povijesnu znamenitost, a trg je često domaćin kulturnih manifestacija i izložbi na otvorenom.",
            imageResId = R.drawable.tomislav,
            color = "black"
        )
    )
}
