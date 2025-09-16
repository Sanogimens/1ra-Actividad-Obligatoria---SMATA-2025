package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Data;

@Data //Genera automáticamente los métodos Getter, Setter, toString y RequiredArgsConstructor.
public abstract class Cliente {
    private int nroCliente;

    public Cliente(int nroCliente) {
        this.nroCliente = nroCliente;
    }

    
}