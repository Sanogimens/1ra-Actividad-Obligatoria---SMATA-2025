package com.actividad.entregable.obligatoria.ejercicios;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;

@Getter // Genera automáticamente los métodos getter para todos los campos de la clase.
@ToString(callSuper = true) // Genera un método toString() que incluye los campos de la clase padre.
public final class CuentaConvertibilidad extends CuentaCorriente{
    private float saldoEnDolares;
    private static final double tasaCambioPesosADolares = 1420.97;
    private static final double tasaCambioDolaresAPesos = 1 / tasaCambioPesosADolares;

    public CuentaConvertibilidad(int nroCuenta, Cliente cliente, float saldo, float montoAutorizado,
            float saldoEnDolares){
        super(nroCuenta, cliente, saldo, montoAutorizado);
        this.saldoEnDolares = saldoEnDolares;
    }

    @Override //Redefine el método de la clase padre.
    public void depositarEfectivo(float monto){
        if (monto <= 0){
            System.out.println("El monto a depositar debe de ser positivo o no nulo.");
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

    @Override //Redefine el método de la clase padre.
    public void depositarCheque(float monto, String bancoEmisor, LocalDate fechaDePago){
        LocalDate hoy = LocalDate.now(); //Es una clase que representa una fecha sin zona horaria.
        if (fechaDePago.isAfter(hoy)){ //El método isAfter() de la clase LocalDate se utiliza para comparar dos fechas y determinar si una fecha es posterior a otra.
            System.out.println("El cheque aún no está disponible para depósito. Fecha de pago: " + fechaDePago);
            return; //Sale del método si la fecha de pago es futura.
        } 
        else if (monto <= 0){
            System.out.println("El monto del cheque debe ser positivo o no nulo.");
            return; //Sale del método si el monto es inválido.
        } 
        else{
            saldo += monto;
            System.out.println("Cheque depositado por " + monto + " pesos del banco " + bancoEmisor + ". Nuevo saldo: " + saldo);
            return; //Sale del método después de completar la operación.
        }
    }

    public void depositarDolares(float montoEnDolares){
        if (montoEnDolares <= 0){
            System.out.println("El monto a depositar debe ser positivo o no nulo.");
            return; //Sale del método si el monto es inválido.
        } 
        else{
            saldoEnDolares += montoEnDolares;
            float montoEnPesos = (float)(montoEnDolares * tasaCambioPesosADolares);
            System.out.println("Depositaste " + montoEnDolares + " dólares (" + montoEnPesos + " pesos argentinos).");
            System.out.println("Saldo actual en dólares: " + saldoEnDolares);
            return; //Sale del método después de completar la operación.
        }
    }

    public void extraerDolares(float montoEnDolares){
        if (montoEnDolares <= saldoEnDolares){
            saldoEnDolares -= montoEnDolares;
            float montoEnPesos = (float)(montoEnDolares / tasaCambioDolaresAPesos);
            System.out.println("Retiraste " + montoEnDolares + " dólares (" + montoEnPesos + " pesos argentinos).");
            System.out.println("Saldo restante en dólares: " + saldoEnDolares);
            return; //Sale del método después de completar la operación.
        } 
        else{
            System.out.println("Fondos insuficientes. No se puede extraer " + montoEnDolares + " dólares.");
            return; //Sale del método si no se puede completar la operación.
        }
    }

    public void convertirPesosADolares(float saldoEnPesos){
        if (this.saldo <= 0){
            System.out.println("No tienes saldo en pesos para convertir.");
            return; //Sale del método si no hay saldo en pesos.
        } 
        else if (saldoEnPesos > this.saldo){
            System.out.println("No tienes suficiente saldo en pesos para convertir esa cantidad.");
            return; //Sale del método si no hay suficiente saldo en pesos.
        } 
        else{
            CuentaConvertibilidad.this.saldo -= saldoEnPesos;
            CuentaConvertibilidad.this.saldoEnDolares += (saldoEnPesos / tasaCambioPesosADolares);
            System.out.println("Tus " + saldoEnPesos + " pesos argentinos pasan a ser " + (saldoEnPesos / tasaCambioPesosADolares) + " dólares.");
            return; //Sale del método después de completar la operación.
        }
    }

    public void convertirDolaresAPesos(float saldoEnDolares){
        if (this.saldoEnDolares <= 0){
            System.out.println("No tienes saldo en dólares para convertir.");
            return; //Sale del método si no hay saldo en dólares.
        } 
        else if (saldoEnDolares > this.saldoEnDolares){
            System.out.println("No tienes suficiente saldo en dólares para convertir esa cantidad.");
            return; //Sale del método si no hay suficiente saldo en dólares.
        } 
        else{
            CuentaConvertibilidad.this.saldoEnDolares -= saldoEnDolares;
            CuentaConvertibilidad.this.saldo += (saldoEnDolares / tasaCambioDolaresAPesos);
            System.out.println("Tus " + saldoEnDolares + " dólares pasan a ser " + (saldoEnDolares / tasaCambioDolaresAPesos) + " pesos argentinos.");
            return; //Sale del método después de completar la operación.
        }

    }

}