package domain;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;


import javax.crypto.Cipher;

import static org.junit.Assert.*;

public class CirkelTest {

    private Punt geldigMiddelpunt;
    private int geldigeRadius;
    private Cirkel cirkel;

    @org.junit.Before
    public void setUp() {
        this.geldigMiddelpunt = new Punt(3, 2);
        this.geldigeRadius = 5;
        this.cirkel = new Cirkel(geldigMiddelpunt, geldigeRadius);
    }


    //  ik kan een cirkel aanmaken met een geldig middelpunt en een geldige straal
    @Test
    public void test_Cirkel_met_geldige_waarden() {
        Cirkel cirkel = new Cirkel(geldigMiddelpunt, geldigeRadius);
        assertNotNull(cirkel);
        assertEquals(geldigMiddelpunt, cirkel.getMiddelPunt());
        assertEquals(geldigeRadius, cirkel.getRadius());
    }
    //     ik krijg een exception wanneer ik een cirkel wil aanmaken met middelpunt = null

    @Test(expected = IllegalArgumentException.class)
    public void test_Cirkel_met_middelpunt_Met_null_als_waarde_Gooit_IllegalArgument_Exception() {
        new Cirkel(null, geldigeRadius);
    }

    //      ik krijg een exception wanneer ik een cirkel wil aanmaken met straal < 0
    @Test(expected = IllegalArgumentException.class)
    public void test_Cirkel_Met_negatief_getal_als_straal_Gooit_IllegalArgument_Exception() {
        new Cirkel(geldigMiddelpunt, -5);
    }

    //      ik krijg een exception wanneer ik een cirkel wil aanmaken met straal = 0

    @Test(expected = IllegalArgumentException.class)
    public void test_Cirkel_met_straal_gelijk_aan_0_Gooit_IllegalArgument_Exception() {
        new Cirkel(geldigMiddelpunt, 0);
    }


    //      Twee cirkels zijn gelijk wanneer ze hetzelfde middelpunt en dezelfde straal hebbe
    @Test
    public void Test_equals_2_geldige_gelijke_Cirkels() {
        Cirkel c1 = new Cirkel(geldigMiddelpunt, geldigeRadius);
        Cirkel c2 = new Cirkel(geldigMiddelpunt, geldigeRadius);
        assertTrue(c1.equals(c2));
    }

    //     Twee cirkels zijn verschillend wanneer de tweede cirkel null is
    @Test
    public void test_geldige_Cirkel_vergeleken_met_Cirkel_met_waarde_null_geeft_False() {
        assertFalse(cirkel.equals(null));
    }


    //     Twee cirkels zijn verschillend wanneer hun middelpunt verschillend  is
    @Test
    public void test_geldige_cirkel_met_geldige_cirkel_met_verschillend_middelpunt_geeft_false()
    {
        Cirkel cirkel1 = new Cirkel(geldigMiddelpunt, geldigeRadius);
        Cirkel cirkel2 = new Cirkel(new Punt(1,1),geldigeRadius);
        assertFalse(cirkel1.equals(cirkel2));
    }

    //     Twee cirkels zijn verschillend wanneer hun straal verschillend is

    @Test
    public  void test_geldige_cirkel_met_geldige_cirkel_met_andere_radius_geeft_false_bij_equals()
    {
        Cirkel cirkel1 = new Cirkel(geldigMiddelpunt, geldigeRadius);
        Cirkel cirkel2 = new Cirkel(geldigMiddelpunt,1);
        assertFalse(cirkel1.equals(cirkel2));
    }
    @Test
    public void test_omhullende_het_juiste_resultaat_geeft()
    {
        Punt p = new Punt(200,200);
        Cirkel c = new Cirkel(p,20);
        Punt p2 = new Punt(180,180);
        Omhullende o = new Omhullende(p2, 40,40);
        assertEquals(c.getOmhullende(),o);
    }
}