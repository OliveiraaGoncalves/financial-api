package com.financial.sale.domain

import com.financial.sale.data.SaleRepository
import org.springframework.stereotype.Service
import toDTO
import toEntity

interface SaleService {
    fun getAllSale(): List<Sale>

    fun findSales(hashSale: String): List<Sale>

    fun createSale(sale: Sale): Sale
}

@Service
class SaleServiceImpl(private val saleRepository: SaleRepository) : SaleService {

    override fun getAllSale(): List<Sale> = saleRepository.findAll().map { it.toDTO() }

    override fun findSales(hashSale: String): List<Sale> {
        return saleRepository.findAllByHashSaleLike(hashSale).map { it.toDTO() }
    }

    override fun createSale(sale: Sale): Sale {
        return saleRepository.save(sale.toEntity()).toDTO()
    }
}