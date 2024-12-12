package com.example.pesanan

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.Dp

@Composable
fun Permintaan(
    navController: NavHostController,
    viewModel: PermintaanViewModel = viewModel()
) {
    val tabTitles = listOf("Permintaan", "Pesanan")
    val selectedTabIndex = remember { mutableStateOf(0) }

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
        },
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color.White,
                elevation = 8.dp,
                contentColor = Color(0xFFA3A7AB) // Set the default icon color
            ) {
                BottomNavigationItem(
                    selected = false,
                    onClick = { /* Navigate to Beranda */ },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = "Beranda"
                        )
                    },
                    label = {
                        Text("Beranda")
                    },
                    selectedContentColor = Color(0xFF625AFE),
                    unselectedContentColor = Color(0xFFA3A7AB)
                )
                BottomNavigationItem(
                    selected = true,
                    onClick = { /* Navigate to Pesanan */ },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.List,
                            contentDescription = "Pesanan",
                            tint = Color(0xFF625AFE)
                        )
                    },
                    label = {
                        Text("Pesanan")
                    },
                    selectedContentColor = Color(0xFF625AFE),
                    unselectedContentColor = Color(0xFFA3A7AB)
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { /* Navigate to Profil */ },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Profil"
                        )
                    },
                    label = {
                        Text("Profil")
                    },
                    selectedContentColor = Color(0xFF625AFE), // Set the selected icon color
                    unselectedContentColor = Color(0xFFA3A7AB) // Set the unselected icon color
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            when (selectedTabIndex.value) {
                0 -> PermintaanTabContent(
                    navController = navController,
                    viewModel = viewModel
                )
                1 -> PesananTabContent {
                    navController.navigate("detailPesanan/Pesanan")
                }
            }
        }
    }
}

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    elevation: Dp = 0.dp,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        modifier = modifier,
        color = backgroundColor,
        shadowElevation = elevation,
        contentColor = contentColor
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            content = content
        )
    }
}

@Composable
fun BottomNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    label: @Composable () -> Unit,
    selectedContentColor: Color,
    unselectedContentColor: Color
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(1f / 3f)
            .clickable { onClick() },
        color = if (selected) selectedContentColor.copy(alpha = 0.12f) else Color.Transparent
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.size(24.dp),
                contentAlignment = Alignment.Center
            ) {
                icon()
            }
            Spacer(modifier = Modifier.height(4.dp))
            label()
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
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.Center)
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
fun PermintaanTabContent(
    navController: NavHostController,
    viewModel: PermintaanViewModel
) {
    val permintaanStatus by viewModel.permintaanStatus

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
                .clickable {
                    navController.navigate("detailPermintaan")
                }
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = "Refresh Icon",
                        tint = Color(0xFF060EBB), // Updated color
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
                            text = permintaanStatus, // Dynamic status from ViewModel
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp)) // Add spacing before button

                TextButton(
                    onClick = {
                        navController.navigate("detailPermintaan")
                    },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "Lihat detail",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black // Updated to black
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Detail Arrow",
                        tint = Color.Black, // Updated to black
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
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = "Refresh Icon",
                        tint = Color(0xFF060EBB), // Updated color
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
                }

                Spacer(modifier = Modifier.height(8.dp)) // Add spacing before the button

                TextButton(
                    onClick = { onDetailClick() }, // Navigate on click
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "Lihat detail",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black // Updated to black
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Detail Arrow",
                        tint = Color.Black, // Updated to black
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}