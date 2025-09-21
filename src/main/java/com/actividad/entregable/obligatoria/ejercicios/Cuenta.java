package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Data;

@Data //Agrupa las anotaciones de Getter, Setter, toString y RequiredArgsConstructor de la librería Lombok.
public class Cuenta{

    private final int nroCuenta;
    private final Cliente cliente;
    protected float saldo;
    

    public void depositarEfectivo(float monto){
        if (monto <= 0){
            return; //Finaliza la ejecucción de un método, sale del mismo.
        }
        this.saldo += monto;
    }

    public void extraerEfectivo(float monto){ 
        if (monto <= this.saldo){
            this.saldo -= monto;
        }
        else{
        }
    }
}