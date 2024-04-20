package com.financial.parkingmanagement.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RegisterRepository: JpaRepository<RegisterModel, Long> {

    override fun findAll(): MutableList<RegisterModel>
}