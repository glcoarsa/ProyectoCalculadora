/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora.pkgfinal;

/**
 * <pre>
 * Clase ExcepcionColeccionVacia
 * 
 * Sirve para mandar una excepción de casos específicos donde el cógido no funciona
 * </pre> 
 *
 * @author Gabiela López Coarasa
 * @author Victor Hugo Esperanza Díaz 
 * @author Braulio Alejandro Lozano Cuevas  
 * @author María del Carmen Suárez Flores
 * @author Eduardo Turriza Fortoul
 */
public class ExcepcionColeccionVacia extends RuntimeException{

     /**
     * Constructor vacío de ExcepcionColeccionVacia
     */

    public ExcepcionColeccionVacia() {
    }

    /**
     * Constructor de ExcepcionColeccionVacia
     */
    public ExcepcionColeccionVacia(String message) {
        super(message);
    }
    
    
    
}
