package com.financial.parkingmanagement.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface VacancyRepository: JpaRepository<VacancyModel, Long> {

    @Query("SELECT vacancy.id, vacancy.number\n" +
            "FROM vacancy\n" +
            "         LEFT OUTER JOIN register\n" +
            "                         ON vacancy.id = register.vacancy_id\n" +
            "WHERE register.vacancy_id IS NULL;", nativeQuery = true)
    override fun findAll(): List<VacancyModel>
}