package com.financial.parkingmanagement.presentation

import com.financial.parkingmanagement.domain.Register
import com.financial.parkingmanagement.domain.RegisterUseCase
import com.financial.parkingmanagement.domain.Vacancy
import com.financial.parkingmanagement.domain.VacancyUseCase
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
    fun saveRegister(@RequestBody register: Register): ResponseEntity<Register> =
        ResponseEntity.ok(registerUseCase.register(register))

    @GetMapping("/allRegisters")
    fun gelAllRegisters(
        @RequestParam(required = false) dateEntry: Boolean = false,
        @RequestParam(required = false) dateExit: Boolean = false
    ): ResponseEntity<List<Register>> = ResponseEntity.ok(registerUseCase.getAllRegisters(dateEntry, dateExit))

    @PutMapping("/updateRegister")
    fun updateRegister(@RequestBody register: Register): ResponseEntity<Register> =
        ResponseEntity.ok(registerUseCase.register(register))
}