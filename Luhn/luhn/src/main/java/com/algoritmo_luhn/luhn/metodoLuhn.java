package com.algoritmo_luhn.luhn;

import java.util.Stack;

import javax.swing.JOptionPane;

public class metodoLuhn {

    Stack <Integer> pilaInvertidaOriginal = new Stack();
    String operacion = "";


    public boolean parsear(char cadena[]){
        System.out.println(cadena);
        invertirOrden(cadena);
        return doblarSegundosDigitos();
    }

    private void invertirOrden(char cadena[]){
        for (char c : cadena) {
            pilaInvertidaOriginal.push(c-'0');
        }
    }

    private boolean doblarSegundosDigitos(){
        int indice = 0;
        int nuevoNumero;
        int sumaMultiplo10=0;
        while(pilaInvertidaOriginal.size()>0){
            if (indice%2==1) {
                int numeroDoble = pilaInvertidaOriginal.peek()*2;
                if (numeroDoble>9) {
                    int segundoDigito = numeroDoble%10;
                    nuevoNumero = 1+ (segundoDigito);
                    sumaMultiplo10+=nuevoNumero;
                    operacion+="+(1+"+numeroDoble%10+")";
                }else{
                    sumaMultiplo10+=numeroDoble;
                    operacion+="+"+numeroDoble;
                }
            }else{
                sumaMultiplo10+=pilaInvertidaOriginal.peek();
                operacion+= (indice==0 ? "" : "+" )+pilaInvertidaOriginal.peek();
            }
            indice++;
            pilaInvertidaOriginal.pop();
        }

        JOptionPane.showMessageDialog(null, "Resultado: "+operacion+" = "+sumaMultiplo10);

        if (sumaMultiplo10%10==0) {
            return true;
        }else{
            return false;
        }
    }
}
