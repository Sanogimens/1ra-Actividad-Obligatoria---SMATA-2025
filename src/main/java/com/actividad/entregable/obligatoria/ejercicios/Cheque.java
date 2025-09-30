package com.actividad.entregable.obligatoria.ejercicios;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor // Genera automáticamente un constructor con todos los campos de la clase como parámetros.
@Getter // Genera automáticamente los métodos getter para todos los campos de la clase.
public class Cheque {
    private float monto;
    private String bancoEmisor;
    private LocalDate fechaDePago;
}
