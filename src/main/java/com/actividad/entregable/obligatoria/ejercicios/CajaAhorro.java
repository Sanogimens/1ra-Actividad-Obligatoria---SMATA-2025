package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CajaAhorro extends Cuentas{
    private float saldo;
    private float tasaDeInteres;

    public CajaAhorro(int nroCuenta, Clientes cliente, float saldo) {
        super(nroCuenta, cliente);
        this.saldo = saldo;
    }

    public void depositarEfectivo(float monto) {
        if (monto <= 0) {
            System.out.println("El monto a depositar debe ser positivo.");
            return;
        }
        this.saldo += monto;
        System.out.println("Depositaste " + monto);
        System.out.println("Saldo actual en pesos: " + saldo);
    }

    @Override
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
    
    public void cobrarInteres(double tasaDeInteres, double tiempoEnMeses){
        if (tasaDeInteres < 0 || tiempoEnMeses < 0) {
            System.out.println("La tasa de interés y el tiempo deben ser valores positivos.");
            return;
        }
        double interes = this.saldo * Math.pow((1 + tasaDeInteres / 100), tiempoEnMeses) - this.saldo;
        this.saldo += interes;
        System.out.println("Se han cobrado intereses compuestos por un total de: " + interes);
        System.out.println("Saldo actual en pesos: " + saldo);
    }

}