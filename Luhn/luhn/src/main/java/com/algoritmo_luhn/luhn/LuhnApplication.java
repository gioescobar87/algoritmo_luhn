package com.algoritmo_luhn.luhn;

import javax.swing.JOptionPane;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LuhnApplication {

	public static void main(String[] args) {
		String numero = JOptionPane.showInputDialog("Ingrese el número a validar");
		char listaNumeros[] = numero.toCharArray();

		metodoLuhn evaluacion = new metodoLuhn();
		boolean resultado = evaluacion.parsear(listaNumeros);

		if (resultado) {
			JOptionPane.showMessageDialog(null, "Número válido");
		}else{
			JOptionPane.showMessageDialog(null, "Número inválido");
		}
	}

}
