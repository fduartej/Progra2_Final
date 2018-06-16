package com.example.demoBatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demoBatch.model.Vehiculo;

@Repository("VehiculoRepository")
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer>{
	@Query(value = "SELECT * FROM vehiculo WHERE precio <= ?1", nativeQuery = true)
	List<Vehiculo> buscarXPrecio(String precio);
}
