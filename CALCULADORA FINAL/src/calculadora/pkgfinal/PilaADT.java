/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package calculadora.pkgfinal;

/**
 * <pre>
 * Interface PilaADT
 * 
 * Determina el comportamiento y los métodos que serán utilizados por las clases hijas. 
 * </pre>
 * @author Gabiela López Coarasa
 * @author Victor Hugo Esperanza Díaz 
 * @author Braulio Alejandro Lozano Cuevas  
 * @author María del Carmen Suárez Flores
 * @author Eduardo Turriza Fortoul
 
 */
public interface PilaADT <T> {
    
    public void push(T dato);
    public T pop();
    public boolean isEmpty();
    public T peek();
}
