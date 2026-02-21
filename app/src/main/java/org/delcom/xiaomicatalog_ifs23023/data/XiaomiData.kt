package org.delcom.xiaomicatalog_ifs23023.data

data class XiaomiProduct(
    val id: Int,
    val name: String,
    val category: ProductCategory,
    val price: String,
    val description: String,
    val specifications: Map<String, String>,
    val imageRes: Int,
    val color: String,
    val rating: Float,
    val releaseDate: String,
    val isAvailable: Boolean
)

enum class ProductCategory {
    SMARTPHONE,
    SMART_HOME,
    WEARABLE,
    LAPTOP,
    ACCESSORIES
}

data class CategoryInfo(
    val category: ProductCategory,
    val name: String,
    val icon: Int,
    val color: Long
)

// Data object untuk menyimpan dummy data
object XiaomiData {
    val categories = listOf(
        CategoryInfo(ProductCategory.SMARTPHONE, "Smartphones", 0, 0xFFF44336L),
        CategoryInfo(ProductCategory.SMART_HOME, "Smart Home", 0, 0xFF2196F3L),
        CategoryInfo(ProductCategory.WEARABLE, "Wearables", 0, 0xFF4CAF50L),
        CategoryInfo(ProductCategory.LAPTOP, "Laptops", 0, 0xFFFF9800L),
        CategoryInfo(ProductCategory.ACCESSORIES, "Accessories", 0, 0xFF9C27B0L)
    )

    val products = listOf(
        // Smartphones
        XiaomiProduct(
            id = 1,
            name = "Xiaomi 14 Ultra",
            category = ProductCategory.SMARTPHONE,
            price = "Rp 15.999.000",
            description = "Flagship smartphone with Leica professional optics and cutting-edge AI capabilities. Features a 50MP quad-camera system and Snapdragon 8 Gen 3 processor.",
            specifications = mapOf(
                "Processor" to "Snapdragon 8 Gen 3",
                "RAM" to "16GB LPDDR5X",
                "Storage" to "512GB UFS 4.0",
                "Display" to "6.73\" AMOLED 120Hz",
                "Camera" to "50MP Quad Camera",
                "Battery" to "5000mAh"
            ),
            imageRes = 0,
            color = "Black",
            rating = 4.8f,
            releaseDate = "2024",
            isAvailable = true
        ),
        XiaomiProduct(
            id = 2,
            name = "Redmi Note 13 Pro+",
            category = ProductCategory.SMARTPHONE,
            price = "Rp 5.999.000",
            description = "Mid-range powerhouse with 200MP main camera and curved AMOLED display. Perfect for photography enthusiasts.",
            specifications = mapOf(
                "Processor" to "MediaTek Dimensity 7200-Ultra",
                "RAM" to "12GB",
                "Storage" to "256GB",
                "Display" to "6.67\" AMOLED 120Hz",
                "Camera" to "200MP Triple Camera",
                "Battery" to "5000mAh"
            ),
            imageRes = 0,
            color = "Aurora Purple",
            rating = 4.6f,
            releaseDate = "2024",
            isAvailable = true
        ),

        // Smart Home
        XiaomiProduct(
            id = 3,
            name = "Xiaomi Smart Air Purifier 4",
            category = ProductCategory.SMART_HOME,
            price = "Rp 1.899.000",
            description = "Advanced air purifier with real-time air quality monitoring and smart home integration.",
            specifications = mapOf(
                "Coverage" to "48 m²",
                "CADR" to "400 m³/h",
                "Filter" to "True HEPA H13",
                "Noise Level" to "32-64 dB",
                "Power" to "38W",
                "Connectivity" to "Wi-Fi + Bluetooth"
            ),
            imageRes = 0,
            color = "White",
            rating = 4.7f,
            releaseDate = "2023",
            isAvailable = true
        ),

        // Wearables
        XiaomiProduct(
            id = 4,
            name = "Xiaomi Watch S3",
            category = ProductCategory.WEARABLE,
            price = "Rp 1.599.000",
            description = "Elegant smartwatch with interchangeable bezels and comprehensive health tracking features.",
            specifications = mapOf(
                "Display" to "1.43\" AMOLED",
                "Battery" to "486mAh",
                "Water Resistance" to "5ATM",
                "Sensors" to "Heart rate, SpO2, GPS",
                "Connectivity" to "Bluetooth 5.2",
                "OS" to "Xiaomi HyperOS"
            ),
            imageRes = 0,
            color = "Silver",
            rating = 4.5f,
            releaseDate = "2024",
            isAvailable = true
        ),

        // Laptops
        XiaomiProduct(
            id = 5,
            name = "Xiaomi Book S 12.4\"",
            category = ProductCategory.LAPTOP,
            price = "Rp 7.999.000",
            description = "Versatile 2-in-1 laptop with detachable keyboard, perfect for productivity and entertainment.",
            specifications = mapOf(
                "Processor" to "Snapdragon 8cx Gen 2",
                "RAM" to "8GB",
                "Storage" to "256GB",
                "Display" to "12.4\" 2.5K IPS",
                "Battery" to "38.08Wh",
                "Weight" to "720g"
            ),
            imageRes = 0,
            color = "Dark Gray",
            rating = 4.4f,
            releaseDate = "2023",
            isAvailable = true
        ),

        // Accessories
        XiaomiProduct(
            id = 6,
            name = "Xiaomi Electric Scooter 4 Pro",
            category = ProductCategory.ACCESSORIES,
            price = "Rp 6.499.000",
            description = "High-performance electric scooter with long-range battery and dual braking system.",
            specifications = mapOf(
                "Max Speed" to "25 km/h",
                "Range" to "45 km",
                "Motor" to "350W",
                "Battery" to "12.8Ah",
                "Weight" to "16.5kg",
                "Tires" to "10\" Pneumatic"
            ),
            imageRes = 0,
            color = "Black",
            rating = 4.6f,
            releaseDate = "2023",
            isAvailable = true
        )
    )
}