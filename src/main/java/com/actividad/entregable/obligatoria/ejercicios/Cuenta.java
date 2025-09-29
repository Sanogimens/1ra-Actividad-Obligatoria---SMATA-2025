package com.actividad.entregable.obligatoria.ejercicios;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor // Genera automáticamente un constructor con todos los campos de la clase como parámetros.
@Data // Genera automáticamente los métodos getter, setter y toString para todos los campos de la clase.
public abstract class Cuenta {

    private final int nroCuenta;
    private final Cliente cliente;
    protected float saldo;

   public void depositarEfectivo(float monto) {
        if (monto <= 0) {
            System.out.println("El monto a depositar debe ser positivo o no nulo.");
        } else {
            this.saldo += monto;
            System.out.println("Depositaste " + monto);
            System.out.println("Saldo actual en pesos: " + saldo);
        }
    }

    public void extraerEfectivo(float monto) { 
        if (monto <= this.saldo) {
            this.saldo -= monto;
            System.out.println("Retiraste " + monto);
            System.out.println("Saldo restante en pesos: " + saldo);
        } else {
            System.out.println("No es posible descontar ese monto.");
        }
    }
}