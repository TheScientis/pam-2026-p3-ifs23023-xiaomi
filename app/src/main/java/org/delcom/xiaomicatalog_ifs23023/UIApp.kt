package org.delcom.xiaomicatalog_ifs23023.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.delcom.xiaomicatalog_ifs23023.R
import org.delcom.xiaomicatalog_ifs23023.data.ProductCategory
import org.delcom.xiaomicatalog_ifs23023.helper.BottomNavItem
import org.delcom.xiaomicatalog_ifs23023.helper.Screen
import org.delcom.xiaomicatalog_ifs23023.ui.components.BottomNavComponent
import org.delcom.xiaomicatalog_ifs23023.ui.components.TopAppBarComponent
import org.delcom.xiaomicatalog_ifs23023.ui.screens.*

@Composable
fun UIApp() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomNavItems = listOf(
        BottomNavItem(
            title = "Home",
            route = Screen.Home.route,
            selectedIcon = R.drawable.ic_home,
            unselectedIcon = R.drawable.ic_home
        ),
        BottomNavItem(
            title = "Galaxy",
            route = Screen.Galaxy.route,
            selectedIcon = R.drawable.ic_movies,
            unselectedIcon = R.drawable.ic_movies
        ),
        BottomNavItem(
            title = "Solar System",
            route = Screen.SolarSystem.route,
            selectedIcon = R.drawable.ic_earth,
            unselectedIcon = R.drawable.ic_earth
        )
    )

    // Show bottom navigation only on main screens
    val showBottomNav = when (currentRoute) {
        Screen.Home.route, Screen.Galaxy.route, Screen.SolarSystem.route -> true
        else -> false
    }

    // Show top app bar on detail screen
    val showTopBar = currentRoute?.startsWith("detail") == true

    Scaffold(
        bottomBar = {
            if (showBottomNav) {
                BottomNavComponent(
                    navController = navController,
                    items = bottomNavItems
                )
            }
        },
        topBar = {
            if (showTopBar) {
                TopAppBarComponent(
                    title = "Product Details",
                    onBackClick = { navController.navigateUp() }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navController = navController,
                    onCategoryClick = { category ->
                        navController.navigate("productList/${category.name}/${category.name}")
                    }
                )
            }
            composable(Screen.Galaxy.route) {
                GalaxyScreen(
                    onMovieClick = { movieId ->
                        navController.navigate(Screen.Detail.passId(movieId))
                    }
                )
            }
            composable(Screen.SolarSystem.route) {
                SolarSystemScreen(
                    onMovieClick = { movieId ->
                        navController.navigate(Screen.Detail.passId(movieId))
                    }
                )
            }
            composable(
                route = "productList/{category}/{categoryName}",
                arguments = listOf(
                    navArgument("category") { type = NavType.StringType },
                    navArgument("categoryName") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val categoryStr = backStackEntry.arguments?.getString("category") ?: ""
                val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
                val category = try {
                    ProductCategory.valueOf(categoryStr)
                } catch (e: Exception) {
                    ProductCategory.SMARTPHONE
                }
                ProductListScreen(
                    navController = navController,
                    category = category,
                    categoryName = categoryName
                )
            }
            composable(Screen.Detail.route) { backStackEntry ->
                val movieId = backStackEntry.arguments?.getString("movieId") ?: ""
                DetailScreen(
                    productId = movieId,
                    onBackClick = { navController.navigateUp() },
                    navController = navController
                )
            }
        }
    }
}
