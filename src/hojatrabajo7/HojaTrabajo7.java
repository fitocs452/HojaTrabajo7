/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hojatrabajo7;

/**
 *
 * @author Adolfo
 */
import javax.swing.JOptionPane;

public class HojaTrabajo7
{
    public static void main(String args[])
	{
            String valor = JOptionPane.showInputDialog("Por favor ingrese la expresión", "Ingrese Expresión");
                Huffman huffman = new Huffman(valor);
                System.out.println("Representación de árbol binario de expresión: " + huffman.hC.patronBitFinal);  
	}
}
