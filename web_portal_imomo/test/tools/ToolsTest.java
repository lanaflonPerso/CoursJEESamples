/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raphaël
 */
public class ToolsTest
    {
    public ToolsTest()
        {
        }
    @BeforeClass
    public static void setUpClass()
        {
        }
    @AfterClass
    public static void tearDownClass()
        {
        }
    @Before
    public void setUp()
        {
        }
    @After
    public void tearDown()
        {
        }
    /**
     * Test of hashPassword method, of class Tools.
     */
    @Test
    public void testHashPassword()
        {
        List<String> listStrToHash = new ArrayList<String>();
        listStrToHash.add("123456");
        listStrToHash.add("Raphael Capocasale");
        listStrToHash.add("toto la praline");
        listStrToHash.add("Il ét@it un3 f#is éàèë");

        //These hashs SHA-512 come from online-convert web site
        List<String> listStrHashedTheoric = new ArrayList<String>();
        listStrHashedTheoric.add("ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413");
        listStrHashedTheoric.add("ee1a4c798d4f0466151fb42d51b6440461c28377d12c6ebf131b2ee332e03b487788b35b6ce5e59e52bd7f8b3ff1522b89f982defe71032833cd123f0c6d12ff");
        listStrHashedTheoric.add("1e22583085d64dfd995ee92db8f54c77e46611c41eed48a0d3824052e985bc734bb544e9fe32f88b60325e885b5ce407076c346b955b2f9f96c11af7fe708c05");
        listStrHashedTheoric.add("de0cf2837faef8d58b734ab4d72477ac1fa836fa2efcba774a501b0a2a2fa96a31d27c3306aae46ab0937eadca8421f7d0c8b2da2a31ac1c47fe6e640d0f0b3a");

        assertTrue(listStrHashedTheoric.get(0).equals(Tools.hashPassword(listStrToHash.get(0))));
        assertTrue(listStrHashedTheoric.get(1).equals(Tools.hashPassword(listStrToHash.get(1))));
        assertTrue(listStrHashedTheoric.get(2).equals(Tools.hashPassword(listStrToHash.get(2))));
        assertTrue(listStrHashedTheoric.get(3).equals(Tools.hashPassword(listStrToHash.get(3))));
        }
    }