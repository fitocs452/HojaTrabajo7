package hojatrabajo7;

/*
 Universidad del Valle de Guatemala
 Gustavo Adolfo Morales Martínez 13014
 Luis Duarte 13003
 Guatemala 07 de 09 de 2014
 Descripción: La presente clase tiene como fin la creación de nodos
 */

/**
 *
 * @author Adolfo
 */
public class NodoH
{
    public int frecuenciaA;
    public char caracter;
    public NodoH izq;
    public NodoH der;
    
    public NodoH(){}
    
    public NodoH(int frecuencia, char carac, NodoH izq, NodoH der)
    {
        this.frecuenciaA = frecuencia;
        this.caracter = carac;
        this.izq = izq;
        this.der = der;
    }
    
    public NodoH agregarNodo(NodoH nodo1, NodoH nodo2)
    {
        if(nodo1.frecuenciaA < nodo2.frecuenciaA)
        {
            izq = nodo1;
            der = nodo2;
        }
        else
        {
            der = nodo1;
            izq = nodo2;
        }
        frecuenciaA = nodo1.frecuenciaA + nodo2.frecuenciaA;
        
        return this;
    }
    
}
