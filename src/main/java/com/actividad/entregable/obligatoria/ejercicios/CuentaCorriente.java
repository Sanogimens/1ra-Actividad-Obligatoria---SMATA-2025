package com.actividad.entregable.obligatoria.ejercicios;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;

@Getter // Genera automáticamente los métodos getter para todos los campos de la clase.
@ToString(callSuper = true) // Genera un método toString() que incluye los campos de la clase padre.
public class CuentaCorriente extends Cuenta{
    protected float saldo;
    protected float montoAutorizado;

    public CuentaCorriente(int nroCuenta, Cliente cliente, float saldo, float montoAutorizado){
        super(nroCuenta, cliente);
        this.saldo = saldo;
        this.montoAutorizado = montoAutorizado;
    }

    @Override //Redefine el método de la clase padre.
    public void depositarEfectivo(float monto){
        if (monto <= 0){
            System.out.println("El monto a depositar debe ser positivo o no nulo.");
            return; //Sale del método si el monto es inválido.
        }
        this.saldo += monto;
        System.out.println("Depositaste " + monto);
        System.out.println("Saldo actual en pesos: " + saldo);
        return; //Sale del método después de completar la operación.
    }

    @Override //Redefine el método de la clase padre.
    public void extraerEfectivo(float monto){
        if (monto <= (this.saldo + this.montoAutorizado)){
            this.saldo -= monto;
            System.out.println("Retiraste " + monto);
            System.out.println("Saldo restante en pesos: " + saldo);
            return; //Sale del método después de completar la operación.
        } 
        else{
            System.out.println("No es posible descontar ese monto. Límite de extracción (saldo + sobregiro): " + (this.saldo + this.montoAutorizado));
            return; //Sale del método si no se puede completar la operación.
        }
    }
    
    public void depositarCheque(float monto, String bancoEmisor, LocalDate fechaDePago){
        LocalDate hoy = LocalDate.now();
        if (fechaDePago.isAfter(hoy)){
        }
        else if (monto <= 0){
        }
        else{
            saldo += monto;
        }
    }
}