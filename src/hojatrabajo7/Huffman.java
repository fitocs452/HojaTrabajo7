package hojatrabajo7; 

/*
 Universidad del Valle de Guatemala
 Gustavo Adolfo Morales Martínez 13014
 Luis Duarte 13003
 Guatemala 07 de 09 de 2014
 Descripción: La presente clase contiene el algoritmo de Huffman con el que se crea el árbol
 */

/**
 *
 * @author Adolfo
 */
public class Huffman {
	
	private  char ArregloCaracteres[]; /*Variable para convertir el String en un arreglo de caracteres*/
	private  int tablaF[] = new int[0x7f]; /*Variable que contiene las frecuencias*/
        private  NodoH nodoM[]; 
	private  int tamTabla = 0;
        private  ArbolH arbolH; 
        private  int contNodo = 0;
        public  HuffmanT hC; 
        
        
        public Huffman(String valor)
        {
            frecuenciaTabla(valor);
            ordenarNodo();
            NodoH nodo = crearArbolH();
            hC = new HuffmanT(nodo,ArregloCaracteres);
        }
        public  void frecuenciaTabla(String value)
	{
		int i;
                ArregloCaracteres = value.toCharArray();
		for(i = 0; i < ArregloCaracteres.length; i++)
			tablaF[obtenerAscii(ArregloCaracteres[i])] += 1; 
	}
	
	public  int obtenerAscii(char substringValue)
	{
		return substringValue&0x7f;
	}
	
        public  void ordenarNodo()    
        {
            int cont = 0;
            int j = 0;
            for(int i = 0; i < tablaF.length; i++)
            {
                if(tablaF[i]>0)
                    cont++;
            }
            
            tamTabla =  cont;
            cont = 0;    
            nodoM = new NodoH[tamTabla];
            
            for(int i = 0; i < 127; i++)
            {
                if(tablaF[i] != 0)
                {
                    nodoM[cont]= new NodoH(tablaF[i], (char)i, null, null);
                    cont++;
                }
            }
            contNodo = nodoM.length;
            sort();
            
        }
        
        public  NodoH crearArbolH()
        {
           for(int i = 1; i < contNodo; i++)
           {

               if(nodoM[1].frecuenciaA >= nodoM[0].frecuenciaA)
               {
                   arbolH = new ArbolH(nodoM[0],nodoM[i]);
                   nodoM[0] = arbolH;
                   moverO(i, contNodo);
                   contNodo -= 1; 
                   i -= 1;
                   sort();
               }
               else
               {
                   if(i+1 < contNodo)
                   {
                        arbolH = new ArbolH(nodoM[i], nodoM[i+1]);
                        nodoM[1] = arbolH;
                        moverO(i+1, contNodo);
                        sort();
                        contNodo -= 1;
                        i -= 1;
                   }
                   else
                   {
                       nodoM[1] = nodoM[i];
                       nodoM[0] = new ArbolH(nodoM[0], nodoM[1]);
                   }
               }

           }
            return nodoM[0];
        }
        
        private  void moverO(int index, int length)
        {   try
            {
                for(int i = index; i < length; i++)
                    nodoM[i] = nodoM[i+1];
                
            }
            catch(Exception e)
            {
                System.out.println("Error");
            }
        }
        private  void sort()
        {
            NodoH temp;
            for(int i = contNodo-1; i > 1; i--)
            {
                for(int j = 0; j < i; j++)
                {
                    if(nodoM[j].frecuenciaA > nodoM[j+1].frecuenciaA)
                    {
                        temp = nodoM[j+1];
                        nodoM[j+1] = nodoM[j];
                        nodoM[j] = temp;
                    }
                    
                    if(nodoM[j].frecuenciaA == nodoM[j+1].frecuenciaA && nodoM[j].izq != null)
                    {
                        temp = nodoM[j+1];
                        nodoM[j+1] = nodoM[j];
                        nodoM[j] = temp;
                    }
                }
            }
        }
}
