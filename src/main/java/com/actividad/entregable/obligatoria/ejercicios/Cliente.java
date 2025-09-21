package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Data;

@Data // Genera automáticamente los métodos getter, setter y toString para todos los campos de la clase.
public abstract class Cliente{
    private int nroCliente;

    public Cliente(int nroCliente){
        this.nroCliente = nroCliente;
    }

    
}