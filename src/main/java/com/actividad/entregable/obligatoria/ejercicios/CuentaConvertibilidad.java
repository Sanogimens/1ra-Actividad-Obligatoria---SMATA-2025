package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Getter;
import lombok.ToString;

@Getter // Genera automáticamente los métodos getter para todos los campos.
@ToString(callSuper = true) // Genera un método toString() que incluye los campos de la clase padre.
public final class CuentaConvertibilidad extends CuentaCorriente {
    private float saldoEnDolares;

    public CuentaConvertibilidad(int nroCuenta, Cliente cliente, float saldo, float montoAutorizado, float saldoEnDolares) {
        super(nroCuenta, cliente, saldo, montoAutorizado);
        this.saldoEnDolares = saldoEnDolares;
    }

    public void depositarDolares(float montoEnDolares) {
        if (montoEnDolares <= 0) {
            System.out.println("El monto a depositar debe ser positivo o no nulo.");
        } else {
            saldoEnDolares += montoEnDolares;
            double tasaCambioPesosADolares = 1300.00; // Tasa de cambio fija
            float montoEnPesos = (float)(montoEnDolares * tasaCambioPesosADolares); // Deposito en dólares
            System.out.println("Depositaste " + montoEnDolares + " dólares (" + montoEnPesos + " pesos argentinos).");
            System.out.println("Saldo actual en dólares: " + saldoEnDolares);
        }
    }

    public void extraerDolares(float montoEnDolares) {
        if (montoEnDolares <= saldoEnDolares) {
            saldoEnDolares -= montoEnDolares;
            double tasaCambioDolaresAPesos = 1 / 1300.00; // Tasa de cambio fija
            float montoEnPesos = (float)(montoEnDolares / tasaCambioDolaresAPesos); // Extracción en dólares
            System.out.println("Retiraste " + montoEnDolares + " dólares (" + montoEnPesos + " pesos argentinos).");
            System.out.println("Saldo restante en dólares: " + saldoEnDolares);
        } else {
            System.out.println("Fondos insuficientes. No se puede extraer " + montoEnDolares + " dólares.");
        }
    }

    public void convertirPesosADolares(float saldoEnPesos) {
        if (this.saldo <= 0) {
            System.out.println("No tienes saldo en pesos para convertir.");
        } else if (saldoEnPesos > this.saldo) {
            System.out.println("No tienes suficiente saldo en pesos para convertir esa cantidad.");
        } else {
            CuentaConvertibilidad.this.saldo -= saldoEnPesos;
            double tasaCambioPesosADolares = 1300.00; // Tasa de cambio fija
            CuentaConvertibilidad.this.saldoEnDolares += (saldoEnPesos / tasaCambioPesosADolares); // Conversión a dólares
            System.out.println("Tus " + saldoEnPesos + " pesos argentinos pasan a ser " + (saldoEnPesos / tasaCambioPesosADolares) + " dólares.");
        }
    }

    public void convertirDolaresAPesos(float saldoEnDolares) {
        if (this.saldoEnDolares <= 0) {
            System.out.println("No tienes saldo en dólares para convertir.");
        } 
        else if (saldoEnDolares > this.saldoEnDolares){
            System.out.println("No tienes suficiente saldo en dólares para convertir esa cantidad.");
        } else {
            CuentaConvertibilidad.this.saldoEnDolares -= saldoEnDolares;
            double tasaCambioDolaresAPesos = 1 / 1300.00; // Tasa de cambio fija
            CuentaConvertibilidad.this.saldo += (saldoEnDolares / tasaCambioDolaresAPesos); // Conversión a pesos argentinos
            System.out.println("Tus " + saldoEnDolares + " dólares pasan a ser " + (saldoEnDolares / tasaCambioDolaresAPesos) + " pesos argentinos.");
        }
    }
}