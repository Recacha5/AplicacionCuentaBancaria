/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacioncuentabancaria;

/**
 *
 * @author Alex Recacha
 */
public class CuentaBancaria {
    
    private String titular;
    private String numCuenta;
    private String[] vCuenta;
    private double saldo;

    

    public CuentaBancaria(String titular, String numCuenta, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        vCuenta = this.numCuenta.split("-");
        if (comprobarDC() == true){
            this.numCuenta = numCuenta;
        }else{
            System.out.println("Numero de cuenta incorrecto");
        }
        
    }//constructor si diese el saldo

    public CuentaBancaria(String titular, String numCuenta) {
        this.titular = titular;
        vCuenta = numCuenta.split("-");
        if (comprobarDC() == true){//este "if" es para comprobar previamente que el numero de cuenta es correcto
            this.numCuenta = numCuenta;
        }else{
            System.out.println("Numero de cuenta incorrecto");
        }
    }//constructor si no da el saldo
    
    public String verNumEntidad(){
        return vCuenta[0];
    }
    public String verNumOficina(){
        return vCuenta[1];
    }
    public String verDc(){
        return vCuenta[2];
    }
    public String verNumCuenta(){
        return vCuenta[3];
    }
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    public String getNumCuenta() {
        return numCuenta;
    }
    
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean Ingresar(double ingreso){
        
        this.saldo += ingreso;
        return true;
        
    }  
    public boolean Retirar(double retirar){
        
        if (saldo > retirar){
            this.saldo -= retirar;
            return true;
        }else{
            return false;
        }

    }
    private boolean comprobarDC(){
//comprueba si el digito de control es correcto ademas de que se ha escrito bien el resto del numero de cuenta
//comprueba que no hay espacios
        for (int i = 0; i < 4; i++) {
            if (vCuenta[0].substring(i,i+1).equals(" ")){
                return false;
            }
            if (vCuenta[1].substring(i,i+1).equals(" ")){
                return false;
            }
        }
        for (int i = 0; i < 2; i++) {
            if (vCuenta[2].substring(i,i+1).equals(" ")){
                return false;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (vCuenta[3].substring(i,i+1).equals(" ")){
                return false;
            }
        }
        //comprueba que la longitud de la entidad, oficina, dc y numero de cuenta es correcta
        if (vCuenta[0].length() == 4 && vCuenta[1].length() == 4 && vCuenta[2].length() == 2 && vCuenta[3].length() == 10){
            int dc=0, dc1=0;
            String resultado;

            dc += Integer.valueOf(vCuenta[0].substring(0,1))*4;
            dc += Integer.valueOf(vCuenta[0].substring(1,2))*8;
            dc += Integer.valueOf(vCuenta[0].substring(2,3))*5;
            dc += Integer.valueOf(vCuenta[0].substring(3,4))*10;

            dc += Integer.valueOf(vCuenta[1].substring(0,1))*9;
            dc += Integer.valueOf(vCuenta[1].substring(1,2))*7;
            dc += Integer.valueOf(vCuenta[1].substring(2,3))*3;
            dc += Integer.valueOf(vCuenta[1].substring(3,4))*6;

            dc = 11-(dc%11);

            if (dc == 10){
                dc = 1;
            }
            if (dc == 11){
                dc = 0;
            }

            dc1 += Integer.valueOf(vCuenta[3].substring(0,1))*1;
            dc1 += Integer.valueOf(vCuenta[3].substring(1,2))*2;
            dc1 += Integer.valueOf(vCuenta[3].substring(2,3))*4;
            dc1 += Integer.valueOf(vCuenta[3].substring(3,4))*8;
            dc1 += Integer.valueOf(vCuenta[3].substring(4,5))*5;
            dc1 += Integer.valueOf(vCuenta[3].substring(5,6))*10;
            dc1 += Integer.valueOf(vCuenta[3].substring(6,7))*9;
            dc1 += Integer.valueOf(vCuenta[3].substring(7,8))*7;
            dc1 += Integer.valueOf(vCuenta[3].substring(8,9))*3;
            dc1 += Integer.valueOf(vCuenta[3].substring(9,10))*6;

            dc1 = 11-(dc1%11);

            if (dc1 == 10){
                dc1 = 1;
            }
            if (dc1 == 11){
                dc1 = 0;
            }
            resultado = String.valueOf(dc) + String.valueOf(dc1);

            if (resultado.equals(vCuenta[2])){
                return true;
            }
        }
            return false;
        
    }
    //como las operaciones que realizamos son ocultas al usuario, debemos devolver a un metodo para que lo envie al main
    public boolean calcular(){
        if (comprobarDC()){
            return true;
        }
        return false;
    }
}
