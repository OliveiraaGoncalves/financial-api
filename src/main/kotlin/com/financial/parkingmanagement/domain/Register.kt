package com.financial.parkingmanagement.domain

data class Register(

    val id: Long? = null,

    val driverName: String? = null,

    val plate: String? = null,

    val vacancyId: String? = null,

    val dateEntry: String? = null,

    val dateExit: String? = null,
    )