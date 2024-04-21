package com.financial.parkingmanagement.data

import jakarta.persistence.*

@Entity
@Table(name = "vacancy")
data class VacancyModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "number")
    val number: Int? = null,

    @Column(name = "status_vaga")
    val statusVaga: String? = null,
)