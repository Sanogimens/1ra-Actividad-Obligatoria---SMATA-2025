package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter //Se toma el valor de un atributo/parámetro de tipo private.
@Setter //Se modifica el valor de un atributo/parámetro de tipo private.
@ToString(callSuper = true)
public final class ClienteIndividual extends Cliente {
    private String nombre;
    private String apellido;
    private int dni;
    
    public ClienteIndividual(int nroCliente, String nombre, String apellido, int dni) {
        super(nroCliente);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    
}
