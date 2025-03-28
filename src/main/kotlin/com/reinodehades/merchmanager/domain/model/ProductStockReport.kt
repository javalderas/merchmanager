package com.reinodehades.merchmanager.domain.model

data class ProductStockReport(
    val name: String,
    val category: String,
    val stock: Int,
    val price: Double
)