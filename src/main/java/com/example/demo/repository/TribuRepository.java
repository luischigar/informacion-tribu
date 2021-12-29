package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Tribu;

@Repository
public interface TribuRepository extends JpaRepository<Tribu, Long>{

}
