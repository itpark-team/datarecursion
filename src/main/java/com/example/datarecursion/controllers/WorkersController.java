package com.example.datarecursion.controllers;


import com.example.datarecursion.dtos.AddressResponseDto;
import com.example.datarecursion.dtos.WorkerResponseDto;
import com.example.datarecursion.model.Address;
import com.example.datarecursion.model.Worker;
import com.example.datarecursion.repository.WorkersRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/workers")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class WorkersController {

    private WorkersRepository workersRepository;

//    @GetMapping(value = "/get-all")
//    public List<WorkerResponseDto> getAll() {
//        return workersRepository.findAll().stream().map(
//                worker -> WorkerResponseDto
//                        .builder()
//                        .id(worker.getId())
//                        .name(worker.getName())
//                        .addressId(worker.getAddress().getId())
//                        .addressStreet(worker.getAddress().getStreet())
//                        .addressHome(worker.getAddress().getHome())
//                        .build()
//        ).collect(Collectors.toList());
//    }

    private AddressResponseDto addressToDto(Address address) {
        return AddressResponseDto.builder()
                .id(address.getId())
                .street(address.getStreet())
                .home(address.getHome())
                .build();
    }

    @GetMapping(value = "/get-all")
    public List<WorkerResponseDto> getAll() {
        return workersRepository.findAll().stream().map(
                worker -> WorkerResponseDto
                        .builder()
                        .id(worker.getId())
                        .name(worker.getName())
                        .address(addressToDto(worker.getAddress()))
                        .build()
        ).collect(Collectors.toList());
    }

}
