package com.actividad.entregable.obligatoria.ejercicios;

import lombok.Getter;
import lombok.ToString;

@Getter // Genera automáticamente los métodos getter para todos los campos.
@ToString(callSuper = true) // Genera un método toString() que incluye los campos de la clase padre.
public final class CajaAhorro extends Cuenta {
    
    private double tasaDeInteres;

    public CajaAhorro(int nroCuenta, Cliente cliente, float saldo, double tasaDeInteres) {
        super(nroCuenta, cliente, saldo);
        this.tasaDeInteres = tasaDeInteres;
    }

    public void cobrarInteres(double tasaDeInteres, double tiempoEnMeses) {
        if (tasaDeInteres <= 0 || tiempoEnMeses <= 0) {
            System.out.println("La tasa de interés y el tiempo deben ser valores positivos o no nulos.");
        } else {
            double tasaMensual = (tasaDeInteres / 100) / 12; // Convertir tasa anual a tasa mensual en decimal
            double interes = this.saldo * (Math.pow(1 + tasaMensual, tiempoEnMeses) - 1); // Fórmula de interés compuesto
            this.saldo += interes;
            System.out.println("Se han cobrado intereses compuestos por un total de: " + interes);
            System.out.println("Saldo actual en pesos: " + saldo);
        }
    }
    
}