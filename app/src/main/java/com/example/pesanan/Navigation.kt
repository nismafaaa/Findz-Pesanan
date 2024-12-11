package com.example.pesanan

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val viewModel: PermintaanViewModel = viewModel() // Shared ViewModel instance

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") {
            Permintaan(navController, viewModel)
        }
        composable("detailPesanan/{selectedTab}") { backStackEntry ->
            val selectedTab = backStackEntry.arguments?.getString("selectedTab") ?: "Pesanan"
            DetailPesanan(navController, selectedTab)
        }
        composable("detailPermintaan") {
            DetailPermintaan(navController, viewModel)
        }
    }
}
