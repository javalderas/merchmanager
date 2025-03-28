package com.reinodehades.merchmanager.application.reports

import com.reinodehades.merchmanager.domain.model.ProductStockReport
import com.reinodehades.merchmanager.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ReportService(private val productRepository: ProductRepository) {

    fun generateReport(): List<ProductStockReport> {
        val products = productRepository.findAll()
        return products.map {
            ProductStockReport(
                name = it.name,
                category = it.category,
                stock = it.stock,
                price = it.price
            )
        }
    }

    fun generateCsvReport(): String {
        val header = "Product Name,Category,Stock,Price"
        val rows = generateReport().map {
            "${it.name},${it.category},${it.stock},${it.price}"
        }
        return listOf(header, *rows.toTypedArray()).joinToString("\n")
    }
}