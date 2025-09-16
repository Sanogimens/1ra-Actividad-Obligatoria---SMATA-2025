package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter //Se toma el valor de un atributo/parámetro de tipo private y protected.
@RequiredArgsConstructor //Genera un constructor por cada atributo/parámetro final.
@ToString //Representa a la clase como una cadena de texto.
public class Cuenta {

    private final int nroCuenta;
    private final Cliente cliente;
    protected float saldo;
    

    public void depositarEfectivo(float monto) {
        if (monto <= 0) {
            System.out.println("El monto a depositar debe ser positivo o no nulo.");
            return; //Finaliza la ejecucción de un método, sale del mismo.
        }
        this.saldo += monto;
        System.out.println("Depositaste " + monto);
        System.out.println("Saldo actual en pesos: " + saldo);
    }

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
}