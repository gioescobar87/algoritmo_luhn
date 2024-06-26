package com.algoritmo_luhn.luhn;

import java.util.Stack;

import javax.swing.JOptionPane;

public class metodoLuhn {

    Stack <Integer> pilaOriginalInvertida = new Stack<>();
    String operacion = "";
    String numeroOriginal;

    public boolean parsear(char cadena[]){
        numeroOriginal = String.valueOf(cadena);
        invertirOrden(cadena);
        return doblarSegundosDigitos();
    }

    private void invertirOrden(char cadena[]){
        for (char c : cadena) {
            pilaOriginalInvertida.push(c-'0');
        }
    }

    private boolean doblarSegundosDigitos(){
        int indice = 0;
        int nuevoNumero;
        int sumaMultiplo10=0;
        while(pilaOriginalInvertida.size()>0){
            if (indice%2==1) {
                int numeroDoble = pilaOriginalInvertida.peek()*2;
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
                sumaMultiplo10+=pilaOriginalInvertida.peek();
                operacion+= (indice==0 ? "" : "+" )+pilaOriginalInvertida.peek();
            }
            indice++;
            pilaOriginalInvertida.pop();
        }

        JOptionPane.showMessageDialog(null, "Número ingresado: "+numeroOriginal+"\nResultado: "+operacion+" = "+sumaMultiplo10);

        if (sumaMultiplo10%10==0) {
            return true;
        }else{
            return false;
        }
    }
}
