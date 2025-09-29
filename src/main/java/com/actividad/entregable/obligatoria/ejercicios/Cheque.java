package com.actividad.entregable.obligatoria.ejercicios;

import java.time.LocalDate;

import lombok.Getter;

@Getter // Genera automáticamente los métodos getter para todos los campos de la clase.
public class Cheque {
    private float monto;
    private String bancoEmisor;
    private LocalDate fechaDePago;
    
    public Cheque(float monto, String bancoEmisor, LocalDate fechaDePago) {
        this.monto = monto;
        this.bancoEmisor = bancoEmisor;
        this.fechaDePago = fechaDePago;
    }
}
