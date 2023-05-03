package com.salesianos.triana.dam.clubDeportivo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Socio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	private String apellidos;
	private String usuario;
	private String contrasena;
	private String telefono;
	private LocalDate fecha_alta;
	private LocalDate fecha_baja;
	private double cuota;
	
	/*
	// One-to-Many con la clase Pista
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
    @OneToMany(mappedBy = "socio")
    private List<Pista> pistas = new ArrayList<>();*/
}
