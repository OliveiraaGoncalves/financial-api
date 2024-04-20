package com.financial.parkingmanagement.domain

import com.financial.parkingmanagement.data.ParkingRepository
import org.springframework.stereotype.Service
import toDTO

interface ParkingUseCase {

    fun findAllVacancy(): List<Vacancy>

}

@Service
class ParkingUseCaseImpl(private val parkingRepository: ParkingRepository) : ParkingUseCase {
    override fun findAllVacancy(): List<Vacancy> {
        return parkingRepository.findAll().map { it.toDTO() }
    }
}