package org.delcom.xiaomicatalog_ifs23023.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.delcom.xiaomicatalog_ifs23023.data.ProductCategory
import org.delcom.xiaomicatalog_ifs23023.data.XiaomiData
import org.delcom.xiaomicatalog_ifs23023.helper.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    onMovieClick: (Int) -> Unit = {}, // Keep this for now or remove if not needed
    onCategoryClick: (ProductCategory) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Xiaomi Catalog",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "Discover Amazing Products",
                            fontSize = 14.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFF6B6B)
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Banner Section
            item {
                BannerSection()
            }

            // Categories Section
            item {
                Text(
                    text = "Categories",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            item {
                CategoriesGrid(
                    onCategoryClick = onCategoryClick
                )
            }

            // Featured Products
            item {
                Text(
                    text = "Featured Products",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
            }

            items(XiaomiData.products.take(4)) { product ->
                FeaturedProductCard(
                    product = product,
                    onClick = {
                        navController.navigate(Screen.Detail.passId(product.id.toString()))
                    }
                )
            }
        }
    }
}

@Composable
fun BannerSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFF6B6B)
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Gradient overlay
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            listOf(
                                Color(0xFFFF6B6B),
                                Color(0xFFFF8E8E)
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Summer Sale!",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Up to 40% off on selected items",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.9f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /* TODO */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFFFF6B6B)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Shop Now")
                }
            }
        }
    }
}

@Composable
fun CategoriesGrid(
    onCategoryClick: (ProductCategory) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CategoryCard(
                name = "Smartphones",
                color = Color(0xFFF44336),
                onClick = { onCategoryClick(ProductCategory.SMARTPHONE) },
                modifier = Modifier.weight(1f)
            )
            CategoryCard(
                name = "Smart Home",
                color = Color(0xFF2196F3),
                onClick = { onCategoryClick(ProductCategory.SMART_HOME) },
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CategoryCard(
                name = "Wearables",
                color = Color(0xFF4CAF50),
                onClick = { onCategoryClick(ProductCategory.WEARABLE) },
                modifier = Modifier.weight(1f)
            )
            CategoryCard(
                name = "Laptops",
                color = Color(0xFFFF9800),
                onClick = { onCategoryClick(ProductCategory.LAPTOP) },
                modifier = Modifier.weight(1f)
            )
        }
        CategoryCard(
            name = "Accessories",
            color = Color(0xFF9C27B0),
            onClick = { onCategoryClick(ProductCategory.ACCESSORIES) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun CategoryCard(
    name: String,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier.height(100.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = color
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun FeaturedProductCard(
    product: org.delcom.xiaomicatalog_ifs23023.data.XiaomiProduct,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray.copy(alpha = 0.3f))
            ) {
                // Placeholder for product image
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = product.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = product.price,
                    fontSize = 14.sp,
                    color = Color(0xFFFF6B6B),
                    fontWeight = FontWeight.Bold
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(5) { index ->
                        Text(
                            text = if (index < product.rating.toInt()) "⭐" else "☆",
                            fontSize = 16.sp
                        )
                    }
                    Text(
                        text = " (${product.rating})",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}
