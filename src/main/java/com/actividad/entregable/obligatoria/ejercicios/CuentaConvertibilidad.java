package com.actividad.entregable.obligatoria.ejercicios;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public final class CuentaConvertibilidad extends Cuentas {
    private float saldoEnDolares;
    private static final double tasaCambioPesosADolares = 1420.97;
    private static final double tasaCambioDolaresAPesos = 1 / tasaCambioPesosADolares;

    
    public CuentaConvertibilidad(int nroCuenta, Clientes cliente, float saldoEnDolares, float saldo) {
        super(nroCuenta, cliente);
        this.saldoEnDolares = saldoEnDolares;
        this.saldo = saldo;
    }

    @Override
    public void depositarEfectivo(float monto) {
        if (monto <= 0) {
            System.out.println("El monto a depositar debe ser positivo.");
            return;
        }
        this.saldo += monto;
        System.out.println("Depositaste " + monto);
        System.out.println("Saldo actual en pesos: " + saldo);
    }

    public void depositarCheques(float monto, String bancoEmisor, LocalDate fechaDePago){
        LocalDate hoy = LocalDate.now();
        if (fechaDePago.isAfter(hoy)){
        System.out.println("El cheque aún no está disponible para depósito. Fecha de pago: " + fechaDePago);
        } 
        else if (monto <= 0){
            System.out.println("El monto del cheque debe ser positivo.");
        } 
        else{
            saldo += monto;
            System.out.println("Cheque depositado por " + monto + " pesos del banco " + bancoEmisor + ". Nuevo saldo: " + saldo);
        }
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


    public void depositarDolares(float montoEnDolares) {
         if (montoEnDolares <= 0) {
            System.out.println("El monto a depositar debe ser positivo.");
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