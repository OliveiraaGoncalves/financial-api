package com.financial.parkingmanagement.data

import jakarta.persistence.*

@Entity
@Table(name = "register")
data class RegisterModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "driver_name")
    val driverName: String? = null,

    @Column(name = "plate")
    val plate: String? = null,

    @Column(name = "vacancy_id")
    val vacancyId: String? = null,

    @Column(name = "date_entry")
    val dateEntry: String? = null,

    @Column(name = "date_exit")
    val dateExit: String? = null,
)