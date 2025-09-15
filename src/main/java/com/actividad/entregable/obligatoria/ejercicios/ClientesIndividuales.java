package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public final class ClientesIndividuales extends Clientes {
    private String nombre;
    private String apellido;
    private int dni;
    
    public ClientesIndividuales(int nroCliente, String nombre, String apellido, int dni) {
        super(nroCliente);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    
}
