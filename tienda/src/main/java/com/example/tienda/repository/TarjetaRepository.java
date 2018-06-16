package com.example.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.Tarjeta;

@Repository("TarjetaRepository")
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer>{

}
