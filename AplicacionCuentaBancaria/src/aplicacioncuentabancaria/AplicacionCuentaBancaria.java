/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacioncuentabancaria;

import java.util.Scanner;

/**
 *
 * @author Alex Recacha
 */
public class AplicacionCuentaBancaria {
    
    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        Scanner leer1 = new Scanner (System.in);
        int opcion = 0;
        String cuenta, titular;
        boolean bandera=false;
        while (bandera != true){
            System.out.println("Dime el nombre del titular");
            titular = leer.nextLine().trim();
            System.out.println("Dime el numero de cuenta");
            System.out.print("Entidad: ");
            cuenta = leer.nextLine().trim() + "-";
            System.out.print("Oficina: ");
            cuenta += leer.nextLine().trim() + "-";
            System.out.print("Digitos de control: ");
            cuenta += leer.nextLine().trim() + "-";
            System.out.print("Numero de Cuenta: ");
            cuenta += leer.nextLine().trim();
            CuentaBancaria cuenta1 = new CuentaBancaria(titular, cuenta);
            if (cuenta1.calcular()){

                bandera = true;

                while (opcion != 10){
                    Menu.pintaMenu();
                    System.out.println("Dime qué opcion eliges");
                    opcion = leer.nextInt();
                    switch(opcion){
                        case 1: System.out.println("Titular: " + cuenta1.getTitular());
                                System.out.println("CCC: " + cuenta1.getNumCuenta());
                                System.out.println("");
                                System.out.println("Pulsa una tecla para continuar...");
                                leer1.nextLine();
                                break;
                        case 2: System.out.println("Titular: " + cuenta1.getTitular());
                                System.out.println("");
                                System.out.println("Pulsa una tecla para continuar...");
                                leer1.nextLine();
                                break;
                        case 3: System.out.println("Entidad: " + cuenta1.verNumEntidad());
                                System.out.println("");
                                System.out.println("Pulsa una tecla para continuar...");
                                leer1.nextLine();
                                break;
                        case 4: System.out.println("Oficina: " + cuenta1.verNumOficina());
                                System.out.println("");
                                System.out.println("Pulsa una tecla para continuar...");
                                leer1.nextLine();
                                break;
                        case 5: System.out.println("Numero Cuenta: " + cuenta1.verNumCuenta());
                                System.out.println("");
                                System.out.println("Pulsa una tecla para continuar...");
                                leer1.nextLine();
                                break;
                        case 6: System.out.println("Digitos de control: " + cuenta1.verDc());
                                System.out.println("");
                                System.out.println("Pulsa una tecla para continuar...");
                                leer1.nextLine();
                                break;
                        case 7: System.out.println("¿Cuánto quieres ingresar?");
                                if (cuenta1.Ingresar(leer.nextDouble())){
                                    System.out.println("Ingreso realizado correctamente.");
                                }else{
                                    System.out.println("Fallo al ingresar, el banco se ha quedado con tu dinero, pringao.");
                                }
                                System.out.println("");
                                System.out.println("Pulsa una tecla para continuar...");
                                leer1.nextLine();
                                break;
                        case 8: System.out.println("¿Cuánto quieres retirar?");
                                if (cuenta1.Retirar(leer.nextDouble())){
                                    System.out.println("Retirada realizada correctamente.");
                                }else{
                                    System.out.println("Fallo al retirar, no te queda dinero, pringao.");
                                }
                                System.out.println("");
                                System.out.println("Pulsa una tecla para continuar...");
                                leer1.nextLine();
                                break;
                        case 9: System.out.println("Saldo actual: " + cuenta1.getSaldo());
                                System.out.println("");
                                System.out.println("Pulsa una tecla para continuar...");
                                leer1.nextLine();
                                break;
                        case 10: opcion = 10;
                                break;
                        default: 
                                break;
                    }
                }
            }
        }
    }
}
