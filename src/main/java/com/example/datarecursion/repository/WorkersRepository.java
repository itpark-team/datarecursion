package com.example.datarecursion.repository;

import com.example.datarecursion.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkersRepository extends JpaRepository<Worker, Integer> {
}
