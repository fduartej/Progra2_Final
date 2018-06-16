package com.example.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.Compras;

@Repository("ComprasRepository")
public interface ComprasRepository extends JpaRepository<Compras, Integer>{

}
