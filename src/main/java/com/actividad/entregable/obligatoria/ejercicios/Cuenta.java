package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Data;

@Data // Genera automáticamente los métodos getter, setter y toString para todos los campos de la clase.
public class Cuenta{

    private final int nroCuenta;
    private final Cliente cliente;
    protected float saldo;

    public void depositarEfectivo(float monto){
        if (monto <= 0){
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