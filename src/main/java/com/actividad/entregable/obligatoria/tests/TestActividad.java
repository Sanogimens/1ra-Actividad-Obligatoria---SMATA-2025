package com.actividad.entregable.obligatoria.tests;

import java.util.Scanner;
import com.actividad.entregable.obligatoria.ejercicios.CajaAhorro;
import com.actividad.entregable.obligatoria.ejercicios.Clientes;
import com.actividad.entregable.obligatoria.ejercicios.ClientesEmpresa;
import com.actividad.entregable.obligatoria.ejercicios.ClientesIndividuales;
import com.actividad.entregable.obligatoria.ejercicios.CuentaConvertibilidad;
import com.actividad.entregable.obligatoria.ejercicios.CuentaCorriente;
import com.actividad.entregable.obligatoria.ejercicios.Cuentas;

public class TestActividad {
    public static void main(String[] args) {
        try (// inicialización de sistema bancario:
                Scanner teclado = new Scanner(System.in)) {
            System.out.print("Ingrese su número de cliente: ");
            int nroCliente = teclado.nextInt();
            System.out.print("Ingrese el tipo de cliente (1-Individual, 2-Empresa): ");
            int tipoCliente = teclado.nextInt();
            Clientes cliente;
            if (tipoCliente == 1) {
                cliente = new ClientesIndividuales(nroCliente, null, null, tipoCliente);
            } else {
                cliente = new ClientesEmpresa(nroCliente, null, tipoCliente);
            }
            if (!(tipoCliente == 1 || tipoCliente == 2)) {
                System.out.println("Tipo de cliente no válido.");
                return;
            }
            if (cliente instanceof ClientesIndividuales) {
                System.out.println("Ingrese su nombre:");
                String nombre = teclado.next();
                ((ClientesIndividuales) cliente).setNombre(nombre);
                System.out.println("Ingrese su apellido:");
                String apellido = teclado.next();
                ((ClientesIndividuales) cliente).setApellido(apellido);
                System.out.println("Ingrese su DNI:");
                int dni = teclado.nextInt();
                ((ClientesIndividuales) cliente).setDni(dni);
            } else if (cliente instanceof ClientesEmpresa) {
                System.out.println("Ingrese su nombre de fantasia:");
                String nombreDeFantasia = teclado.next();
                ((ClientesEmpresa) cliente).setNombreDeFantasia(nombreDeFantasia);
                System.out.println("Ingrese su CUIT:");
                int cuit = teclado.nextInt();
                ((ClientesEmpresa) cliente).setCuit(cuit);
            }
            System.out.print(
                    "Ingrese el tipo de cuenta (1-Caja de Ahorro, 2-Cuenta Corriente, 3-Cuenta Convertibilidad): ");
            int tipoCuenta = teclado.nextInt();
            Cuentas cuenta;
            if (tipoCuenta == 1) {
                cuenta = new CajaAhorro(tipoCuenta, cliente, 0);
            } else if (tipoCuenta == 2) {
                cuenta = new CuentaCorriente(tipoCuenta, cliente, 0);
            } else {
                cuenta = new CuentaConvertibilidad(tipoCuenta, cliente, 0, 0);
            }
            if (!(tipoCuenta == 1 || tipoCuenta == 2 || tipoCuenta == 3)) {
                System.out.println("Tipo de cuenta no válido.");
                return;
            }

            // menú de operaciones:
int operacion = 0;
do {
    System.out.print(
            "Ingrese la operación que desea realizar:\n"
            + "0-Salir\n"
            + "1-Depositar pesos\n"
            + "2-Extraer pesos\n"
            + "3-Depositar dólares\n"
            + "4-Extraer dólares\n"
            + "5-Depositar cheque\n"
            + "6-Cobrar intereses\n"
            + "7-Convertir pesos a dólares\n"
            + "8-Convertir dólares a pesos\n"
            + "9-Consultar saldo en pesos\n"
            + "10-Consultar saldo en dólares\n"
            + "Opción: "
    );
    operacion = teclado.nextInt();

    switch (operacion) {
        case 1:
            System.out.print("Ingrese el monto a depositar en pesos: ");
            float montoDepositoPesos = teclado.nextFloat();
            cuenta.depositarEfectivo(montoDepositoPesos);
            break;
        case 2:
            System.out.print("Ingrese el monto a extraer en pesos: ");
            float montoExtraccionPesos = teclado.nextFloat();
            cuenta.extraerEfectivo(montoExtraccionPesos);
            break;
        case 3:
            if (cuenta instanceof CuentaConvertibilidad) {
                System.out.print("Ingrese el monto a depositar en dólares: ");
                float montoDepositoDolares = teclado.nextFloat();
                ((CuentaConvertibilidad) cuenta).depositarDolares(montoDepositoDolares);
            } else {
                System.out.println("La cuenta no permite operaciones en dólares.");
            }
            break;
        case 4:
            if (cuenta instanceof CuentaConvertibilidad) {
                System.out.print("Ingrese el monto a extraer en dólares: ");
                float montoExtraccionDolares = teclado.nextFloat();
                ((CuentaConvertibilidad) cuenta).extraerDolares(montoExtraccionDolares);
            } else {
                System.out.println("La cuenta no permite operaciones en dólares.");
            }
            break;
        case 5:
            if (cuenta instanceof CuentaCorriente) {
                System.out.print("Ingrese el monto del cheque a depositar en pesos: ");
                float montoCheque = teclado.nextFloat();
                System.out.print("Ingrese el banco emisor del cheque: ");
                String bancoEmisor = teclado.next();
                System.out.print("Ingrese la fecha de pago del cheque (AAAA-MM-DD): ");
                String fechaPagoStr = teclado.next();
                ((CuentaCorriente) cuenta).depositarCheques(montoCheque, bancoEmisor,
                        java.time.LocalDate.parse(fechaPagoStr));
            } else if (cuenta instanceof CuentaConvertibilidad) {
                System.out.print("Ingrese el monto del cheque a depositar en pesos: ");
                float montoCheque = teclado.nextFloat();
                System.out.print("Ingrese el banco emisor del cheque: ");
                String bancoEmisor = teclado.next();
                System.out.print("Ingrese la fecha de pago del cheque (AAAA-MM-DD): ");
                String fechaPagoStr = teclado.next();
                ((CuentaConvertibilidad) cuenta).depositarCheques(montoCheque, bancoEmisor,
                        java.time.LocalDate.parse(fechaPagoStr));
            } else {
                System.out.println("La cuenta no permite depósitos con cheque.");
            }
            break;
        case 6:
            if (cuenta instanceof CajaAhorro) {
                System.out.print("Ingrese la tasa de interés anual (en %): ");
                double tasaDeInteres = teclado.nextDouble();
                System.out.print("Ingrese el tiempo en meses: ");
                double tiempoEnMeses = teclado.nextDouble();
                ((CajaAhorro) cuenta).cobrarInteres(tasaDeInteres, tiempoEnMeses);
            } else {
                System.out.println("La cuenta no genera intereses.");
            }
            break;
        case 7:
            if (cuenta instanceof CuentaConvertibilidad) {
                System.out.print("Ingrese el monto en pesos a convertir a dólares: ");
                float montoPesos = teclado.nextFloat();
                ((CuentaConvertibilidad) cuenta).convertirPesosADolares(montoPesos);
                ((CuentaConvertibilidad) cuenta).getSaldoEnDolares();
            } else {
                System.out.println("La cuenta no permite conversión de moneda.");
            }
            break;
        case 8:
            if (cuenta instanceof CuentaConvertibilidad) {
                System.out.print("Ingrese el monto en dólares a convertir a pesos: ");
                float montoDolares = teclado.nextFloat();
                ((CuentaConvertibilidad) cuenta).convertirDolaresAPesos(montoDolares);
                ((CuentaConvertibilidad) cuenta).getSaldo();
            } else {
                System.out.println("La cuenta no permite conversión de moneda.");
            }
            break;
        case 9:
            System.out.println("Saldo en pesos: " + cuenta.getSaldo());
            break;
        case 10:
            if (cuenta instanceof CuentaConvertibilidad) {
                System.out.println("Saldo en dólares: " + ((CuentaConvertibilidad) cuenta).getSaldoEnDolares());
            } else {
                System.out.println("La cuenta no maneja saldo en dólares.");
            }
            break;
        case 0:
            System.out.println("Saliendo del sistema...");
            break;
        default:
            System.out.println("Operación no válida.");
            break;
    }
} while (operacion != 0);
        }
    }
}
