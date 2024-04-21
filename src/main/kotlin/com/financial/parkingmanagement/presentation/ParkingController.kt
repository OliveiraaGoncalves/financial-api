package com.financial.parkingmanagement.presentation

import com.financial.parkingmanagement.domain.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ParkingController(
    private val useCase: VacancyUseCase,
    private val registerUseCase: RegisterUseCase
) {

    @GetMapping("/allVacancy")
    fun gelAllVacancy(): ResponseEntity<List<Vacancy>> = ResponseEntity.ok(useCase.findAllVacancy())

    @PostMapping("/register")
    fun saveRegister(@RequestBody register: Register): ResponseEntity<Register> {
        register.vacancyId?.let { useCase.updateStatus(it, StatusVacancy.OCUPADO.name) }
        return ResponseEntity.ok(registerUseCase.register(register))
    }

    @GetMapping("/allRegisters")
    fun gelAllRegisters(
        @RequestParam(required = false) dateEntry: Boolean = false,
        @RequestParam(required = false) dateExit: Boolean = false
    ): ResponseEntity<List<Register>> = ResponseEntity.ok(registerUseCase.getAllRegisters(dateEntry, dateExit))

    @PutMapping("/updateRegister")
    fun updateRegister(@RequestBody register: Register): ResponseEntity<Register> {
        register.vacancyId?.let { useCase.updateStatus(it, StatusVacancy.DISPONIVEL.name) }
        return ResponseEntity.ok(registerUseCase.register(register))
    }
}