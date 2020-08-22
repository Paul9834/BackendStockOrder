package com.paul9834.order.demo.service

import com.paul9834.order.demo.model.Item
import com.paul9834.order.demo.repository.StockRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class StockService(private val repo: StockRepository) {

    // Obtiene la lista de todos los productos //

    fun getProducts(): List<Item> = repo.findAll()

    // Agrega un producto //
    fun addProduct(order: List<Item>): ResponseEntity<List<Item>> =
            ResponseEntity.ok(repo.saveAll(order))


    // Obtiene un producto por id
    // el método 'map' se utiliza para asignar cada elemento a su resultado correspondiente
    // Si desea cambiar un elemento de su lista, debe recopilar los resultados
    // en una nueva lista. utilizando el método .collect().

    fun getProductById(id: Long): ResponseEntity<Item> =
            repo.findById(id).map { product ->
                ResponseEntity.ok(product)
            }.orElse(ResponseEntity.notFound().build())

    fun deleteProduct(productId: Long): ResponseEntity<Void> =

            repo.findById(productId).map { product ->
                repo.delete(product)
                ResponseEntity<Void>(HttpStatus.ACCEPTED)
            }.orElse(ResponseEntity.notFound().build())


}