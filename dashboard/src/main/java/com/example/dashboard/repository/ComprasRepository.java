package com.example.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dashboard.model.Compras;
@Repository("ComprasRepository")
public interface ComprasRepository extends JpaRepository<Compras, Integer>{

}
