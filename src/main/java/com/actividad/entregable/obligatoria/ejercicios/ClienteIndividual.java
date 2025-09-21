package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter //Anotación de la librería Lombok que genera un método getter en todos los atributos/parámetros no estáticos.
@Setter //Anotación de la librería Lombok que genera un método setter en todos los atributos/parámetros no estáticos.
@ToString(callSuper = true) //Incluye el método toString de la clase padre.
public final class ClienteIndividual extends Cliente{
    private String nombre;
    private String apellido;
    private int dni;
    
    public ClienteIndividual(int nroCliente, String nombre, String apellido, int dni){
        super(nroCliente);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    
}
