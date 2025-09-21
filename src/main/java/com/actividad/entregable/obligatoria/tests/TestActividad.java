package com.actividad.entregable.obligatoria.tests;

import java.util.Scanner;

import com.actividad.entregable.obligatoria.ejercicios.CajaAhorro;
import com.actividad.entregable.obligatoria.ejercicios.Cheque;
import com.actividad.entregable.obligatoria.ejercicios.Cliente;
import com.actividad.entregable.obligatoria.ejercicios.ClienteEmpresa;
import com.actividad.entregable.obligatoria.ejercicios.ClienteIndividual;
import com.actividad.entregable.obligatoria.ejercicios.Cuenta;
import com.actividad.entregable.obligatoria.ejercicios.CuentaConvertibilidad;
import com.actividad.entregable.obligatoria.ejercicios.CuentaCorriente;

public class TestActividad {
    public static void main(String[] args) {
        try ( // Se usa el try-with-resources para automatizar la gestión de recursos en el
              // bloque de código.
              // Inicialización de sistema bancario:
                Scanner teclado = new Scanner(System.in)) { // Se usa la clase Scanner para obtener datos primitivos (int, double, etc...) y cadenas.
            System.out.print("Ingrese su número de cliente: ");
            int nroCliente = teclado.nextInt();
            System.out.print("Ingrese el tipo de cliente (1-Individual, 2-Empresa): ");
            int tipoCliente = teclado.nextInt();
            Cliente cliente;
            if (tipoCliente == 1) {
                cliente = new ClienteIndividual(nroCliente, null, null, tipoCliente);
            } else {
                cliente = new ClienteEmpresa(nroCliente, null, tipoCliente);
            }
            if (!(tipoCliente == 1 || tipoCliente == 2)) {
                System.out.println("Tipo de cliente no válido.");
                return; // Finaliza la ejecucción de un método, sale del mismo.
            }
            if (cliente instanceof ClienteIndividual) { // Se usa el operador binario instanceof para verificar si el objeto pertenece a la clase.
                System.out.println("Ingrese su nombre:");
                String nombre = teclado.next();
                ((ClienteIndividual) cliente).setNombre(nombre);
                System.out.println("Ingrese su apellido:");
                String apellido = teclado.next();
                ((ClienteIndividual) cliente).setApellido(apellido);
                System.out.println("Ingrese su DNI:");
                int dni = teclado.nextInt();
                ((ClienteIndividual) cliente).setDni(dni);
            } else if (cliente instanceof ClienteEmpresa) { // Se usa el operador binario instanceof para verificar si el objeto pertenece a la clase.
                System.out.println("Ingrese su nombre de fantasia:");
                String nombreDeFantasia = teclado.next();
                ((ClienteEmpresa) cliente).setNombreDeFantasia(nombreDeFantasia);
                System.out.println("Ingrese su CUIT:");
                int cuit = teclado.nextInt();
                ((ClienteEmpresa) cliente).setCuit(cuit);
            }
            System.out.print(
                    "Ingrese el tipo de cuenta (1-Caja de Ahorro, 2-Cuenta Corriente, 3-Cuenta Convertibilidad):");
            int tipoCuenta = teclado.nextInt();
            Cuenta cuenta;
            if (tipoCuenta == 1) {
                cuenta = new CajaAhorro(tipoCuenta, cliente, 0);
            } else if (tipoCuenta == 2) {
                cuenta = new CuentaCorriente(tipoCuenta, cliente, 0, 500000);
                cuenta = new Cheque(null, null, 0, tipoCuenta, cliente, 0, 500000);
            } else {
                cuenta = new CuentaConvertibilidad(tipoCuenta, cliente, 0, 500000, 0);
            }
            if (!(tipoCuenta == 1 || tipoCuenta == 2 || tipoCuenta == 3)) {
                System.out.println("Tipo de cuenta no válido.");
                return; // Finaliza la ejecucción de un método, sale del mismo.
            }
            if (cliente instanceof ClienteIndividual) { // Se usa el operador binario instanceof para verificar si el objeto pertenece a la clase.
                if (tipoCuenta == 3) {
                    System.out.println("Esta cuenta no puede ser elegida por un cliente individual.");
                    return; // Finaliza la ejecucción de un método, sale del mismo.
                }
            }
            // Menú de operaciones:
            int operacion = 0;
            do {
                System.out.print(
                        "Ingrese la operación que desea realizar:\n"
                                + "0-Salir\n"
                                + "1-Depositar pesos\n"
                                + "2-Extraer pesos\n"
                                + "3-Depositar dólares (Solamente disponible en Cuenta convertibilidad)\n"
                                + "4-Extraer dólares (Solamente disponible en Cuenta convertibilidad)\n"
                                + "5-Depositar cheque (No disponible en Caja de ahorro)\n"
                                + "6-Cobrar intereses (Solamente disponible en Caja de ahorro)\n"
                                + "7-Convertir pesos a dólares (Solamente disponible en Cuenta convertibilidad)\n"
                                + "8-Convertir dólares a pesos (Solamente disponible en Cuenta convertibilidad)\n"
                                + "9-Consultar saldo en pesos\n"
                                + "10-Consultar saldo en dólares (Solamente disponible en Cuenta convertibilidad)\n"
                                + "11-Ver mi monto autorizado (No disponible en Caja de ahorro)\n"
                                + "Opción: ");
                operacion = teclado.nextInt();
                switch (operacion) { // Es una estructura de control que evalúa y ejecuta distintos bloques de código.
                    case 1: // Se usa para definir un bloque de código.
                        System.out.print("Ingrese el monto a depositar en pesos: ");
                        float montoDepositoPesos = teclado.nextFloat();
                        cuenta.depositarEfectivo(montoDepositoPesos);
                        break; // En este caso, se usa para salir de la sentencia.
                    case 2: // Se usa para definir un bloque de código.
                        if (cuenta instanceof CuentaCorriente || cuenta instanceof CuentaConvertibilidad) { // Se usa el operador binario instanceof para verificar si el objeto pertenece a la clase.
                            float limiteExtraccion = cuenta.getSaldo();
                            if (cuenta instanceof CuentaCorriente) {
                                limiteExtraccion += ((CuentaCorriente) cuenta).getMontoAutorizado();
                            } else if (cuenta instanceof CuentaConvertibilidad) {
                                limiteExtraccion += ((CuentaConvertibilidad) cuenta).getMontoAutorizado();
                            }
                            System.out.println("Límite de extracción (saldo + sobregiro): " + limiteExtraccion);
                            System.out.print("Ingrese el monto a extraer en pesos: ");
                            float montoExtraccionPesos = teclado.nextFloat();
                            cuenta.extraerEfectivo(montoExtraccionPesos);
                            break; // En este caso, se usa para salir de la sentencia.
                        } else if (cuenta instanceof CajaAhorro) {
                            System.out.print("Ingrese el monto a extraer en pesos: ");
                            float montoExtraccionPesos = teclado.nextFloat();
                            cuenta.extraerEfectivo(montoExtraccionPesos);
                            break; // En este caso, se usa para salir de la sentencia.
                        } else {
                            System.out.println("La cuenta no permite extracciones.");
                            break; // En este caso, se usa para salir de la sentencia.
                        }
                    case 3: // Se usa para definir un bloque de código.
                        if (cuenta instanceof CuentaConvertibilidad) { // Se usa el operador binario instanceof para verificar si el objeto pertenece a la clase.
                            System.out.print("Ingrese el monto a depositar en dólares: ");
                            float montoDepositoDolares = teclado.nextFloat();
                            ((CuentaConvertibilidad) cuenta).depositarDolares(montoDepositoDolares);
                        } else {
                            System.out.println("La cuenta no permite operaciones en dólares.");
                        }
                        break; // En este caso, se usa para salir de la sentencia.
                    case 4: // Se usa para definir un bloque de código.
                        if (cuenta instanceof CuentaConvertibilidad) { // Se usa el operador binario instanceof para verificar si el objeto pertenece a la clase.
                            System.out.print("Ingrese el monto a extraer en dólares: ");
                            float montoExtraccionDolares = teclado.nextFloat();
                            ((CuentaConvertibilidad) cuenta).extraerDolares(montoExtraccionDolares);
                        } else {
                            System.out.println("La cuenta no permite operaciones en dólares.");
                        }
                        break; // En este caso, se usa para salir de la sentencia.
                    case 5:
                        if (cuenta instanceof CuentaCorriente) { //Se usa el operador binario instanceof para verificar si el objeto pertenece a la clase.
                            System.out.print("Ingrese el monto del cheque a depositar en pesos: ");
                            float montoCheque = teclado.nextFloat();
                            System.out.print("Ingrese el banco emisor del cheque: ");
                            String bancoEmisor = teclado.next();
                            System.out.print("Ingrese la fecha de pago del cheque (AAAA-MM-DD): ");
                            String fechaPagoStr = teclado.next();
                            ((Cheque) cuenta).depositarCheque(montoCheque, bancoEmisor,
                                    java.time.LocalDate.parse(fechaPagoStr));
                        } else if (cuenta instanceof CuentaConvertibilidad) { //Se usa el operador binario instanceof para verificar si el objeto pertenece a la clase.
                            System.out.print("Ingrese el monto del cheque a depositar en pesos: ");
                            float montoCheque = teclado.nextFloat();
                            System.out.print("Ingrese el banco emisor del cheque: ");
                            String bancoEmisor = teclado.next();
                            System.out.print("Ingrese la fecha de pago del cheque (AAAA-MM-DD): ");
                            String fechaPagoStr = teclado.next();
                            ((CuentaConvertibilidad) cuenta).depositarCheque(montoCheque, bancoEmisor,
                                    java.time.LocalDate.parse(fechaPagoStr));
                        } else {
                            System.out.println("La cuenta no permite depósitos con cheque.");
                        }
                        break; //En este caso, se usa para salir de la sentencia.
                    case 6: // Se usa para definir un bloque de código.
                        if (cuenta instanceof CajaAhorro) { // Se usa el operador binario instanceof para verificar si el objeto pertenece a la clase.
                            System.out.print("Ingrese la tasa de interés anual (en %): ");
                            double tasaDeInteres = teclado.nextDouble();
                            System.out.print("Ingrese el tiempo en meses: ");
                            double tiempoEnMeses = teclado.nextDouble();
                            ((CajaAhorro) cuenta).cobrarInteres(tasaDeInteres, tiempoEnMeses);
                        } else {
                            System.out.println("La cuenta no genera intereses.");
                        }
                        break; // En este caso, se usa para salir de la sentencia.
                    case 7: // Se usa para definir un bloque de código.
                        if (cuenta instanceof CuentaConvertibilidad) { // Se usa el operador binario instanceof para verificar si el objeto pertenece a la clase.
                            System.out.print("Ingrese el monto en pesos a convertir a dólares: ");
                            float montoPesos = teclado.nextFloat();
                            ((CuentaConvertibilidad) cuenta).convertirPesosADolares(montoPesos);
                            ((CuentaConvertibilidad) cuenta).getSaldoEnDolares();
                        } else {
                            System.out.println("La cuenta no permite conversión de moneda.");
                        }
                        break; // En este caso, se usa para salir de la sentencia.
                    case 8: // Se usa para definir un bloque de código.
                        if (cuenta instanceof CuentaConvertibilidad) { // Se usa el operador binario instanceof para verificar si el objeto pertenece a la clase.
                            System.out.print("Ingrese el monto en dólares a convertir a pesos: ");
                            float montoDolares = teclado.nextFloat();
                            ((CuentaConvertibilidad) cuenta).convertirDolaresAPesos(montoDolares);
                            ((CuentaConvertibilidad) cuenta).getSaldo();
                        } else {
                            System.out.println("La cuenta no permite conversión de moneda.");
                        }
                        break; // En este caso, se usa para salir de la sentencia.
                    case 9: // Se usa para definir un bloque de código.
                        System.out.println("Saldo en pesos: " + cuenta.getSaldo());
                        break; // En este caso, se usa para salir de la sentencia.
                    case 10: // Se usa para definir un bloque de código.
                        if (cuenta instanceof CuentaConvertibilidad) { // Se usa el operador binario instanceof para verificar si el objeto pertenece a la clase.
                            System.out.println(
                                    "Saldo en dólares: " + ((CuentaConvertibilidad) cuenta).getSaldoEnDolares());
                        } else {
                            System.out.println("La cuenta no maneja saldo en dólares.");
                        }
                        break; // En este caso, se usa para salir de la sentencia.
                    case 11: // Se usa para definir un bloque de código.
                        if (cuenta instanceof CuentaCorriente) { // Se usa el operador binario instanceof para verificar si el objeto pertenece a la clase.
                            System.out.println("Monto autorizado (sobregiro) de la Cuenta Corriente: "
                                    + ((CuentaCorriente) cuenta).getMontoAutorizado());
                        } else if (cuenta instanceof CuentaConvertibilidad) {
                            System.out.println("Monto autorizado (sobregiro) de la Cuenta Convertibilidad: "
                                    + ((CuentaConvertibilidad) cuenta).getMontoAutorizado());
                        } else {
                            System.out.println("La cuenta no tiene monto autorizado.");
                        }
                        break; // En este caso, se usa para salir de la sentencia.
                    case 0: // Se usa para definir un bloque de código.
                        System.out.println("Saliendo del sistema...");
                        break; // En este caso, se usa para salir de la sentencia.
                    default:
                        System.out.println("Operación no válida.");
                        break; // En este caso, se usa para salir de la sentencia.
                }
            } while (operacion != 0); // Se finaliza el bucle al pulsar 0 en el menú de operaciones.
        }
    }
}
