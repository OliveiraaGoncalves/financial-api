package com.financial.parkingmanagement.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RegisterRepository: JpaRepository<RegisterModel, Long> {

    @Query("select v from RegisterModel v")
    override fun findAll(): List<RegisterModel>



}