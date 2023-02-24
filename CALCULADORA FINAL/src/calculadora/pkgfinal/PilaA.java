/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora.pkgfinal;

/**
 *<pre>
 * Clase PilaA
 * 
 * Representa una pila generica
 * Estructura abstracta
 * Tiene toda la funcionalidad esperada de una pila
 * </pre>
 * @author Gabiela López Coarasa
 * @author Victor Hugo Esperanza Díaz 
 * @author Braulio Alejandro Lozano Cuevas  
 * @author María del Carmen Suárez Flores
 * @author Eduardo Turriza Fortoul
 */
public class PilaA <T> implements PilaADT <T>{
    private T[] pila;
    private int tope;
    private final int MAX=100;

    /**
     * Constructor de PilaA
     */
    public PilaA() {
        pila =(T[]) new Object[MAX];
        tope=-1;
    }
    
    /**
     * Constructor de PilaA fijando una cantidad máxima de elementos
     */
     public PilaA(int maximo) {
        pila =(T[]) new Object[maximo];
        tope=-1;
    }
     
    /**
    * <pre>
    * Método push.
    * 
    * @param dato Para que funcione el método se necesita el dato que será dado de alta. 
    * 
    * Este método es el encargado de dar de alta nuevos datos a la pila, en caso de ser necesario se llamará al método "expande".
    * </pre>
    */ 
    public void push(T dato) {
        if(tope==pila.length-1){
            expande();
        }
        tope++;
        pila[tope]=dato;
    }
    
    /**
    * <pre>
    * Método expande.
    * 
    * Método encargado de alargar el arreglo en caso de que el espacio se haya terminado. 
    * </pre>
    */
    private void expande(){
        T[] masGrande= (T[]) new Object[pila.length*2];
        
        for(int i=0; i<=tope;i++){
            masGrande[i]=pila[i];
        }
        pila=masGrande;
    }
    
    /**
    * <pre>
    * Método pop
    * Elimina el último dato almacenado dentro de la pila. 
    * @return Regresa un dato de tipo object. 
    * @see isEmpty()
    * </pre>
    */
    public T pop() {
        if(isEmpty()){
            throw new ExcepcionColeccionVacia("La pila no tiene datos");
        }
        T eliminado=pila[tope];
        pila[tope]=null;
        tope--;
        return eliminado;
    }

    public boolean isEmpty() {
        return tope==-1; //si es verdadero, regresa verdadero, si no, regresa falso
    }

    /**
    * <pre>
    * Método peek 
    * Regresa el último dato almacenado dentro de la pila. 
    * @return Dato de tipo Object. 
    * @see isEmpty()
    * </pre>
    */
    public T peek() {
        if(isEmpty()){
            throw new ExcepcionColeccionVacia("La pila no tiene datos");
        }
        return pila[tope];
    }
    
    public String toString(){
        StringBuilder cad=new StringBuilder();
        
        for(int i=0;i<=tope;i++){
            cad.append(pila[i]+"\n");
        }
        return cad.toString();
    }
}
