package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class ClientesEmpresa extends Clientes{
    private String nombreDeFantasia;
    private int cuit;
    
    public ClientesEmpresa(int nroCliente, String nombreDeFantasia, int cuit) {
        super(nroCliente);
        this.nombreDeFantasia = nombreDeFantasia;
        this.cuit = cuit;
    }

    
}