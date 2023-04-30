package com.salesianos.triana.dam.clubDeportivo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int numero;
	private double precio;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey (name="fk_deporte_pista"))
	private Deporte deporte;
	
	// Many-to-One con la clase Socio
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey (name="fk_socio_pista"))
    private Socio socio;
	
    @ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
    @OneToMany(mappedBy = "pista", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();
    
	public void addToDeporte(Deporte deporte) {
		this.deporte=deporte;
		deporte.getPistas().add(this);
	}
	
	public void removeFromDeporte(Deporte deporte) {
		deporte.getPistas().remove(this);
		this.deporte=null;
	}
	
	public boolean isHoraDisponible(LocalDateTime fechaReservaCliente) {
	    for (Reserva reserva : reservas) {
	        if (reserva.getFechaReserva().equals(fechaReservaCliente)) {
	            return false;
	        }
	    }
	    return true;
	}
	
}
