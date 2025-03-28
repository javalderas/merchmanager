package com.reinodehades.merchmanager.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class StockMovement(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val productId: Long,
    val type: MovementType, // IN or OUT
    val quantity: Int,
    val timestamp: LocalDateTime = LocalDateTime.now()
)

enum class MovementType {
    IN, OUT
}