package com.financial.parkingmanagement.data

import jakarta.persistence.*

@Entity
@Table(name = "register_model")
data class RegisterModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "driverName")
    val driverName: String? = null,

    @Column(name = "plate")
    val plate: String? = null,

    @Column(name = "vacancy_id")
    val vacancyId: String? = null,

    @Column(name = "rantDate")
    val rantDate: String? = null,

)