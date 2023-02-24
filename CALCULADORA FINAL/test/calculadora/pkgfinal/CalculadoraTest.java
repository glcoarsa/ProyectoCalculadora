/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package calculadora.pkgfinal;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vic
 */
public class CalculadoraTest {
    
    public CalculadoraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of revisarSintaxis2 method, of class Calculadora.
     */
    @Test
    public void testRevisarSintaxis2() {
        System.out.println("revisarSintaxis2");
        String x = "(-1)+(57)*";
        boolean expResult = false;
        boolean result = Calculadora.revisarSintaxis2(x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of jerarquia method, of class Calculadora.
     */
    @Test
    public void testJerarquia() {
        System.out.println("jerarquia");
        char signo = '+';
        int expResult = 1;
        int result = Calculadora.jerarquia(signo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of postfijo method, of class Calculadora.
     */
    @Test
    public void testPostfijo() {
        System.out.println("postfijo");
        String cadena = "3*(-6)+5/4*3";
        ArrayList lista1 = new ArrayList();
        lista1.add(3.0);
        lista1.add(-6.0);
        lista1.add('*');
        lista1.add(5.0);
        lista1.add(4.0);
        lista1.add('/');
        lista1.add(3.0);
        lista1.add('*');
        lista1.add('+');
        ArrayList expResult = lista1;
        ArrayList result = Calculadora.postfijo(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of resolverPostfijo method, of class Calculadora.
     */
    @Test
    public void testResolverPostfijo() {
        System.out.println("resolverPostfijo");
        ArrayList lista1 = new ArrayList();
        lista1.add(3.0);
        lista1.add(-6.0);
        lista1.add('*');
        lista1.add(5.0);
        lista1.add(4.0);
        lista1.add('/');
        lista1.add(3.0);
        lista1.add('*');
        lista1.add('+');
        double expResult =-14.25;
        double result = Calculadora.resolverPostfijo(lista1);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
