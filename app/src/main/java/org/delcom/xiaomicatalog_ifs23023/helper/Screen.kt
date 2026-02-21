package org.delcom.xiaomicatalog_ifs23023.helper

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Galaxy : Screen("galaxy")
    object SolarSystem : Screen("solar_system")
    object Smartphones : Screen("smartphones")
    object SmartHome : Screen("smart_home")
    object Wearables : Screen("wearables")
    object Laptops : Screen("laptops")
    object Accessories : Screen("accessories")
    object Detail : Screen("detail/{movieId}") {
        fun passId(movieId: String): String = "detail/$movieId"
    }
}

data class BottomNavItem(
    val title: String,
    val route: String,
    val selectedIcon: Int,
    val unselectedIcon: Int
)
