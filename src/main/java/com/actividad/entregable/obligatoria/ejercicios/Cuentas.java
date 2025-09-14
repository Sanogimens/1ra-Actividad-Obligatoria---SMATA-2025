package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString 
public class Cuentas {

    private final int nroCuenta;
    private final Clientes cliente;
    protected float saldo;
    

    public void depositarEfectivo(float monto) {
        if (monto <= 0) {
            System.out.println("El monto a depositar debe ser positivo.");
            return;
        }
        this.saldo += monto;
        System.out.println("Depositaste " + monto);
        System.out.println("Saldo actual en pesos: " + saldo);
    }

    public void extraerEfectivo(float monto){ 
        if (monto <= this.saldo) {
            this.saldo -= monto;
            float montoEnPesos = monto;
            System.out.println("Retiraste " + montoEnPesos);
            System.out.println("Saldo restante en pesos: " + saldo);
        } else {
            System.out.println("No es posible descontar ese monto.");
        }

    }

    public float consultarSaldo() {
        return this.saldo;
    }

}