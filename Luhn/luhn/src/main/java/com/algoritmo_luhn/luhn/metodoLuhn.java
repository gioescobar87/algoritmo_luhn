package com.algoritmo_luhn.luhn;

import java.util.Stack;

import javax.swing.JOptionPane;

public class metodoLuhn {

    Stack <Integer> pilaInvertidaOriginal = new Stack();
    

    public boolean parsear(char cadena[]){
        invertirOrden(cadena);
        return doblarSegundosDigitos();
    }

    private void invertirOrden(char cadena[]){
        for (char c : cadena) {
            System.out.println("valor en cadena: "+c);
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
                    nuevoNumero = 1+ (numeroDoble%10);
                    sumaMultiplo10+=nuevoNumero;
                }else{
                    sumaMultiplo10+=numeroDoble;
                }
            }else{
                sumaMultiplo10+=pilaInvertidaOriginal.peek();
                pilaInvertidaOriginal.peek();
            }
            indice++;
            pilaInvertidaOriginal.pop();
        }

        JOptionPane.showMessageDialog(null, sumaMultiplo10);

        if (sumaMultiplo10%10==0) {
            return true;
        }else{
            return false;
        }
    }
}
