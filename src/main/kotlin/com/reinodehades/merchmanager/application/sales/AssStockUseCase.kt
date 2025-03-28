package com.reinodehades.merchmanager.application.sales

import arrow.core.Either
import arrow.core.raise.either
import com.reinodehades.merchmanager.domain.model.MovementType
import com.reinodehades.merchmanager.domain.model.StockMovement
import com.reinodehades.merchmanager.domain.repository.ProductRepository
import com.reinodehades.merchmanager.domain.repository.StockMovementRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class AddStockUseCase(
    private val productRepo: ProductRepository,
    private val movementRepo: StockMovementRepository
) {
    fun execute(productId: Long, quantity: Int): Either<String, Unit> = either {
        val product = productRepo.findById(productId).orElse(null)
            ?: raise("Product not found")

        product.addStock(quantity)
        productRepo.save(product)

        movementRepo.save(
            StockMovement(
                productId = product.id,
                type = MovementType.IN,
                quantity = quantity,
                timestamp = LocalDateTime.now()
            )
        )
    }
}