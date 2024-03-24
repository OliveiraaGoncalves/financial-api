package com.financial.sale.presentation
import com.financial.sale.domain.Sale
import com.financial.sale.domain.SaleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class SaleController(
    private val service: SaleService
) {

    @GetMapping("/allSales")
    fun getAllSale(): ResponseEntity<List<Sale>> = ResponseEntity.ok(service.getAllSale())

    @GetMapping("/sale/{id}")
    fun getSale(@PathVariable id: Long): ResponseEntity<Sale> = ResponseEntity.ok(service.findSale(id))

    @PostMapping("/createSale")
    fun createSale(@RequestBody sale: Sale): ResponseEntity<Sale> = ResponseEntity.ok(service.createSale(sale = sale))

}