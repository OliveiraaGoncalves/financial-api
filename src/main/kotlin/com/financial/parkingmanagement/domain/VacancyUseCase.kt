package com.financial.parkingmanagement.domain

import com.financial.parkingmanagement.data.VacancyRepository
import org.springframework.stereotype.Service
import toDTO
import toEntity

interface VacancyUseCase {

    fun findAllVacancy(): List<Vacancy>

    fun updateStatus(vacancyId: Long, status: String)
}

@Service
class VacancyUseCaseImpl(private val vacancyRepository: VacancyRepository) : VacancyUseCase {

    override fun findAllVacancy(): List<Vacancy> {
        return vacancyRepository.findAll().map { it.toDTO() }
    }

    override fun updateStatus(vacancyId: Long, status: String) {
        val vacancy = vacancyRepository.findById(vacancyId).get().copy(
            statusVaga = status
        )
        vacancyRepository.save(vacancy.toEntity())
    }
}