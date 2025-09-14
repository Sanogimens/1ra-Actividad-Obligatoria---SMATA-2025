package com.actividad.entregable.obligatoria.ejercicios;

import lombok.RequiredArgsConstructor;
import lombok.Data;

@Data
@RequiredArgsConstructor
public abstract class Clientes {
    private int nroCliente;

    public Clientes(int nroCliente) {
        this.nroCliente = nroCliente;
    }

    
}