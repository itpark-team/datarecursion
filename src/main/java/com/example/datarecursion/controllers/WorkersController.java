package com.example.datarecursion.controllers;


import com.example.datarecursion.dtos.AddressResponseDto;
import com.example.datarecursion.dtos.WorkerResponseDto;
import com.example.datarecursion.model.Address;
import com.example.datarecursion.model.Worker;
import com.example.datarecursion.repository.WorkersRepository;
import com.example.datarecursion.service.WorkersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/workers")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class WorkersController {

    private WorkersService workersService;

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

    @GetMapping(value = "/get-all")
    public List<WorkerResponseDto> getAll() {
        return workersService.getAll();
    }

    @GetMapping(value = "/get-by-id/{id}")
    public WorkerResponseDto getById(@PathVariable int id) {
        return workersService.getById(id);
    }

}
