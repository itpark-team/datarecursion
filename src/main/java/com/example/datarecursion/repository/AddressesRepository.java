package com.example.datarecursion.repository;

import com.example.datarecursion.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends JpaRepository<Address, Integer> {

}
