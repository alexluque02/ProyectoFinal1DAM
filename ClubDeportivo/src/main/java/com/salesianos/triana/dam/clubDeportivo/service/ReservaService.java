package com.salesianos.triana.dam.clubDeportivo.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.clubDeportivo.model.Reserva;
import com.salesianos.triana.dam.clubDeportivo.model.Socio;
import com.salesianos.triana.dam.clubDeportivo.repository.ReservaRepositorio;

@Service
public class ReservaService extends BaseServiceImp<Reserva, Long, ReservaRepositorio> {
	
	@Autowired
	private ReservaRepositorio repositorio;
	
	public boolean isHoraDisponible(LocalTime horaReserva, LocalDate fechaReserva, int id) {
	    for (Reserva reserva : repositorio.findAll()) {
	        if (reserva.getPista().getId()==id && reserva.getFecha_reserva().equals(fechaReserva) && reserva.getHora_reserva().equals(horaReserva)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public void calcularPrecio(Reserva reserva) {
		double div = 100;
		double precioAumentado = 0;


		if (reserva.getHora_reserva().isAfter(reserva.getPista().getHora_aumento_precio()) || 
				reserva.getHora_reserva().equals(reserva.getPista().getHora_aumento_precio())) {
			precioAumentado = reserva.getPista().getPrecio() + reserva.getPista().getAumento_precio()
					/ div * reserva.getPista().getAumento_precio();
			reserva.setPrecio_reserva(precioAumentado);
		};
	}

	public int numeroReservasPorSocio(Socio socio) {
		return repositorio.findNumReservasBySocio(socio);
	}
	
	public List<Reserva> findReservasEstaSemanaYPista(int idPista) {
		
        LocalDate hoy = LocalDate.now();
        LocalDate inicioSemana = hoy.with(DayOfWeek.MONDAY);
        LocalDate finSemana = hoy.with(DayOfWeek.SATURDAY);
        List<Reserva> reservas = repositorio.findByFechaReservaEntreYPista(inicioSemana, finSemana, idPista);

        return reservas;
    }
	
	public List<Reserva> findReservasProximaSemanaYPista(int idPista) {
	    LocalDate hoy = LocalDate.now();
	    LocalDate inicioProximaSemana = hoy.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
	    LocalDate finProximaSemana = hoy.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
	    List<Reserva> reservas = repositorio.findByFechaReservaEntreYPista(inicioProximaSemana, finProximaSemana, idPista);
	    return reservas;
	}

}
