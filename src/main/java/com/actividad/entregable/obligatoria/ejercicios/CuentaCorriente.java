package com.actividad.entregable.obligatoria.ejercicios;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public final class CuentaCorriente extends Cuentas{
    private float saldo;

    public CuentaCorriente(int nroCuenta, Clientes cliente, float saldo) {
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

    public void depositarCheque(float montoCheque) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depositarCheque'");
    }

}