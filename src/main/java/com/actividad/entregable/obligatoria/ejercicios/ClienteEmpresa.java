package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // Genera automáticamente los métodos getter para todos los campos de la clase.
@Setter // Genera automáticamente los métodos setter para todos los campos de la clase.
@ToString(callSuper = true) // Genera un método toString() que incluye los campos de la clase padre.
public final class ClienteEmpresa extends Cliente {
    private String nombreDeFantasia;
    private long cuit;
    
    public ClienteEmpresa(int nroCliente, String nombreDeFantasia, long cuit) {
        super(nroCliente);
        this.nombreDeFantasia = nombreDeFantasia;
        this.cuit = cuit;
    }
}