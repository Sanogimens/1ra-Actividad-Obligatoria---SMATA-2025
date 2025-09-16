package com.actividad.entregable.obligatoria.ejercicios;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;

@Getter //Se toma el valor de un atributo/parámetro de tipo private.
@ToString(callSuper = true)
public final class CuentaConvertibilidad extends CuentaCorriente {
    private float saldoEnDolares;
    private static final double tasaCambioPesosADolares = 1420.97;
    private static final double tasaCambioDolaresAPesos = 1 / tasaCambioPesosADolares;

    public CuentaConvertibilidad(int nroCuenta, Cliente cliente, float saldo, float montoAutorizado,
            float saldoEnDolares) {
        super(nroCuenta, cliente, saldo, montoAutorizado);
        this.saldoEnDolares = saldoEnDolares;
    }

    @Override //Redefine el método de la clase padre
    public void depositarEfectivo(float monto) {
        if (monto <= 0) {
            System.out.println("El monto a depositar debe de ser positivo o no nulo.");
            return; //Finaliza la ejecucción de un método, sale del mismo.
        }
        this.saldo += monto;
        System.out.println("Depositaste " + monto);
        System.out.println("Saldo actual en pesos: " + saldo);
    }

    @Override //Redefine el método de la clase padre
    public void extraerEfectivo(float monto){
        if (monto <= (this.saldo + this.montoAutorizado)) {
            this.saldo -= monto;
            System.out.println("Retiraste " + monto);
            System.out.println("Saldo restante en pesos: " + saldo);
        } else {
            System.out.println("No es posible descontar ese monto. Límite de extracción (saldo + sobregiro): " + (this.saldo + this.montoAutorizado));
        }
    }

    @Override //Redefine el método de la clase padre
    public void depositarCheques(float monto, String bancoEmisor, LocalDate fechaDePago){
        LocalDate hoy = LocalDate.now(); //Es una clase que representa una fecha sin zona horaria.
        if (fechaDePago.isAfter(hoy)){
        System.out.println("El cheque aún no está disponible para depósito. Fecha de pago: " + fechaDePago);
        } 
        else if (monto <= 0){
            System.out.println("El monto del cheque debe ser positivo o no nulo.");
        } 
        else{
            saldo += monto;
            System.out.println("Cheque depositado por " + monto + " pesos del banco " + bancoEmisor + ". Nuevo saldo: " + saldo);
        }
    }



    public void depositarDolares(float montoEnDolares) {
         if (montoEnDolares <= 0) {
            System.out.println("El monto a depositar debe ser positivo o no nulo.");
        } else {
            saldoEnDolares += montoEnDolares;
            float montoEnPesos = (float)(montoEnDolares * tasaCambioPesosADolares);
            System.out.println("Depositaste " + montoEnDolares + " dólares (" + montoEnPesos + " pesos argentinos).");
            System.out.println("Saldo actual en dólares: " + saldoEnDolares);
        }
    }

    public void extraerDolares(float montoEnDolares) {
        if (montoEnDolares <= saldoEnDolares) {
            saldoEnDolares -= montoEnDolares;
            float montoEnPesos = (float)(montoEnDolares / tasaCambioDolaresAPesos);
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
            CuentaConvertibilidad.this.saldoEnDolares += (saldoEnPesos / tasaCambioPesosADolares);
            System.out.println("Tus " + saldoEnPesos + " pesos argentinos pasan a ser " + (saldoEnPesos / tasaCambioPesosADolares) + " dólares.");
        }
    }

    public void convertirDolaresAPesos(float saldoEnDolares){
        if (this.saldoEnDolares <= 0) {
            System.out.println("No tienes saldo en dólares para convertir.");
        } else if (saldoEnDolares > this.saldoEnDolares) {
            System.out.println("No tienes suficiente saldo en dólares para convertir esa cantidad.");
        } else {
            CuentaConvertibilidad.this.saldoEnDolares -= saldoEnDolares;
            CuentaConvertibilidad.this.saldo += (saldoEnDolares / tasaCambioDolaresAPesos);
            System.out.println("Tus " + saldoEnDolares + " dólares pasan a ser " + (saldoEnDolares / tasaCambioDolaresAPesos) + " pesos argentinos.");
        }

    }

}