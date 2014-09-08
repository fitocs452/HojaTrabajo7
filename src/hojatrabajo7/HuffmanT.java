package hojatrabajo7;

/*
 Universidad del Valle de Guatemala
 Gustavo Adolfo Morales Martínez 13014
 Luis Duarte 13003
 Guatemala 07 de 09 de 2014
 Descripción: La presente clase tiene como fin el conectar la lógica del algoritmo y el controlador para 
              poder mostrar los resultados
 */

/**
 *
 * @author Adolfo
 */
public class HuffmanT
{
    private NodoH direccionNodo;
    private char arregloCharac[];
    public String patronBitFinal = "";
    
    public HuffmanT(NodoH Nodo, char [] arregloC)
    {
        String temp;
        direccionNodo = Nodo;
        this.arregloCharac = arregloC;
        for(int i = 0; i < arregloC.length; i++)
        {
            temp = buscarVal(direccionNodo, "", arregloC[i]);
            patronBitFinal += temp + " ";
            System.out.println("Valores: "+ arregloC[i] + " " + temp);
        }
    }
    
    public String buscarVal(NodoH direccionNodo, String valor,char caracter)
    {
        String valorL = "";
        if(direccionNodo != null)
        {
            if(direccionNodo.izq != null){
                valorL = buscarVal(direccionNodo.izq, valor + "0", caracter);
            }
            if(direccionNodo.caracter == caracter){
                return valor;
            }
            else
            {
                if(valorL == "")
                {
                    return buscarVal(direccionNodo.der, valor+"1",caracter);
                }
                else
                {
                    return valorL;
                }
            }
        }
        else
        {
            return "";
        }
    }
        
}
