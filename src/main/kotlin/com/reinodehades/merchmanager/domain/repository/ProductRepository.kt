package com.reinodehades.merchmanager.domain.repository

import com.reinodehades.merchmanager.domain.model.Product
import org.springframework.data.jpa.repository.JpaRepository


interface ProductRepository : JpaRepository<Product, Long>
