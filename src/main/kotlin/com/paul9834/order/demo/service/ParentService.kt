package com.paul9834.order.demo.service

import com.paul9834.order.demo.model.Invoice
import com.paul9834.order.demo.repository.ParentRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class ParentService (private val parentRepository: ParentRepository){

    fun getProducts(): List<Invoice> = parentRepository.findAll()

    fun addOrder(invoice: Invoice): ResponseEntity<Invoice> =
            ResponseEntity.ok(parentRepository.save(invoice))



}