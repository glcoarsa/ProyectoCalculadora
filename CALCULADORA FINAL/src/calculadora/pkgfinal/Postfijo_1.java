/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora.pkgfinal;

import java.util.ArrayList;

/**
 *
 * @author vic
 */
public class Postfijo_1{
    
    public static boolean revisarSintaxis2(String x){
        PilaADT pila=new PilaA();
        boolean res=true;
        int i=0;
        
        while(res && i<x.length()){
            switch (x.charAt(i)){
                case '(':
                   pila.push(x.charAt(i));
                    System.out.println(x.charAt(i)); //fjbergjhbhjgbehj
                   break;
                case ')':
                   if(pila.isEmpty()){
                       res=false;
                   }
                   else{
                       pila.pop();
                   }
                    System.out.println(x.charAt(i)); //fjbergjhbhjgbehj
                   break;
                case '+':
                case '*':
                case '^':
                   if(i==0||i==x.length()-1||esOperador2(x.charAt(i+1))||esOperador3(x.charAt(i+1))||x.charAt(i-1)=='('||x.charAt(i-1)=='.'||x.charAt(i+1)==')'){
                       res=false;
                   }
                    System.out.println(x.charAt(i)); //fjbergjhbhjgbehj
                    System.out.println(x.charAt(i+1)); //fjbergjhbhjgbehj
                   break;
                case'-':
                   if(i>0 && (i==x.length()-1||esOperador2(x.charAt(i+1))||esOperador3(x.charAt(i+1))||x.charAt(i-1)=='.'||x.charAt(i+1)==')')){
                       res=false;
                   }
                    System.out.println(x.charAt(i)); //fjbergjhbhjgbehj
                   break;
                case '/':
                    if(i==0||i==x.length()-1||esOperador2(x.charAt(i+1))||esOperador3(x.charAt(i+1))||x.charAt(i-1)=='('||x.charAt(i-1)=='.'||x.charAt(i+1)==')' || (x.charAt(i+1)=='0' && i+2>=x.length()) || (x.charAt(i+1)=='0' && x.charAt(i+2)!='.')){
                       res=false;
                   }
                    System.out.println(x.charAt(i)); //fjbergjhbhjgbehj
                    System.out.println(x.charAt(i+1)); //fjbergjhbhjgbehj
                   break;
                case'.':
                    if(i==x.length()-1||x.charAt(i+1)=='('||x.charAt(i+1)==')'||x.charAt(i+1)=='.'){
                       res=false;
                    }
                    System.out.println(x.charAt(i)); //fjbergjhbhjgbehj
                    break;
            }
            i++;
        }
         if(!pila.isEmpty()){
            res=false;
        }
        return res;
    }
    
    private static boolean esOperador2(char c){
        return c=='+'||c=='*'||c=='/'||c=='^';
    }
    
    private static boolean esOperador3(char c){
        return c=='-';
    }
    
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
                        if (cadena.charAt(i) == '-' && (i == 0 || (cadena.charAt(i-1)== '('  )) && cadena.charAt(i+1)!='(') {
                            //Si es un numero negativo, y es el primero (como si fuera un: -2+3)
                            // o si está despues de un signo de operacion o paréntesis izquierdo 
                            //y que no esté despues de un paréntesis derecho, se va a hacer '¬' como en lógica
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
    
    public static double resolverPostfijo(ArrayList lista1){
        PilaADT pila= new PilaA();
        int i=0;
        double i1,i2;
        
        while(i<lista1.size()){
            if(lista1.get(i) instanceof Double){
                pila.push(lista1.get(i));
                //System.out.println(pila.peek()); ///fguhegfhjebgjhefbg
                                                        //System.out.println(pila.toString());

                i++;
            }
            else{
                switch((Character)lista1.get(i)){
                    case '+':
                        i1=(double)pila.pop();
                        i2=(double)pila.pop();
                        pila.push(i2+i1);
                                       // System.out.println(pila.peek()); ///fguhegfhjebgjhefbg
                                       // System.out.println(pila.toString());

                        i++;
                        break;
                    case '-':
                        i2=(double)pila.pop();
                        if(pila.isEmpty()){
                            pila.push(i2*-1);
                                        //    System.out.println(pila.peek()); ///fguhegfhjebgjhefbg
                                        //System.out.println(pila.toString());

                        }
                        else{
                            i1=(double)pila.pop();
                            pila.push(i1-i2);
                                         //   System.out.println(pila.peek()); ///fguhegfhjebgjhefbg
                                        //System.out.println(pila.toString());

                        }
                        i++;
                        break;
                    case '*':
                        i1=(double)pila.pop();
                        i2=(double)pila.pop();
                        pila.push(i2*i1);
                                        //System.out.println(pila.peek()); ///fguhegfhjebgjhefbg
                                        //System.out.println(pila.toString());

                        i++;
                        break;
                    case '/':
                        i1=(double)pila.pop();
                        i2=(double)pila.pop();
                        pila.push(i2/i1);
                                       // System.out.println(pila.peek()); ///fguhegfhjebgjhefbg
                                       // System.out.println(pila.toString());

                        i++;
                        break;
                    case '^':
                        i1=(double)pila.pop();
                        i2=(double)pila.pop();
                        pila.push((Math.pow(i2, i1)));
                                        //System.out.println(pila.pop()); ///fguhegfhjebgjhefbg
                                       // System.out.println(pila.toString());

                        i++;
                        break;
                }
            }
        }
        
        return (double)pila.pop();
    }
    
    public static void main(String[] args) {
        String s1= "17.34^2-5*3-(1+.5)^2";
        ArrayList lista1=new ArrayList();
        ArrayList lista2=postfijo(s1);
        lista1.add(6.0);
        lista1.add(2.0);
        lista1.add('+');
        lista1.add(3.0);
        lista1.add('*');
        lista1.add(2.0);
        lista1.add(2.0);
        lista1.add('^');
        lista1.add('/');
        lista1.add(4.0);
        lista1.add('-');
        
        
        //System.out.println(revisarSintaxis(s1));
        //System.out.println(revisarSintaxis2(s1));
        System.out.println(postfijo(s1));
        
        //for(int i=0;i<lista2.size();i++){
       //     System.out.println(lista2.get(i).getClass());
        //}
        
        System.out.println(resolverPostfijo(lista2));
        
    }
    
    
}
