package com.example.datarecursion.service;

import com.example.datarecursion.dtos.AddressResponseDto;
import com.example.datarecursion.dtos.WorkerResponseDto;
import com.example.datarecursion.model.Address;
import com.example.datarecursion.model.Worker;
import com.example.datarecursion.redis.RedisUtil;
import com.example.datarecursion.repository.WorkersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkersService {

    private WorkersRepository workersRepository;
    private RedisUtil redisUtil;

    public List<WorkerResponseDto> getAll() {
        String key = "workers:get-all";
        if (redisUtil.exist(key)) {

            System.out.println("exist key");

            return (List<WorkerResponseDto>) redisUtil.get(key);
        }
        System.out.println("key not found");

        List<WorkerResponseDto> resultDb = getAllFromDb();
        redisUtil.put(key, resultDb);

        return resultDb;
    }

    public WorkerResponseDto getById(int id) {
        String key = "workers:get-by-id:" + id;

        if (redisUtil.exist(key)) {

            System.out.println("exist key");

            return (WorkerResponseDto) redisUtil.get(key);
        }
        System.out.println("key not found");

        WorkerResponseDto resultDb = getByIdFromDb(id);
        redisUtil.put(key, resultDb);

        return resultDb;
    }

    private AddressResponseDto addressToDto(Address address) {
        return AddressResponseDto.builder()
                .id(address.getId())
                .street(address.getStreet())
                .home(address.getHome())
                .build();
    }

    private List<WorkerResponseDto> getAllFromDb() {
        return workersRepository.findAll().stream().map(
                worker -> WorkerResponseDto
                        .builder()
                        .id(worker.getId())
                        .name(worker.getName())
                        .address(addressToDto(worker.getAddress()))
                        .build()
        ).collect(Collectors.toList());
    }

    private WorkerResponseDto getByIdFromDb(int id) {
        return workersRepository.findById(id).stream().map(
                worker -> WorkerResponseDto
                        .builder()
                        .id(worker.getId())
                        .name(worker.getName())
                        .address(addressToDto(worker.getAddress()))
                        .build()
        ).findFirst().get();
    }

//    private List<WorkerResponseDto> getAllFromRedis() {
//
//    }
}
