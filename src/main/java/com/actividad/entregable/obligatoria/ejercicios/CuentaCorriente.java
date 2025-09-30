package com.actividad.entregable.obligatoria.ejercicios;

import java.time.LocalDate;
import lombok.Getter;
import lombok.ToString;

@Getter // Genera automáticamente los métodos getter para todos los campos.
@ToString(callSuper = true) // Genera un método toString() que incluye los campos de la clase padre.
public class CuentaCorriente extends Cuenta {
    
    private float montoAutorizado;

    public CuentaCorriente(int nroCuenta, Cliente cliente, float saldo, float montoAutorizado) {
        super(nroCuenta, cliente, saldo);
        this.montoAutorizado = montoAutorizado;
    }

    @Override // Redefine el método de la clase padre.
    public void extraerEfectivo(float monto) {
        if (monto <= (this.saldo + this.montoAutorizado) && monto > 0) { // Verifica que el monto a extraer no supere el saldo más el sobregiro autorizado y que sea positivo.
            this.saldo -= monto;
            System.out.println("Retiraste " + monto);
            System.out.println("Saldo restante en pesos: " + saldo);
        } else {
            System.out.println("No es posible descontar ese monto. Límite de extracción (saldo + sobregiro): " + (this.saldo + this.montoAutorizado));
        }
    }

    public void depositarCheque(Cheque cheque) {
        LocalDate hoy = LocalDate.now(); // Es una clase que representa una fecha sin zona horaria.
        if (cheque.getFechaDePago().isAfter(hoy)) { // El método isAfter() de la clase LocalDate se utiliza para comparar dos fechas y determinar si una fecha es posterior a otra.
            System.out.println("El cheque aún no está disponible para depósito. Fecha de pago: " + cheque.getFechaDePago());
        } else if (cheque.getMonto() <= 0) {
            System.out.println("El monto del cheque debe ser positivo o no nulo.");
        } else {
            this.saldo += cheque.getMonto();
            System.out.println("Cheque depositado por " + cheque.getMonto() + " pesos del banco " + cheque.getBancoEmisor() + ". Nuevo saldo: " + saldo);
        }
    }

}