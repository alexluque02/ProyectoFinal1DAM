package com.salesianos.triana.dam.clubDeportivo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.clubDeportivo.model.Reserva;
import com.salesianos.triana.dam.clubDeportivo.model.Socio;
import com.salesianos.triana.dam.clubDeportivo.repository.ReservaRepositorio;

@Service
public class ReservaService extends BaseServiceImp<Reserva, Long, ReservaRepositorio> {
	
	@Autowired
	private ReservaRepositorio repositorio;

	public int numeroReservasPorSocio(Socio socio) {
		return repositorio.findNumReservasBySocio(socio);
	}
}
