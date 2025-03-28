package com.reinodehades.merchmanager.infrastructure.inbound.sales


import com.reinodehades.merchmanager.application.sales.AddStockUseCase
import com.reinodehades.merchmanager.application.sales.SellProductUseCase
import com.reinodehades.merchmanager.domain.repository.ProductRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/inventory")
class InventoryController(
    private val productRepo: ProductRepository,
    private val sellProduct: SellProductUseCase,
    private val addStock: AddStockUseCase
) {

    @GetMapping("/available")
    fun available() = productRepo.findAll().filter { it.stock > 0 }

    @PostMapping("/{id}/sell")
    fun sell(@PathVariable id: Long, @RequestParam qty: Int) =
        sellProduct.execute(id, qty)

    @PostMapping("/{id}/add")
    fun add(@PathVariable id: Long, @RequestParam qty: Int) =
        addStock.execute(id, qty)
}