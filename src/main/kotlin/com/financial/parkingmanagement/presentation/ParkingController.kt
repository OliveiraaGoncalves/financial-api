package com.financial.parkingmanagement.presentation

import com.financial.parkingmanagement.domain.ParkingUseCase
import com.financial.parkingmanagement.domain.Vacancy
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ParkingController(
    private val useCase: ParkingUseCase
) {

    @GetMapping("/allVacancy")
    fun gelAllVacancy(): ResponseEntity<List<Vacancy>> = ResponseEntity.ok(useCase.findAllVacancy())
}