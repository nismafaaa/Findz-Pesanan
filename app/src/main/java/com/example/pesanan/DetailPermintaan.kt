package com.example.pesanan

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPermintaan(
    navController: NavHostController,
    viewModel: PermintaanViewModel
) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        // Use popBackStack() to return to the previous screen/state
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Detail Permintaan",
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            // Nama Influencer
            Text(
                text = "Nama Influencer",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .background(Color(0xFFE0E0E0), RoundedCornerShape(16.dp))
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "Nanda Arsyita",
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black
                )
            }

            // Nama Pemesan
            Text(
                text = "Nama Pemesan",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .background(Color(0xFFE0E0E0), RoundedCornerShape(16.dp))
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "Dhea Ayu",
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black
                )
            }

            // Jenis Pemesanan
            Text(
                text = "Jenis Pemesanan",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(16.dp))
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "2 postingan video IG",
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black
                )
            }

            // Jumlah yang Dibayarkan
            Text(
                text = "Jumlah yang dibayarkan",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Biaya influencer", fontSize = 14.sp, color = Color.Black)
                        Text("Rp.18.000.000,00", fontSize = 14.sp, color = Color.Black)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Administrasi 5%", fontSize = 14.sp, color = Color.Black)
                        Text("Rp.900.000,00", fontSize = 14.sp, color = Color.Black)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Cashback 5%", fontSize = 14.sp, color = Color.Black)
                        Text("- Rp.900.000,00", fontSize = 14.sp, color = Color.Black)
                    }
                    Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Total", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
                        Text("Rp.18.000.000,00", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
                    }
                }
            }

            // Metode Pembayaran
            Text(
                text = "Metode Pembayaran",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(16.dp))
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(Color.Blue, CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "BCA (Virtual Account)",
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Accept Button
            Button(
                onClick = {
                    viewModel.updatePermintaanStatus("Permintaan diterima")
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5B6DFF)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Terima", fontSize = 16.sp, color = Color.White)
            }

            // Reject Button
            Button(
                onClick = {
                    viewModel.updatePermintaanStatus("Permintaan ditolak")
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7043)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Tolak", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}