package com.financial.parkingmanagement.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RegisterRepository: JpaRepository<RegisterModel, Long> {

    @Query("SELECT *\n" +
            "FROM register\n" +
            "WHERE TRIM(date_entry) IS NOT NULL AND TRIM(date_entry) <> '';", nativeQuery = true)
    fun findAllByDateEntry(): MutableList<RegisterModel>

    @Query("SELECT *\n" +
            "FROM register\n" +
            "WHERE TRIM(date_exit) IS NOT NULL AND TRIM(date_exit) <> '';", nativeQuery = true)
    fun findAllByDateExit(): MutableList<RegisterModel>

    override fun findAll(): MutableList<RegisterModel>
}