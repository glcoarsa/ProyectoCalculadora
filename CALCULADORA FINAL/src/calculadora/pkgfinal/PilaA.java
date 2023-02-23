/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora.pkgfinal;

/**
 *
 * @author vic
 */
public class PilaA <T> implements PilaADT <T>{
    private T[] pila;
    private int tope;
    private final int MAX=100;

    public PilaA() {
        pila =(T[]) new Object[MAX];
        tope=-1;
    }
    
     public PilaA(int maximo) {
        pila =(T[]) new Object[maximo];
        tope=-1;
    }

    public void push(T dato) {
        if(tope==pila.length-1){
            expande();
        }
        tope++;
        pila[tope]=dato;
    }

    private void expande(){
        T[] masGrande= (T[]) new Object[pila.length*2];
        
        for(int i=0; i<=tope;i++){
            masGrande[i]=pila[i];
        }
        pila=masGrande;
    }
    
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
