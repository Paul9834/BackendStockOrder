package com.paul9834.order.demo.resource

import com.paul9834.order.demo.model.Product
import com.paul9834.order.demo.service.StockService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1/api/stock")
class StockResource (private val productService: StockService) {

    @GetMapping
    fun getStock(): List<Product> = productService.getProducts()

    @PostMapping
    fun addProduct(@RequestBody product: Product): ResponseEntity<Product> =
            productService.addProduct(product)



}