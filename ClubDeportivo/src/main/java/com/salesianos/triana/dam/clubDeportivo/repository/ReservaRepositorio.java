package com.salesianos.triana.dam.clubDeportivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.clubDeportivo.model.Reserva;
import com.salesianos.triana.dam.clubDeportivo.model.Socio;

public interface ReservaRepositorio extends JpaRepository <Reserva, Long>{

	@Query("select count(r) from Reserva r where r.socio = ?1")
	public int findNumReservasBySocio(Socio socio);
	
	//@Query("SELECT r FROM Reserva r JOIN r.socio s WHERE LOWER(s.nombre) LIKE %:nombre%")
	//List<Reserva> findByNombreSocioContainingIgnoreCase(String nombre);
	
}
