package com.actividad.entregable.obligatoria.ejercicios;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor // Genera automáticamente un constructor con todos los campos de la clase como parámetros.
@Data // Genera automáticamente los métodos getter, setter y toString para todos los campos de la clase.
public abstract class Cliente{

    private int nroCliente;
    
}