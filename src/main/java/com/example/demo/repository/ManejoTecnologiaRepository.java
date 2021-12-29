package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ManejoTecnologia;

@Repository
public interface ManejoTecnologiaRepository extends JpaRepository<ManejoTecnologia, Long>{

}
