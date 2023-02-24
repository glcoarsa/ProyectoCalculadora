/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora.pkgfinal;

/**
 * <pre>
 * Clase Pruebas 
 * 
 * Conriene un main con una serie de pruebas bajo distintos criterios de todos los métodos programados
 * </pre>
 *
 * @author Gabiela López Coarasa
 * @author Victor Hugo Esperanza Díaz 
 * @author Braulio Alejandro Lozano Cuevas  
 * @author María del Carmen Suárez Flores
 * @author Eduardo Turriza Fortoul
 */
public class Pruebas {
    
    public static void main(String[] args) {
        String s101="1++2";
        String s102="1+-2";
        String s103="1-+2";
        String s104="1*-2";
        String s105="1/-2";
        String s106="1/*2";
        String s107="1*-2";
        String s108="1^+2";
        String s109="1^-2";
        String s201="1+3((4)";
        String s202="1+3(4))";
        String s203="((1+3()(4)";
        String s3="2*4(-5+6.7584938.4)";
        String s4="-2^(-1/-2+2)";
        String s5="-7+(4^(3+5*(6-2+4-18^3)-190)+5)";
        String s6="(()())";
        String s7="(-(-(-9)))";
        String s8="5^(4/-3)";
        String s901="10/1..4";
        String s902="10/1.409+.4";
        String s903="1.0/1.4";        
        String s10="--6";
       
        String p1="-1-(4+5)";
        String p2="-1^(4/5)";
        String p3="2^(-1/-2+2)";
        String p4="5^(4/-3)";
        String p5="-3+2*(4-8^2+10+(-91))";
        String p6="7/0";
        String p7="7/0.";
        String p8="7/-0.1+3.4";
        String p9="7^(-2)";
        String p10="(-(-(-9))+3)";


        
        //pruebas de sintaxis
        //pruebas para doble signo 
        System.out.println(Calculadora.revisarSintaxis2(s101));
        System.out.println(Calculadora.revisarSintaxis2(s102));
        System.out.println(Calculadora.revisarSintaxis2(s103));
        System.out.println(Calculadora.revisarSintaxis2(s104));
        //único caso que debería estar correcto
        System.out.println(Calculadora.revisarSintaxis2(s105));
        System.out.println(Calculadora.revisarSintaxis2(s106));
        System.out.println(Calculadora.revisarSintaxis2(s107));
        System.out.println(Calculadora.revisarSintaxis2(s108));
        System.out.println(Calculadora.revisarSintaxis2(s109));
        
        //pruebas paréntesis incompletos o mal ordenados
        System.out.println(Calculadora.revisarSintaxis2(s201));
        System.out.println(Calculadora.revisarSintaxis2(s202));
        System.out.println(Calculadora.revisarSintaxis2(s203));
        
        //probar dos puntos en un mismo número
        System.out.println(Calculadora.revisarSintaxis2(s3));
        
        //probar un signo negativo que no represente resta, sino que el número en si es negativo (debería arrojarme que está bien escrito)
        System.out.println(Calculadora.revisarSintaxis2(s4));
        
        //probar una cadena larga de operaciones que combina operadores pero debería ser correcta
        System.out.println(Calculadora.revisarSintaxis2(s5));
        
        //probar paréntesis de nuevo
        System.out.println(Calculadora.revisarSintaxis2(s6));
        
        //probar si me permite poner símbolos negativos y que no los detecte como operadores sino como alteradores de signo
        System.out.println(Calculadora.revisarSintaxis2(s7));
        
        //probar si me deja usar un negativo como cambio de signo en medio de una operación
        System.out.println(Calculadora.revisarSintaxis2(s8));
        
        //probar los puntos consecutivamente
        System.out.println(Calculadora.revisarSintaxis2(s901));
        System.out.println(Calculadora.revisarSintaxis2(s902));
        System.out.println(Calculadora.revisarSintaxis2(s903));
       
        //probar si, por como está programado el método, no tiene algún fallo
        System.out.println(Calculadora.revisarSintaxis2(s10));
        
        
        //prueba cuando hay un negativo al inicio y cuando el negativo afecta el resultado de un paréntesis
        System.out.println(Calculadora.revisarSintaxis2(p1));
        System.out.println(Calculadora.postfijo(p1));
        System.out.println(Calculadora.resolverPostfijo(Calculadora.postfijo(p1)));
        
        System.out.println(Calculadora.revisarSintaxis2(p2));
        System.out.println(Calculadora.postfijo(p2));
        System.out.println(Calculadora.resolverPostfijo(Calculadora.postfijo(p2)));
        
        //probar si me lo resuelve correctamente, no aplicando el "-" como un menos, sino como un símbolo que cambia el signo del número
        System.out.println(Calculadora.revisarSintaxis2(p3));
        System.out.println(Calculadora.postfijo(p3));
        System.out.println(Calculadora.resolverPostfijo(Calculadora.postfijo(p3)));
        System.out.println(Calculadora.revisarSintaxis2(p4));
        System.out.println(Calculadora.postfijo(p4));
        System.out.println(Calculadora.resolverPostfijo(Calculadora.postfijo(p4)));
        
        //probar si aun respeta la jerarquía de operaciones así como si hace la distinción entre negativos y restas
        System.out.println(Calculadora.revisarSintaxis2(p5));
        System.out.println(Calculadora.postfijo(p5));
        System.out.println(Calculadora.resolverPostfijo(Calculadora.postfijo(p5)));
        
        //probar la división entre 0
        System.out.println(Calculadora.revisarSintaxis2(p6));
        System.out.println(Calculadora.postfijo(p6));
        System.out.println(Calculadora.resolverPostfijo(Calculadora.postfijo(p6)));
        
        //probar la división entre 0 pero que podría no tomarlo como 0
        System.out.println(Calculadora.revisarSintaxis2(p7));
        System.out.println(Calculadora.postfijo(p7));
        System.out.println(Calculadora.resolverPostfijo(Calculadora.postfijo(p7)));

        //comprobar que, a pesar de tener un 0, lo detecta como un número ya que es un decimal, no un 0
        System.out.println(Calculadora.revisarSintaxis2(p8));
        System.out.println(Calculadora.postfijo(p8));
        System.out.println(Calculadora.resolverPostfijo(Calculadora.postfijo(p8)));
        
        //elevar un número a una raíz negativa
        System.out.println(Calculadora.revisarSintaxis2(p9));
        System.out.println(Calculadora.postfijo(p9));
        System.out.println(Calculadora.resolverPostfijo(Calculadora.postfijo(p9)));

        //comprobar si los signos negativos se comportan de manera adecuada entre múltiples paréntesis
        System.out.println(Calculadora.revisarSintaxis2(p10));
        System.out.println(Calculadora.postfijo(p10));
        System.out.println(Calculadora.resolverPostfijo(Calculadora.postfijo(p10)));
    }
}
