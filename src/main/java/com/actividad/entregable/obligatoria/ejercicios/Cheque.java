package com.actividad.entregable.obligatoria.ejercicios;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;

@Getter // Genera automáticamente los métodos getter para todos los campos de la clase.
@ToString(callSuper = true) //Genera un método toString() que incluye los campos de la clase padre.
public class Cheque extends CuentaCorriente{
    private float monto;
    private String bancoEmisor;
    private LocalDate fechaDePago;

    public Cheque(String bancoEmisor, LocalDate fechaDePago, float monto, int nroCuenta, Cliente cliente, float saldo, float montoAutorizado){
        super(nroCuenta, cliente, saldo, montoAutorizado);
        this.bancoEmisor = bancoEmisor;
        this.fechaDePago = fechaDePago;
        this.monto = monto;
    }

    @Override
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
}
