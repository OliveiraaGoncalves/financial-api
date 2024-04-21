package com.financial.parkingmanagement.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface VacancyRepository: JpaRepository<VacancyModel, Long> {
    @Query("SELECT vacancy.id, vacancy.number,\n" +
            "       CASE WHEN register.date_entry IS NULL AND register.date_exit IS NULL THEN 'Disponível'\n" +
            "            WHEN length(register.date_exit) > 0 AND register.date_exit IS not NULL THEN 'Disponível'\n" +
            "            ELSE 'Ocupado'\n" +
            "           END AS status_vaga\n" +
            "FROM vacancy\n" +
            "         LEFT JOIN register\n" +
            "                   ON vacancy.id = register.vacancy_id;", nativeQuery = true)
    override fun findAll(): List<VacancyModel>
}