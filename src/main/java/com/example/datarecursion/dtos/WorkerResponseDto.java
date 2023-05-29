package com.example.datarecursion.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkerResponseDto {
    private int id;
    private String name;
    private AddressResponseDto address;
//    private int addressId;
//    private String addressStreet;
//    private int addressHome;
}
