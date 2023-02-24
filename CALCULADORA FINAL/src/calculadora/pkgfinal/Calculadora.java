/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora.pkgfinal;

import java.util.ArrayList;

/**
 * <pre>
 * Clase Calculadora 
 * 
 * Contiene los métodos necesarios para poder hacer calculos de una expresión dada, por ejemplo: 
 * </pre>
 *  <ul>
 *      <li>Revisar si la sintaxis de la expresión es correcta</li> 
 *      <li>Saber si un signo es un operador</li> 
 *      <li>Saber la jerarquía de cada signo (operador)</li> 
 *      <li>Pasar la expresión de infijo a postfijo</li> 
 *      <li>Y finalmente resolver el postfijo o la expresión dada</li> 
 *  </ul>
 * 
 * @author Gabiela López Coarasa
 * @author Victor Hugo Esperanza Díaz 
 * @author Braulio Alejandro Lozano Cuevas  
 * @author María del Carmen Suárez Flores
 * @author Eduardo Turriza Fortoul
 */
public class Calculadora{
    
    /**
     * <pre>
     * Método revisarSintaxis
     * 
     * Este método revisa si la expresión dada esté bien 
     * escrita o no.
     * 
     * Revisa que los paréntesis estén bien balanceados 
     * y que los operadores estén bien puestos.
     * 
     * </pre>
     * @param x Que es la expresión que va a recibir la calculadora.
     * @see esOperador2
     * @see esOperador3
     * @return <ul> 
     *          <li>true: Si es que el usuario dio correctamente 
     *              la expresión </li> 
     *          <li>false: si es hay un problema con la sintaxis  </li> 
     *         </ul> 
     */
    public static boolean revisarSintaxis2(String x){
        PilaADT pila=new PilaA();
        boolean res=true;
        int i=0;
        
        while(res && i<x.length()){
            switch (x.charAt(i)){
                case '(':
                    if(i>0 && (!esOperador2(x.charAt(i-1))) && i>0 && (!esOperador3(x.charAt(i-1))) && i>0 && (x.charAt(i-1)!='(')){
                       res=false;
                    }
                    else{
                       pila.push(x.charAt(i));
                    }
                   break;
                case ')':
                   if(pila.isEmpty()){
                       res=false;
                   }
                   else{
                       pila.pop();
                   }
                   break;
                case '+':
                case '*':
                case '^':
                   if(i==0||i==x.length()-1||esOperador2(x.charAt(i+1))||esOperador3(x.charAt(i+1))||x.charAt(i-1)=='('||x.charAt(i-1)=='.'||x.charAt(i+1)==')'){
                       res=false;
                   }
                   break;
                case'-':
                   if(i>0 && (i==x.length()-1||esOperador2(x.charAt(i+1))||esOperador3(x.charAt(i+1))||esOperador3(x.charAt(i-1))||x.charAt(i-1)=='.'||x.charAt(i+1)==')')){
                       res=false;
                   }
                   break;
                case '/':
                    if(i==0||i==x.length()-1||esOperador2(x.charAt(i+1))||x.charAt(i-1)=='('||x.charAt(i-1)=='.'||x.charAt(i+1)==')' || (x.charAt(i+1)=='0' && i+2>=x.length()) || (x.charAt(i+1)=='0' && x.charAt(i+2)!='.')){
                       res=false;
                   }
                   break;
                case'.':
                    int temp=i+1;
                    while (res && temp<x.length() && !esOperador2(x.charAt(temp)) && !esOperador3(x.charAt(temp))){
                        try{
                            Integer.parseInt(String.valueOf(x.charAt(temp)));
                        }catch(Exception e){
                            if(x.charAt(temp)=='.')
                            res=false;
                        }
                        temp++;
                    }
                    if(i==x.length()-1||x.charAt(i+1)=='('||x.charAt(i+1)==')'||x.charAt(i+1)=='.'){
                       res=false;
                    }
                    break;
            }
            i++;
        }
         if(!pila.isEmpty()){
            res=false;
        }
        return res;
    }
    
    /**
     * <pre>
     * Método esOperador2
     * 
     * El programa revisa si lo que está leyendo es un operador
     * </pre>
     * @param c Que es el operador que lee en la expresion
     * @return <ul> 
     *          <li>true: Si es que es uno de los operadores de '+', '*', '/' y '^'. </li> 
     *          <li>false: si no es un operador de los de arriba. </li> 
     *         </ul> 
     */
    private static boolean esOperador2(char c){
        return c=='+'||c=='*'||c=='/'||c=='^';
    }
    
    /**
     * Método esOperador3
     * 
     * @param c Que es el operador que lee en la expresion
     * @return <ul> 
     *          <li>true: Si es que es un operador de '-'.</li> 
     *          <li>false: si no es un '-'. </li> 
     *         </ul> 
     */
    private static boolean esOperador3(char c){
        return c=='-';
    }
    
    /**
     * <pre>
     * Método Jerarquía
     * 
     * El método lee los operadores que se le dan y les da la jerarquía correspondiente
     * a cada uno para que se resuelvan de manera correcta.
     * </pre>
     * 
     * @param signo Que es el operador que lee en la expresion y da la jerarquía.
     * @return int <ul> 
     *          <li>1: Si es que es un operador de '+' o '-'.</li> 
     *          <li>2: Si es que es un operador de '*' o '/'.</li> 
     *          <li>3: Si es que es un operador de '^'.</li> 
     *          <li>-1: Si es que es otro operador.</li> 
     *         </ul> 
     */

    public static int jerarquia (char signo) {
        if (signo == '+' || signo == '-') {
            return 1;
        } else {
            if (signo == '*' || signo == '/') {
                return 2;
            } else {
                if (signo == '^') {
                    return 3;
                } else {
                    return -1;
                }
            }
        }
    }
    
    /**
    * Método postfijo
    *
    * El método convierte la expresión dada en infijo a postfijo
    * @see ExcepcionColeccionVacia
    * @see revisarSintaxis
    * @param cadena que es la expresión pero en caracteres y regresa
    * @return un arreglo con los caracteres en un ArrayList
    *
    */ 
    public static ArrayList postfijo (String cadena) {
        ArrayList  expresion = new ArrayList ();
        PilaA pila= new PilaA();
        boolean signo = true;
        
        int i=0;
        
        if (!revisarSintaxis2(cadena)) {
            throw new ExcepcionColeccionVacia ("Sintaxis inválida");
        }
        
        while (i<cadena.length()) {
            if (Character.isDigit(cadena.charAt(i)) || cadena.charAt(i) == '.') { //Si es un dígito o encuentra un decimal
                StringBuilder num = new StringBuilder ();
                while (i<cadena.length() && (Character.isDigit(cadena.charAt(i)) || cadena.charAt(i) == '.')) {
                    num.append(cadena.charAt(i)); //hacemos el double
                    i++;
                }
                if (!signo) {
                    expresion.add(Double.parseDouble(num.toString()) * -1);
                    signo = true;
                } else {
                    expresion.add(Double.parseDouble(num.toString())); //agregamos el double
                }
                
            } else {
                if (cadena.charAt(i) == '(') {
                    pila.push(cadena.charAt(i));
                    i++;
                } else {
                    if (cadena.charAt(i) == ')') {
                        while (!pila.isEmpty() && ((char) pila.peek() != '(')) {
                            expresion.add(pila.pop());
                        }
                        pila.pop();
                        i++;
                    } else {
                        if (cadena.charAt(i) == '-' && (i == 0 || (cadena.charAt(i-1)== '('  )) && cadena.charAt(i+1)!='(' || cadena.charAt(i-1)=='/' || cadena.charAt(i-1)=='*') {
                            signo = false;
                            i++;
                        }
                        else{
                            while (!pila.isEmpty() && jerarquia(cadena.charAt(i))<= jerarquia((char) pila.peek())) {
                                expresion.add(pila.pop());
                            }
                        pila.push(cadena.charAt(i));
                        i++;
                        }
                    }
                }
            }
        }
        while (!pila.isEmpty()) {
            expresion.add(pila.pop());
        }
        int j=0;
        
        
        return expresion;
    }
    
    /**
     * Método resolverPostfijo     
     *  Este método resolverá la operación que le sea otorgada en notación postfija.
     * @param lista1 El método necesita recibir una lista acomodada en notación postfija para poder funcionar.
     *  <ul>
     * <li>Se recibirá una lista conteniendo la operación en notación postfija.</li>
     * <li>Con ayuda de un while se recorre la lista en búsqueda de un número o un carácter. </li>
     * <li> En caso de ser un número se guardará directamente en la pila, de lo contrario la operación correspondiente será resuelta.</li>
     * </ul>
     * @return El método regresa el resultado de la operación.
     */

    public static double resolverPostfijo(ArrayList lista1){
        PilaADT pila= new PilaA();
        int i=0;
        double i1,i2;
        
        while(i<lista1.size()){
            if(lista1.get(i) instanceof Double){
                pila.push(lista1.get(i));
                i++;
            }
            else{
                switch((Character)lista1.get(i)){
                    case '+':
                        i1=(double)pila.pop();
                        i2=(double)pila.pop();
                        pila.push(i2+i1);
                        i++;
                        break;
                    case '-':
                        i2=(double)pila.pop();
                        if(pila.isEmpty()){
                            pila.push(i2*-1);
                        }
                        else{
                            i1=(double)pila.pop();
                            pila.push(i1-i2);
                        }
                        i++;
                        break;
                    case '*':
                        i1=(double)pila.pop();
                        i2=(double)pila.pop();
                        pila.push(i2*i1);
                        i++;
                        break;
                    case '/':
                        i1=(double)pila.pop();
                        i2=(double)pila.pop();
                        pila.push(i2/i1);
                        i++;
                        break;
                    case '^':
                        i1=(double)pila.pop();
                        i2=(double)pila.pop();
                        pila.push((Math.pow(i2, i1)));
                        i++;
                        break;
                }
            }
        }
        
        return (double)pila.pop();
    }
    
}
