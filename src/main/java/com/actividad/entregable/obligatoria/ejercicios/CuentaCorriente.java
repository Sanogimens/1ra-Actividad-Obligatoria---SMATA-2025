package com.actividad.entregable.obligatoria.ejercicios;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public final class CuentaCorriente extends Cuentas{
    private float saldo;
    private float montoAutorizado;

    public CuentaCorriente(int nroCuenta, Clientes cliente, float saldo, float montoAutorizado) {
        super(nroCuenta, cliente);
        this.saldo = saldo;
        this.montoAutorizado = montoAutorizado;
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

    @Override
    public void extraerEfectivo(float monto){
        if (monto <= (this.saldo + this.montoAutorizado)) {
            this.saldo -= monto;
            System.out.println("Retiraste " + monto);
            System.out.println("Saldo restante en pesos: " + saldo);
        } else {
            System.out.println("No es posible descontar ese monto. Límite de extracción (saldo + sobregiro): " + (this.saldo + this.montoAutorizado));
        }
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

}