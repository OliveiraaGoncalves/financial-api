package com.financial.parkingmanagement.data

import jakarta.persistence.*

@Entity
@Table(name = "vacancy_total")
data class VacancyTotalModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "total")
    val totalVacancy: Int? = null,
)