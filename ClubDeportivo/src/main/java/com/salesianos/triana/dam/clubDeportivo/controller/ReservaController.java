package com.salesianos.triana.dam.clubDeportivo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.clubDeportivo.model.Reserva;
import com.salesianos.triana.dam.clubDeportivo.service.ReservaService;

@Controller
public class ReservaController {

	@Autowired
	private ReservaService service;

	@GetMapping("/panel-admin/reservas")
	public String listarReservas(Model model) {

		model.addAttribute("reservas", service.findAll());

		return "panelAdmin";
	}

	@PostMapping("/reservas")
	public String agregarReserva(@ModelAttribute("reserva") Reserva reserva) {
		service.save(reserva);
		return "redirect:/panel-admin";
	}
}
