package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Data;

@Data //Agrupa las anotaciones de Getter, Setter, toString y RequiredArgsConstructor de la librería Lombok.
public abstract class Cliente{
    private int nroCliente;

    public Cliente(int nroCliente){
        this.nroCliente = nroCliente;
    }

    
}