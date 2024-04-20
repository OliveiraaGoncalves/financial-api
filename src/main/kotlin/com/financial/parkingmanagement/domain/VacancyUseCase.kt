package com.financial.parkingmanagement.domain

import com.financial.parkingmanagement.data.VacancyRepository
import org.springframework.stereotype.Service
import toDTO

interface VacancyUseCase {

    fun findAllVacancy(): List<Vacancy>
}

@Service
class VacancyUseCaseImpl(private val vacancyRepository: VacancyRepository) : VacancyUseCase {

    override fun findAllVacancy(): List<Vacancy> {
        return vacancyRepository.findAll().map { it.toDTO() }
    }
}