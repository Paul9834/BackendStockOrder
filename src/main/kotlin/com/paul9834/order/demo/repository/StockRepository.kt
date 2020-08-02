package com.paul9834.order.demo.repository


import com.paul9834.order.demo.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional


@Repository
@Transactional(Transactional.TxType.MANDATORY) // Investigar que es //

interface StockRepository : JpaRepository <Product, Long>  {

}