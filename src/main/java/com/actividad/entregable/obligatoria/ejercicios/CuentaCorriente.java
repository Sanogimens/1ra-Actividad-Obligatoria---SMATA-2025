package com.actividad.entregable.obligatoria.ejercicios;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;

@Getter //Anotación de la librería Lombok que genera un método getter en todos los atributos/parámetros no estáticos.
@ToString(callSuper = true) //Incluye el método toString de la clase padre.
public class CuentaCorriente extends Cuenta{
    protected float saldo;
    protected float montoAutorizado;

    public CuentaCorriente(int nroCuenta, Cliente cliente, float saldo, float montoAutorizado){
        super(nroCuenta, cliente);
        this.saldo = saldo;
        this.montoAutorizado = montoAutorizado;
    }

    @Override //Redefine el método de la clase padre
    public void depositarEfectivo(float monto){
        if (monto <= 0){
            System.out.println("El monto a depositar debe ser positivo o no nulo.");
            return; //Finaliza la ejecucción de un método, sale del mismo.
        }
        this.saldo += monto;
        System.out.println("Depositaste " + monto);
        System.out.println("Saldo actual en pesos: " + saldo);
    }

    @Override //Redefine el método de la clase padre
    public void extraerEfectivo(float monto){
        if (monto <= (this.saldo + this.montoAutorizado)){
            this.saldo -= monto;
            System.out.println("Retiraste " + monto);
            System.out.println("Saldo restante en pesos: " + saldo);
        } 
        else{
            System.out.println("No es posible descontar ese monto. Límite de extracción (saldo + sobregiro): " + (this.saldo + this.montoAutorizado));
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