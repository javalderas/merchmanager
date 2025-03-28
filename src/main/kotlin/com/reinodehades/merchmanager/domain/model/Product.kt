package com.reinodehades.merchmanager.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
    val category: String,
    val price: Double,
    val cost: Double,
    var stock: Int
) {
    open fun removeStock(quantity: Int) {
        require(quantity > 0) { "Quantity must be positive" }
        require(stock >= quantity) { "Not enough stock" }
        stock -= quantity
    }

    open fun addStock(quantity: Int) {
        require(quantity > 0) { "Quantity must be positive" }
        stock += quantity
    }
}