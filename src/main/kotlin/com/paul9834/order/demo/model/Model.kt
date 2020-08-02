package com.paul9834.order.demo.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "productos")
data class Product(@Id
                   @GeneratedValue(strategy = GenerationType.IDENTITY)
                   val id: Long? = null,
                   val name: String? = null,
                   val description: String? = null,
                   val price: Long? = null,
                   val img_url: String? = null,
                   val createdAt: LocalDateTime? = LocalDateTime.now(),
                   val updatedAt: LocalDateTime? = LocalDateTime.now()

)
