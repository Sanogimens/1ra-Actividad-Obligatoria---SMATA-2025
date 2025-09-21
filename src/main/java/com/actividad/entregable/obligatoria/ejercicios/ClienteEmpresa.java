package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter //Anotación de la librería Lombok que genera un método getter en todos los atributos/parámetros no estáticos.
@Setter //Anotación de la librería Lombok que genera un método setter en todos los atributos/parámetros no estáticos.
@ToString(callSuper = true) //Incluye el método toString de la clase padre.
public final class ClienteEmpresa extends Cliente{
    private String nombreDeFantasia;
    private int cuit;
    
    public ClienteEmpresa(int nroCliente, String nombreDeFantasia, int cuit){
        super(nroCliente);
        this.nombreDeFantasia = nombreDeFantasia;
        this.cuit = cuit;
    }

    
}