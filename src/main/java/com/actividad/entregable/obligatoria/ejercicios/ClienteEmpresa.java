package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter //Se toma el valor de un atributo/parámetro de tipo private.
@Setter //Se modifica el valor de un atributo/parámetro de tipo private.
@ToString(callSuper = true)
public final class ClienteEmpresa extends Cliente{
    private String nombreDeFantasia;
    private int cuit;
    
    public ClienteEmpresa(int nroCliente, String nombreDeFantasia, int cuit) {
        super(nroCliente);
        this.nombreDeFantasia = nombreDeFantasia;
        this.cuit = cuit;
    }

    
}