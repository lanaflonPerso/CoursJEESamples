/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nabil.ouerhani
 */
public class AlgoTest {
    
    public AlgoTest() {
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
     * Test of main method, of class Algo.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Algo.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AfficherCr method, of class Algo.
     */
    @Test
    public void testAfficherCr() {
        System.out.println("AfficherCr");
        int[] tab = null;
        int index = 0;
        int max = 0;
        Algo.AfficherCr(tab, index, max);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AfficherDec method, of class Algo.
     */
    @Test
    public void testAfficherDec() {
        System.out.println("AfficherDec");
        int[] tab = null;
        int index = 0;
        int max = 0;
        Algo.AfficherDec(tab, index, max);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}