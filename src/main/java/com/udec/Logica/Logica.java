package com.udec.Logica;
import java.util.Scanner;
/**
 * Esta clase continene las funciones que permiten el funcionamiento del programa
 * @since LetraNoRepetida 1.0
 * @version 1.0
 * @author Juan Ricardo Rodriguez Campos
 */
public class Logica {
    /**
     * contructor vacio de la clase
     */
    private int[] vector3;
    public Logica(){
        capturaDeDatos();
    }
    
    /**
     * metodo que captura la frase que se desea analizar 
     */
    public void capturaDeDatos(){
        //System.out.println("Digite la frase :");
        String frase = "";
        Scanner consola = new Scanner(System.in);
        frase=consola.nextLine();  
        //frase=frase.toLowerCase();
        char[] vector = frase.toCharArray();
        
        indice(vector);
        
    }
    
    /**
     * metodo que se encarga de recorrer y comparar la frase ingresada
     * @param vector que contiene la frase convertida en un array de tipo char
     */
    public void indice(char[] vector){
        char letra=vector[0];
        String letras="";
            for(int j=0;j<vector.length;j++){
                letras=letras+vector[j];
                if(letra!=vector[j]){
                    impresion(vector[j],letra);
                }
                if(letra==vector[j]){
                    letra=siguienteLetraRepetida(letras);
                    if(letra=='8'){
                        impresion(vector[j],'8');
                        int index = j+1;
                        if(index>=vector.length){
                            index=j;
                        }else{
                            letra=vector[index];
                        }                      
                    }else{
                        impresion(vector[j],letra);
                    }
                }
                repetidas(letras);
            }
    }
    
    /**
     * este metodo se encarga de buscar la letra que no tiene repeticion en lo que lleva el vector 
     * analizado
     * @param letras cadena String que contiene los caracteres que ya fueron anañizados.
     * @return letra - retorna el caracter que solo aparece una vez en la cadena.
     */
    public char siguienteLetraRepetida(String letras){
        char letra = 0;
        int indice = 0;
        int[] vector3=repetidas(letras);
        char[] vector = letras.toCharArray();
        for(int i=0;i<vector3.length;i++){
            if(vector3[i]==1){
                return letra=letras.charAt(i);
            }
        }        
        letra='8';   
            
        return letra;
    }
    
    /**
     * metodo que estructura un array que contiene las veces que se repiten cada
     * caracter de la cadena
     * [p,a,p,a]
     * [2,2,2,2]
     * @param letras cadena con las letras que ya fueron analizadas.
     * @return cadenaNumeros - array con veces que se repite cada caracter.
     */
    public int[] repetidas(String letras){
        char letra = 0;
        int contador=0;
        String cadenaNumeros="";
        char[] vector = letras.toCharArray();
        int[] vectorNumero = new int[vector.length];
        for(int i=0;i<vector.length;i++){
            letra=vector[i];
            for(int j=0;j<vector.length;j++){
                if(letra==vector[j]){
                    contador++;                   
                }
            }
            vectorNumero[i]=contador;
            contador=0;
        }
        for(int k=0;k<vectorNumero.length;k++){
            cadenaNumeros=cadenaNumeros+vectorNumero[k];
            
        }
        /*
        for(int k=0;k<vectorNumero.length;k++){
            System.out.print("[ "+vectorNumero[k]+" ]");
            
        }
     */
        return vectorNumero;
    }
    
    /**
     * metodo que imprime los mensajes del programa.
     * @param letra caracter que se esta leyendo
     * @param letra2 caracter que hasta el momento no tiene repeticiones
     * dentro del vector.
     */
    public void impresion(char letra,char letra2){
        if(letra2=='8'){
            System.out.println("----------------------");
            System.out.println("Leyendo :"+letra+" ");
            System.out.println("No hay letra que no se repita hasta este punto");
            System.out.println("----------------------");
        }else{
            System.out.println("-----------------------");
            System.out.println("Leyendo :"+letra+"     ");
            System.out.println("La letra que no repite es : "+letra2+" ");
            System.out.println("-----------------------");
        }
        
    }
    
}
