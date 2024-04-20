package com.financial.parkingmanagement.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface VacancyRepository: JpaRepository<VacancyModel, Long> {

    @Query("select v from VacancyModel v")
    override fun findAll(): List<VacancyModel>



}