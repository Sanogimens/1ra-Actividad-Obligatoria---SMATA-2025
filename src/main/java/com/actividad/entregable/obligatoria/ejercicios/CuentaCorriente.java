package com.actividad.entregable.obligatoria.ejercicios;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;

@Getter //Se toma el valor de un atributo/parámetro de tipo private y protected.
@ToString(callSuper = true)
public class CuentaCorriente extends Cuenta{
    protected float saldo;
    protected float montoAutorizado;

    public CuentaCorriente(int nroCuenta, Cliente cliente, float saldo, float montoAutorizado) {
        super(nroCuenta, cliente);
        this.saldo = saldo;
        this.montoAutorizado = montoAutorizado;
    }

    @Override //Redefine el método de la clase padre
    public void depositarEfectivo(float monto) {
        if (monto <= 0) {
            System.out.println("El monto a depositar debe ser positivo o no nulo.");
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
}