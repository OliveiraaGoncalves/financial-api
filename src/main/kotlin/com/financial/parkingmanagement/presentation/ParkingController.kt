package com.financial.parkingmanagement.presentation

import com.financial.parkingmanagement.domain.Register
import com.financial.parkingmanagement.domain.RegisterUseCase
import com.financial.parkingmanagement.domain.Vacancy
import com.financial.parkingmanagement.domain.VacancyUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ParkingController(
    private val useCase: VacancyUseCase,
    private val registerUseCase: RegisterUseCase
) {

    @GetMapping("/allVacancy")
    fun gelAllVacancy(): ResponseEntity<List<Vacancy>> = ResponseEntity.ok(useCase.findAllVacancy())

    @PostMapping("/register")
    fun saveRegister(@RequestBody register: Register): ResponseEntity<Register> =
        ResponseEntity.ok(registerUseCase.register(register))

    @GetMapping("/allRegisters")
    fun gelAllRegisters(): ResponseEntity<List<Register>> = ResponseEntity.ok(registerUseCase.getAllRegisters())
}