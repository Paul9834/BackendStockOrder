package com.paul9834.order.demo.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "invoice")
data class Invoice (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = 0,

        val createdAt: LocalDateTime? = LocalDateTime.now(),
        val updatedAt: LocalDateTime? = LocalDateTime.now(),

        val nombre: String? = "",
        val direccion: String? = "",
        val telefono: String? = "",

        var order_total : Int? = null,

        @OneToMany(cascade = [CascadeType.ALL])
        @JoinColumn (name = "invoice_id")
        @JsonManagedReference
        val invoiceItems: List<InvoiceItem>? = mutableListOf()

) {

        fun calculateTotalOrder(): Int? {
                var total = 0
                invoiceItems?.let {
                        for (product in it) {

                                val totalByItem = product.item?.price!!
                                total += totalByItem * product.quantitiy!!

                        }
                }
                return total
        }

}


@Entity
@Table(name = "item")
data class Item(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val name: String? = null,
        val description: String? = null,
        val price: Int? = null,
        val img_url: String? = null,
        val createdAt: LocalDateTime? = LocalDateTime.now(),
        val updatedAt: LocalDateTime? = LocalDateTime.now(),

        @OneToMany(cascade = [CascadeType.ALL])
        @JoinColumn (name = "item_id")
        @JsonBackReference
        val items: List<InvoiceItem>? = mutableListOf()

        )

@Entity
@Table(name = "invoice_item")
data class InvoiceItem(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = 0,

        val quantitiy: Int? = 0,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "invoice_id")
        @JsonIgnore
        val invoice: Invoice? = null,

        @ManyToOne
        @JoinColumn(name = "item_id")
        val item: Item? = null


)

