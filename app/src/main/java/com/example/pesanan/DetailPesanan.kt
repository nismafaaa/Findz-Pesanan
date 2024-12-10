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
fun DetailPesanan(navController: NavHostController) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) { // Navigate back to the previous page
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
                            text = "Detail Pesanan",
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
                    .background(Color(0xFFE0E0E0), RoundedCornerShape(12.dp))
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
                    .background(Color(0xFFE0E0E0), RoundedCornerShape(12.dp))
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
                    .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "2 postingan video IG",
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black
                )
            }

            // Engagement Media Sosial
            Text(
                text = "Engagement media sosial",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
                    .padding(16.dp)
            ) {
                Column {
                    listOf(
                        "Follower IG" to "+50",
                        "Viewers postingan IG" to "+1000",
                        "Share postingan IG" to "+40",
                        "Save postingan IG" to "+25",
                        "Follower Tiktok" to "+70",
                        "Viewers postingan Tiktok" to "+500",
                        "Share postingan Tiktok" to "+30",
                        "Save postingan Tiktok" to "+5"
                    ).forEach { (label, value) ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = label,
                                fontSize = 14.sp,
                                fontFamily = FontFamily.SansSerif,
                                color = Color.Black
                            )
                            Text(
                                text = value,
                                fontSize = 14.sp,
                                fontFamily = FontFamily.SansSerif,
                                color = Color.Black
                            )
                        }
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
                    .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Add an icon if required (for BCA logo)
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

            // Submit Button
            Button(
                onClick = { /* Handle submit action */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5B6DFF)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Submit laporan",
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White
                )
            }
        }
    }
}
