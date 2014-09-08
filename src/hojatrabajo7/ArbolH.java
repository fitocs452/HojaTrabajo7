package hojatrabajo7;
/*
 Universidad del Valle de Guatemala
 Gustavo Adolfo Morales Martínez 13014
 Luis Duarte 13003
 Guatemala 07 de 09 de 2014
 Descripción: La presente clase tiene como fin el contener la estructura del árbol
 */

/**
 *
 * @author Adolfo
 */
public class ArbolH extends NodoH
{
    private NodoH ruta;
    
    public ArbolH()
    {
        ruta = null;
    }
    
    public ArbolH(NodoH node1, NodoH node2)
    {
        ruta = super.agregarNodo(node1, node2);
    }
    
    public void insertNode(int freq, char c)
    {
        ruta.frecuenciaA =  freq;
        ruta.caracter = c;
        ruta.izq = null;
        ruta.der = null;
    }
    
    public void insertNode(int frecuencia, char c, NodoH izq, NodoH der)
    {
        ruta.frecuenciaA =  frecuencia;
        ruta.caracter = c;
        this.ruta.izq = izq;
        this.ruta.der = der;
    }
    
    public void insertNode(NodoH node)
    {
        this.ruta.frecuenciaA = node.frecuenciaA;
        this.ruta.caracter = node.caracter;
        this.ruta.izq = node.izq;
        this.ruta.der = node.der;
    }
    
    public void insertNode(NodoH nodo1, NodoH nodo2)
    {
        ruta = super.agregarNodo(nodo1, nodo2);   
    }
}
