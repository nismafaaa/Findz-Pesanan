package com.example.pesanan

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Permintaan(navController: NavHostController) {
    val tabTitles = listOf("Permintaan", "Pesanan")
    val selectedTabIndex = remember { androidx.compose.runtime.mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenteredTopAppBar(
                title = "Pesanan",
                selectedTabIndex = selectedTabIndex.value,
                onTabSelected = { index ->
                    selectedTabIndex.value = index
                },
                tabTitles = tabTitles
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            when (selectedTabIndex.value) {
                0 -> PermintaanTabContent {
                    navController.navigate("detail") // Navigate to Detail Pesanan page
                }
                1 -> PesananTabContent {
                    navController.navigate("detail") // Navigate to Detail Pesanan page
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenteredTopAppBar(
    title: String,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    tabTitles: List<String>
) {
    Column {
        // Top App Bar
        SmallTopAppBar(
            title = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif // Apply sans-serif font
                        ),
                        color = Color.Black
                    )
                }
            },
            navigationIcon = {
                IconButton(onClick = { /* Handle back action */ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.White
            )
        )

        // Tabs below the top app bar
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White,
            contentColor = MaterialTheme.colorScheme.primary,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { onTabSelected(index) },
                    text = {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontFamily = FontFamily.SansSerif,
                                color = if (selectedTabIndex == index) MaterialTheme.colorScheme.primary else Color.Gray
                            )
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        val items = listOf("Beranda", "Pesanan", "Profil")
        val icons = listOf(Icons.Default.Home, Icons.Default.List, Icons.Default.Person)
        val selectedIndex = remember { mutableStateOf(1) }

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIndex.value == index,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(item)
                },
                icon = {
                    Icon(imageVector = icons[index], contentDescription = item)
                },
                label = { Text(item) }
            )
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Pesanan") {
        composable("Beranda") { PlaceholderScreen("Beranda") }
        composable("Pesanan") { PesananScreen() }
        composable("Profil") { PlaceholderScreen("Profil") }
    }
}

@Composable
fun PesananScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Permintaan",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Client: Dhea Ayu",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Permintaan sedang di proses",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                ClickableText(
                    text = AnnotatedString("Lihat detail"),
                    onClick = { /* Handle click action */ },
                    modifier = Modifier.align(Alignment.End),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
    }
}

@Composable
fun PlaceholderScreen(name: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Page: $name")
    }
}

@Composable
fun PermintaanTabContent(onDetailClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8)),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onDetailClick() } // Navigate on click
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "Refresh Icon",
                    tint = Color(0xFF5B6DFF),
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 16.dp)
                )

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Client: Dhea Ayu",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black
                    )
                    Text(
                        text = "Permintaan sedang di proses",
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Gray
                    )
                }

                TextButton(
                    onClick = { onDetailClick() }, // Navigate on click
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "Lihat detail",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(0xFF5B6DFF)
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Detail Arrow",
                        tint = Color(0xFF5B6DFF),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun PesananTabContent(onDetailClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8)),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onDetailClick() } // Navigate on click
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "Refresh Icon",
                    tint = Color(0xFF5B6DFF),
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 16.dp)
                )

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Client: Dhea Ayu",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black
                    )
                    Text(
                        text = "Perbarui laporan pengiklanan",
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Gray
                    )
                }

                TextButton(
                    onClick = { onDetailClick() }, // Navigate on click
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "Lihat detail",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(0xFF5B6DFF)
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Detail Arrow",
                        tint = Color(0xFF5B6DFF),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}