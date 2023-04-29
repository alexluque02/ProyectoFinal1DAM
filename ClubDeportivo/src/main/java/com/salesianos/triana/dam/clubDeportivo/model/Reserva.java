package com.salesianos.triana.dam.clubDeportivo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reserva {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaReserva;
    
    // Many-to-One con la clase Socio
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey (name="fk_socio_reserva"))
    private Socio socio;
    
    // Many-to-One con la clase Pista
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey (name="fk_pista_reserva"))
    private Pista pista;
}
