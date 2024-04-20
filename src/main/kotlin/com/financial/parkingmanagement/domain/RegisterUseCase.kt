package com.financial.parkingmanagement.domain

import com.financial.parkingmanagement.data.RegisterRepository
import org.springframework.stereotype.Service
import toDTO
import toEntity

interface RegisterUseCase {
    fun register(register: Register): Register
    fun getAllRegisters(): List<Register>
}

@Service
class RegisterUseCaseImpl(
    private val registerRepository: RegisterRepository
) : RegisterUseCase {
    override fun register(register: Register): Register {
        return registerRepository.save(register.toEntity()).toDTO()
    }

    override fun getAllRegisters(): List<Register> = registerRepository.findAll().map { it.toDTO() }
}