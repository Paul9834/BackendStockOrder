package com.paul9834.order.demo.resource

import com.paul9834.order.demo.model.Invoice
import com.paul9834.order.demo.model.Item
import com.paul9834.order.demo.service.ParentService
import com.paul9834.order.demo.service.StockService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal


@RestController
@RequestMapping("/v1/api/stock")
class StockResource (private val productService: StockService) {

    @GetMapping
    fun getStock(): List<Item> = productService.getProducts()

    @PostMapping
    fun addProduct(@RequestBody order: List<Item>): ResponseEntity<List<Item>> =
            productService.addProduct(order)

}

@RestController
@RequestMapping("/v1/api/order")
class OrderResource (private val parentService: ParentService) {

    @GetMapping
    fun getStock(): List<Invoice> = parentService.getProducts()

    @PostMapping
    fun addOrder(@RequestBody invoice: Invoice): ResponseEntity<Invoice> {
        /*   val resultado:Int? = invoice.calculateTotalOrder()
        invoice.order_total = invoice.calculateTotalOrder()*/


        return parentService.addOrder(invoice)


    }


   /* @PostMapping
    fun addProduct(@RequestBody parent: Parent): ResponseEntity<Parent> =
            parentService.
*/


}