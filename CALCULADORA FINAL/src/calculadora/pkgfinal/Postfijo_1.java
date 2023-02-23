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
