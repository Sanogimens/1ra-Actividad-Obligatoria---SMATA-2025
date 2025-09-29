package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // Genera automáticamente los métodos getter para todos los campos de la clase.
@Setter // Genera automáticamente los métodos setter para todos los campos de la clase.
@ToString(callSuper = true) // Genera un método toString() que incluye los campos de la clase padre.
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
