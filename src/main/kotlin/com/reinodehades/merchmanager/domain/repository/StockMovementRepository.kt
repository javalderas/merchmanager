package com.reinodehades.merchmanager.domain.repository

import com.reinodehades.merchmanager.domain.model.StockMovement
import org.springframework.data.jpa.repository.JpaRepository

interface StockMovementRepository : JpaRepository<StockMovement, Long> {
    fun findByProductId(productId: Long): List<StockMovement>
}