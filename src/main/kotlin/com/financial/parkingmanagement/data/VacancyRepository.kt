package com.financial.parkingmanagement.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface VacancyRepository: JpaRepository<VacancyModel, Long> {
    @Query("SELECT vacancy.id, vacancy.number,\n" +
            "       CASE WHEN register.date_exit is not null THEN 'Disponível'\n" +
            "            WHEN register.date_entry IS NULL THEN 'Disponível'\n" +
            "            ELSE 'Ocupada'\n" +
            "           END AS status_vaga\n" +
            "FROM vacancy\n" +
            "         LEFT JOIN register\n" +
            "                   ON vacancy.id = register.vacancy_id;", nativeQuery = true)
    override fun findAll(): List<VacancyModel>
}