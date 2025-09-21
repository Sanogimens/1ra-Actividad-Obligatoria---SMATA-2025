package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Getter;
import lombok.ToString;

@Getter //Anotación de la librería Lombok que genera un método getter en todos los atributos/parámetros no estáticos.
@ToString(callSuper = true) //Incluye el método toString de la clase padre.
public final class CajaAhorro extends Cuenta{
    private float saldo;
    private double tasaDeInteres;

    public CajaAhorro(int nroCuenta, Cliente cliente, float saldo) {
        super(nroCuenta, cliente);
        this.saldo = saldo;
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
        if (tasaDeInteres <= 0 || tiempoEnMeses <= 0) {
            System.out.println("La tasa de interés y el tiempo deben ser valores positivos o no nulos.");
            return; //Finaliza la ejecucción de un método, sale del mismo.
        }
        double interes = this.saldo * Math.pow((1 + tasaDeInteres / 100), tiempoEnMeses) - this.saldo;
        this.saldo += interes;
        System.out.println("Se han cobrado intereses compuestos por un total de: " + interes);
        System.out.println("Saldo actual en pesos: " + saldo);
    }

}